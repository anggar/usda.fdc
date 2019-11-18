package com.anggar.fdc.service

import com.anggar.fdc.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class MongoUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var repository: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails  {
        val user = repository.findByUsername(username) ?: throw UsernameNotFoundException("User not found")

        return AppUserPrincipal(user)
    }

}
