package io.pivotal.fe.demo.resource

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.java.AbstractCloudConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.session.data.redis.config.ConfigureRedisAction
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableRedisHttpSession
@EnableDiscoveryClient
class Application extends WebSecurityConfigurerAdapter {

	@RequestMapping('/')
	def home() {
		[id: UUID.randomUUID().toString(), content: 'Hello from Resource']
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.httpBasic().disable()
	  http.authorizeRequests().anyRequest().authenticated()
	}
		
	static void main(String[] args) {
		SpringApplication.run Application, args
	}

}

@Configuration
@Profile("cloud")
public class RedisCloudConfig {
    
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}
