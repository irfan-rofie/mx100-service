# Sample Job Portal



## Overview

MX100 is job portal which connects company and expert freelancer/part-timer. It always keeps
track of freelancer performance and the more jobs the freelancer completes, the more
benefits they gain.

## Objective

As back end developer you must provide API to
- Enable company to create and post job as well as view proposal for their job posts
- Enable freelance to view jobs and submit proposal to it

## User Requirement
- Employer can create job post, then they can either save it as a draft or publish it
- Freelancer can view list of published jobs
- Freelancer can only submit one proposal to any published job
- Employer can view proposal from freelancer for their job post

## Rule
- Developed API using java (Java 8 Version), spring boot, spring security
- Database used MySQL (MySQL 8.0.29 Version)
- Authentication system using oauth2 by [spring security](https://docs.spring.io/spring-security/reference/servlet/oauth2/index.html)

## Installation

- Create database mx100
- Import database table from [this](https://gitlab.com/irfanrofie/mx100-service/-/blob/main/mx100.sql) (Tables with the "oauth_" prefix are tables formed based on the needs of the Spring Security framework)
- Open postman application
- Import postman collection from [this](https://gitlab.com/irfanrofie/mx100-service/-/blob/main/MX100.postman_collection.json)
- Run application from IDE (when development i'm using Spring Tool Suite IDE)
- Default port is 8080. if need to change port, update this [file](https://gitlab.com/irfanrofie/mx100-service/-/blob/main/src/main/resources/application.properties) 


## User Account
```
1. Employer

   username 1 : employer1@ajobthing.com
   password 1 : employer1

   username 2 : employer2@ajobthing.com
   password 2 : employer2

2. Freelancer

   username 1 : freelancer1@ajobthing.com
   password 1 : freelancer1

   username 2 : freelancer2@ajobthing.com
   password 2 : freelancer2

```

## For Help
Feel free to send me an email to irfanrofie@gmail.com or whatsapp to +6285210039362 if you have any problems.

Thanks, 
Irfan Rofie
