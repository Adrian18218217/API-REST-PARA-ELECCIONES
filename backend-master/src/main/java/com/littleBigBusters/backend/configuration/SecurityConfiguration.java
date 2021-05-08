package com.littleBigBusters.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.littleBigBusters.backend.filter.JwtRequestFilter;
import com.littleBigBusters.backend.util.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("myUserDetailService")
	private UserDetailsService _myUserDetailService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers("/login").permitAll()
//				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
//				.and().formLogin().loginPage("/app/login").permitAll()
//				.failureUrl("/app/login?error=true")
//				.defaultSuccessUrl("/swagger-ui.html")
				.and()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")    // <---------- You need this
                .antMatchers(
                        "/**/*.{js,html,css,ico}",
                        "/i18n/**",
                        "/assets/**",
                        "/v2/api-docs/**",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html");
    }
	
	
	
	@Override
	@Bean(name = "authenticationManager") 
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ROL_USER");
//    }

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
