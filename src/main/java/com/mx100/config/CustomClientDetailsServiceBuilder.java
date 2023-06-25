package com.mx100.config;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

public class CustomClientDetailsServiceBuilder extends ClientDetailsServiceBuilder<JdbcClientDetailsServiceBuilder> {
	private Set<ClientDetails> clientDetails = new HashSet<ClientDetails>();	
	private DataSource dataSource;	
	private PasswordEncoder passwordEncoder;
	
	public CustomClientDetailsServiceBuilder dataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		return this;
	}
	
	public CustomClientDetailsServiceBuilder passwordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		return this;
	}
	
	@Override
	protected void addClient(String clientId, ClientDetails build) {
		clientDetails.add(build);
	}
	
	@Override
	protected ClientDetailsService performBuild() {
		try {
			JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
			if(passwordEncoder != null){
				clientDetailsService.setPasswordEncoder(passwordEncoder);
			}
			
			for(ClientDetails client : clientDetails){
				try {
					clientDetailsService.updateClientDetails(client);
				} catch (Exception e) {
					clientDetailsService.addClientDetails(client);
				}
			}
			return clientDetailsService;
		} catch (Exception e) {
			return null;
		}
	}
	
}
