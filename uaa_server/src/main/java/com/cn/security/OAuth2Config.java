package com.cn.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;

@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("EUREKA-CLIENT")
                .secret("abcd")
                .scopes("server")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600);
    }

    public JwtAccessTokenConverter jwtAccessTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("12345");
        return null;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(jwtAccessTokenEnhancer())
                .authenticationManager(authenticationManager);
        super.configure(endpoints);
    }


}
