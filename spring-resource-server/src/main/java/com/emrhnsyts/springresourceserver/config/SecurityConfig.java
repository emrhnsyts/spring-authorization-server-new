package com.emrhnsyts.springresourceserver.config;

import com.emrhnsyts.springresourceserver.util.JwtRoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtRoleConverter());

        http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/demo").hasRole("user");
        http.authorizeRequests().anyRequest().authenticated();

        http.oauth2ResourceServer().jwt().jwkSetUri("http://localhost:8000/oauth2/jwks")
                .jwtAuthenticationConverter(jwtAuthenticationConverter);


        return http.build();
    }

}
