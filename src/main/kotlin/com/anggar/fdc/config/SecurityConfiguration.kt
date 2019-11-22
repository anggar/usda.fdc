package com.anggar.fdc.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import com.anggar.fdc.service.MongoUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder


@Configuration
@EnableConfigurationProperties
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    var userDetailsService: MongoUserDetailsService? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().anonymous()
                .and().httpBasic()
                .and().sessionManagement().disable()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    public override fun configure(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService<MongoUserDetailsService>(userDetailsService)
    }

}