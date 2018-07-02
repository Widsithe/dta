package deTendresAnimaux.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationService authenticationService;

@Override
protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	  
      // The pages does not require login
      http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

      // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
      // If no login, it will redirect to /login page.
      //http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

      // For ADMIN only.
      http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

      // When the user has logged in as XX.
      // But access a page that requires role YY,
      // AccessDeniedException will be thrown.
      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

      // Config for Login Form
      http.authorizeRequests().and().formLogin()//
              // Submit URL of login page.
              .loginProcessingUrl("/j_spring_security_check") // Submit URL
              .loginPage("/login")//
              .defaultSuccessUrl("/userAccountInfo")//
              .failureUrl("/login?error=true")//
              .usernameParameter("username")//
              .passwordParameter("password")
              // Config for Logout Page
              .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
		/*auth.jdbcAuthentication()
		.usersByUsernameQuery(
		"Select email, password, true as enabled from Utilisateur where email=?")
		.authoritiesByUsernameQuery(
		"Select u.email, r.description From Role r join Utilisateur u on u.role_id=r.id where u.email=?");*/
	}

}
