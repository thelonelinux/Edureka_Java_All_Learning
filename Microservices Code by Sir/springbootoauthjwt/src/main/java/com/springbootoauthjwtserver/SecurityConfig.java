package com.springbootoauthjwtserver;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

/**
 * new Spring authorization server framework. This framework comes as a 
 * replacement for the capability to build an OAuth authorization server 
 * after the deprecation of the Spring Security OAuth project. 
 * The Spring Security OAuth project needed to be deprecated. 
 * It was only offering support for the OAuth 1 specification, 
 * and building a reliable OAuth 2/OpenID Connect using it was not easy. 
 * The part that refers to the client 
 * and the resource server moved directly into Spring Security, 
 * while the authorization server part has been extracted into a separate 
 * framework, which we’ll discuss in this article
 * @author HP
 *
 */

@Configuration
public class SecurityConfig  {
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
	    OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
	    return http.build();
	}
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/newoauthclientdb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("secret");
	    return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
 
    /*@Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/oauth/token").permitAll()
	  	.antMatchers("/check_token").permitAll()
        .anyRequest().authenticated()
	  	.and()
	  	.httpBasic();
    }*/
 
	/*
	 * OAuth2 is a protocol used to authorize access to resources on behalf 
	 * of a user by allowing a third-party application to access 
	 * the user's 
	 * data stored on a server without sharing the user's credentials 
	 * with the application. In other words, OAuth2 is primarily used 
	 * for authorization. It is commonly used by social media platforms 
	 * to allow third-party applications to access a user's data, 
	 * such as their name, profile picture, and friend list.

		On the other hand, OpenID Connect (OIDC) is a protocol that builds 
		on top of OAuth2 and provides authentication capabilities. 
		It allows users to authenticate to a service provider 
		(e.g., a website or mobile app) using an identity provider 
		(e.g., Google or Facebook) without the service provider needing 
		to store the user's credentials. 
		OIDC adds an identity layer to OAuth2, which makes it possible 
		to authenticate users
	 */
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
       /* RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
          .clientId("oauth-client")
          .clientSecret("{noop}oauth-secret")
          .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
          .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
          .scope(OidcScopes.OPENID)
          .scope("articles.read")
          .build();
        return new InMemoryRegisteredClientRepository(registeredClient);*/
    	return new JdbcRegisteredClientRepository(jdbcTemplate());
    	
    }
    
    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }
    
    //jwkSource-what keypairs it can sign/validate jwt's
    @Bean
    public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
        RSAKey rsaKey = generateRsa();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    private static RSAKey generateRsa() throws NoSuchAlgorithmException {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey)
          .privateKey(privateKey)
          .keyID(UUID.randomUUID().toString())
          .build();
    }

    private static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }
    
    //provide end points that can be called by client
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }


}