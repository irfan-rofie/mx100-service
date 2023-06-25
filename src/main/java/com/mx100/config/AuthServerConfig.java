package com.mx100.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
	
	@Bean()
	protected AuthorizationCodeServices authorizationCodeServices() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}
		
	@Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) 
      throws Exception {  
        endpoints
        	.authorizationCodeServices(authorizationCodeServices())
        	.authenticationManager(authenticationManager)
    		.userDetailsService(userDetailsService)
    		.tokenStore(tokenStore());
    }
	
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {		
		CustomClientDetailsServiceBuilder clientBuilder = new CustomClientDetailsServiceBuilder();
		clientBuilder.dataSource(dataSource).withClient("client")
			.secret(passwordEncoder.encode("secret"))
			.authorizedGrantTypes("client_credentials", "password", "refresh_token")
			.accessTokenValiditySeconds(60 * 60 * 16)
			.refreshTokenValiditySeconds(60 * 60 * 16)
			.scopes("mx100")
			.and()
			.withClient("internal_client")
			.secret(passwordEncoder.encode("internal_secret"))
			.authorizedGrantTypes("client_credentials")
			.accessTokenValiditySeconds(31557600)
			.refreshTokenValiditySeconds(31557600)
			.scopes("internal")
			.authorities("Internal");
		clients.setBuilder(clientBuilder);		
    }
}
