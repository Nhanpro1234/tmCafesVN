package com.tm.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.codec.Base64;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public Base64 base64() {
		return new Base64();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT taiKhoan, matKhau, 1 FROM tai_khoan WHERE taiKhoan = ?")
			.authoritiesByUsernameQuery("SELECT taiKhoan, role FROM tai_khoan  WHERE taiKhoan = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
					.antMatchers("/").permitAll()

					.antMatchers("/trang-chu").hasAnyRole("ADMIN", "KE_TOAN", "THU_NGAN")
					.antMatchers("/api/**").hasAnyRole("ADMIN", "KE_TOAN", "THU_NGAN")
					.antMatchers("/quan-li/doanh-thu").hasAnyRole("ADMIN", "THU_NGAN", "KE_TOAN")
					.antMatchers("/quan-li/**").hasAnyRole("ADMIN", "KE_TOAN")
					.antMatchers("/thu-ngan/**").hasAnyRole("ADMIN", "THU_NGAN")
					.antMatchers("/quan-li/nhan-vien").hasRole("ADMIN")
					
					
					.anyRequest().permitAll()
				.and()
	      			.formLogin()
	      			.loginPage("/dang-nhap")
	      			.loginProcessingUrl("/login")
	      			.defaultSuccessUrl("/trang-chu")
	      			.failureUrl("/dang-nhap?error=false")
	      		.and()
	      			.exceptionHandling()
	      			.accessDeniedPage("/404");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
}
