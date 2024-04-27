package unipi.uml.rentaridebackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import unipi.uml.rentaridebackend.filter.JwtAuthFilter;
import unipi.uml.rentaridebackend.repository.UserRepository;
import unipi.uml.rentaridebackend.service.security.UserDetailsServiceImpl;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    private final JwtAuthFilter authFilter;

    private final UserRepository repository;

    public SecurityConfig(UserRepository repository, JwtAuthFilter authFilter) {
        this.repository = repository;
        this.authFilter = authFilter;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(repository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger-resources/*")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/v3/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/users/new")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/auth/generateToken")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/users/delete/{userId}")).hasAnyRole("ADMIN")
                                .anyRequest().authenticated()

                );
        http.authenticationProvider(authenticationProvider()).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf((csrf) ->
                csrf.ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2-console/**"),
                        new AntPathRequestMatcher("/auth/**"),
                        new AntPathRequestMatcher("/users/**"),
                        new AntPathRequestMatcher("/login")
                ).csrfTokenRepository(
                        CookieCsrfTokenRepository.withHttpOnlyFalse()
                )
        );
        http
                .cors(Customizer.withDefaults())
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        http.csrf(AbstractHttpConfigurer::disable);
        http.headers((headers) -> headers
                .frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable
                )
        );
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:????"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type","Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
