package deTendresAnimaux.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationService userDetailsService;

	@Configuration
	@Order(1)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// http.csrf().disable().httpBasic().and().cors().and()
			// .addFilterBefore(new WebSecurityCorsFilter(),
			// ChannelProcessingFilter.class).authorizeRequests()

			// .antMatchers("/", "/test", "/user").permitAll()
			// .anyRequest().authenticated();
		}
	}

	/*
	 * @Bean public WebSessionIdResolver webSessionIdResolver() {
	 * HeaderWebSessionIdResolver resolver = new HeaderWebSessionIdResolver();
	 * resolver.setHeaderName("X-AUTH-TOKEN"); return resolver; }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * NoEncodingEncoder(); }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth,
	 * AuthenticationService authSecurity) throws Exception {
	 * auth.userDetailsService(authSecurity).passwordEncoder(passwordEncoder());
	 * }
	 * 
	 * @Bean public DaoAuthenticationProvider authProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService);
	 * authProvider.setPasswordEncoder(new NoEncodingEncoder()); return
	 * authProvider; }
	 */
	/*
	 * @Bean public CorsConfigurationSource corsConfigurationSource() {
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
	 * "PATCH", "DELETE", "OPTIONS"));
	 * configuration.setAllowedHeaders(Arrays.asList("authorization",
	 * "content-type", "x-auth-token"));
	 * configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/**", configuration); return source;
	 * 
	 * }
	 */
}
