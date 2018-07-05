package deTendresAnimaux.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationService authenticationService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// The pages does not require login
		// .and().authorizeRequests().antMatchers("/*").permitAll().anyRequest().authenticated()
		// .and().addFilterBefore(new WebSecurityCorsFilter(),
		// ChannelProcessingFilter.class);

		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
		// .antMatchers("/api/**").permitAll().anyRequest();
		// .authenticated().and().httpBasic().and().csrf()
		// .disable().exceptionHandling().and().addFilterBefore(new
		// WebSecurityCorsFilter(), ChannelProcessingFilter.class);
		// The pages does not require login //
		 http.authorizeRequests() 
		    .antMatchers("/login").permitAll(); 
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new NoEncodingEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
	}

}
