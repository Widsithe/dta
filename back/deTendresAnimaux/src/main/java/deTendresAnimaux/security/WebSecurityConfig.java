package deTendresAnimaux.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationService userDetailsService;

	@Configuration
	@Order(SecurityProperties.BASIC_AUTH_ORDER-1)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().httpBasic()
			.and().addFilterBefore(new WebSecurityCorsFilter(), ChannelProcessingFilter.class)
			.authorizeRequests()
			.antMatchers("/", "/test", "/user").permitAll()
			.anyRequest().authenticated();
			
			System.out.println("BOUH");
		}
	}
	@Bean
    public WebSessionIdResolver webSessionIdResolver() {
        HeaderWebSessionIdResolver resolver = new HeaderWebSessionIdResolver();
        resolver.setHeaderName("X-AUTH-TOKEN");
        return resolver;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoEncodingEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationService authSecurity) throws Exception {
        auth.userDetailsService(authSecurity).passwordEncoder(passwordEncoder());
    }
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(new NoEncodingEncoder());
		return authProvider;
	}

}
