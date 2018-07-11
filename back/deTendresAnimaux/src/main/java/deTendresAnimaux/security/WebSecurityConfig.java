package deTendresAnimaux.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

	@Autowired
	MyAccessDeniedHandler myAccessDeniedHandler;

	@Autowired
	MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

	@Autowired
	MyAuthenticationFailureHandler myAuthenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ANCIENNE CONFIG
		// http.csrf().disable().httpBasic().and().cors().and()
		// .addFilterBefore(new WebSecurityCorsFilter(),
		// ChannelProcessingFilter.class).authorizeRequests()

		// .antMatchers("/", "/test", "/user").permitAll()
		// .anyRequest().authenticated();
		http.cors().and().sessionManagement().and().authorizeRequests().and().exceptionHandling()
				.authenticationEntryPoint(myAuthenticationEntryPoint).accessDeniedHandler(myAccessDeniedHandler).and()
				.formLogin().loginProcessingUrl("/authenticate").successHandler(myAuthenticationSuccessHandler)
				.failureHandler(myAuthenticationFailureHandler).usernameParameter("username")
				.passwordParameter("password").and().logout().logoutUrl("/logout")
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).permitAll().and().httpBasic().and()
				.csrf().disable();

	}

	//
	// @Bean public WebSessionIdResolver webSessionIdResolver() {
	// HeaderWebSessionIdResolver resolver = new HeaderWebSessionIdResolver();
	// resolver.setHeaderName("X-AUTH-TOKEN"); return resolver; }
	//
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new NoEncodingEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationService authenticationService)
			throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
	}

	/*
	 * @Bean public DaoAuthenticationProvider authProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService);
	 * authProvider.setPasswordEncoder(new NoEncodingEncoder()); return
	 * authProvider; }
	 */

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		// configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		// configuration.setAllowedHeaders(Arrays.asList("authorization",
		// "content-type", "x-auth-token"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		// configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;

	}

}
