//package org.cyrol.auth.config;
//
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import static java.nio.charset.StandardCharsets.UTF_8;
//
//import java.io.IOException;
//
//@Configuration
//@EnableResourceServer
//@EnableConfigurationProperties(SecurityProperties.class)
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//
//    private static final String USER_API_ROOT_PATTERN = "/user/accounts/**";
//
//    private static final String CUSTOMER_API_ROOT_PATTERN = "/customer/accounts/**";
//
//    @Autowired
//    private SecurityProperties securityProperties;
//
//    @Autowired
//    private TokenStore tokenStore;
//
//
//    @Override
//    public void configure(final ResourceServerSecurityConfigurer resources) {
//        resources.tokenStore(tokenStore());
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.requestMatchers().and().authorizeRequests()
//                .antMatchers(HttpMethod.GET, USER_API_ROOT_PATTERN)
//                .access("#oauth2.hasScope('read') and (hasAuthority('ADMIN') or hasAuthority('SUPERVISOR'))")
//
//                .antMatchers(HttpMethod.POST, USER_API_ROOT_PATTERN)
//                .access("#oauth2.hasScope('read') and (hasAuthority('ADMIN') or hasAuthority('SUPERVISOR'))")
//
//                .antMatchers(HttpMethod.GET, CUSTOMER_API_ROOT_PATTERN)
//                .access("#oauth2.hasScope('read') and (hasAuthority('ADMIN') or hasAuthority('SUPERVISOR'))")
//
//                .antMatchers(HttpMethod.POST, CUSTOMER_API_ROOT_PATTERN)
//                .access("#oauth2.hasScope('read') and (hasAuthority('ADMIN') or hasAuthority('SUPERVISOR'))");
//    }
//
//
//
////    @Bean
////    public DefaultTokenServices tokenServices() {
////        DefaultTokenServices tokenServices = new DefaultTokenServices();
////        tokenServices.setTokenStore(tokenStore);
////        return tokenServices;
////    }
//
////    @Bean
////    public TokenStore tokenStore() {
////        if (tokenStore == null) {
////            tokenStore = new JwtTokenStore(jwtAccessTokenConverter());
////        }
////        return tokenStore;
////    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setVerifierKey(getPublicKeyAsString());
//        return converter;
//    }
//
//    private String getPublicKeyAsString() {
//        try {
//            return IOUtils.toString(securityProperties.getJwt().getPublicKey().getInputStream(), String.valueOf(UTF_8));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//}