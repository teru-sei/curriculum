package com.cmind.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
    //フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                            "/images/**",
                            "/css/**",
                            "/javascript/**"
                            );
    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                //「login.html」はログイン不要でアクセス可能に設定
	                .antMatchers("/login").permitAll()
	                //上記以外は直リンク禁止
	                .anyRequest().authenticated()
	            .and()
	            .formLogin()
	                //ログイン処理のパス
	                .loginProcessingUrl("/login")
	                //ログインページ
	                .loginPage("/login")
	                //ログインエラー時の遷移先 ※パラメーターに「error」を付与
	                .failureUrl("/login?error")
	                //ログイン成功時の遷移先
	                .defaultSuccessUrl("/hello", true)
	                //ログイン時のキー：名前
	                .usernameParameter("username")
	                //ログイン時のパスワード
	                .passwordParameter("password")
	            .and()
	            .logout()
	                //ログアウト時の遷移先 POSTでアクセス
	                .logoutSuccessUrl("/login");
	    }

	    @Autowired
	    LoginUserDetailsService service;
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(service);
	    }
	
		
}
