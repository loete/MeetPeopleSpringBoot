package at.fh.swengs.meetpeople;

import at.fh.swengs.meetpeople.model.Categories;
import at.fh.swengs.meetpeople.model.CategoriesRepository;
import at.fh.swengs.meetpeople.model.MessagesRepository;
import at.fh.swengs.meetpeople.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MeetPeopleApplication {

    @Autowired
    CategoriesRepository Categories;

    @Autowired
    MessagesRepository Messages;

    @Autowired
    UserRepository User;


    public static void main(String[] args) {

        SpringApplication.run(MeetPeopleApplication.class, args);
    }

  /**  @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api").allowedOrigins("*");
            }
        };
    }**/

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @EnableWebSecurity
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        /**
         * This section defines the user accounts which can be used for authentication as well as the roles each user has.
         *
         * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication().//
                    withUser("user").password("user").roles("USER").and().//
                    withUser("admin").password("admin").roles("USER", "ADMIN");
        }

        /**
         * This section defines the security policy for the app.
         * <p>
         * <ul>
         * <li>BASIC authentication is supported (enough for this REST-based demo).</li>
         * <li>/employees is secured using URL security shown below.</li>
         * <li>CSRF headers are disabled since we are only testing the REST interface, not a web one.</li>
         * </ul>
         * NOTE: GET is not shown which defaults to permitted.
         *
         * @param http
         * @throws Exception
         * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
         */

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.httpBasic().and().authorizeRequests().//
                    antMatchers(HttpMethod.POST, "/Messages").hasRole("ADMIN").//
                    antMatchers(HttpMethod.PUT, "/Messages/**").hasRole("ADMIN").//
                    antMatchers(HttpMethod.PATCH, "/Messages/**").hasRole("ADMIN").
                    antMatchers(HttpMethod.GET, "/Categories").hasRole("ADMIN").and().//
                    csrf().disable();
        }
    }
}
