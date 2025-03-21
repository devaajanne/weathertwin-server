package app.weathertwin;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * This configuration class holds the application's CORS config.
 */
@Configuration
public class CorsConfig {

    /**
     * Here we set the configuration for cross-origin resource sharing so that our
     * front-end client can send requests to our back-end server.
     *
     * @return a CorsConfigurationSource object configured with the specified CORS settings.
     */
    @Bean
    public CorsConfigurationSource getCorsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of("https://devaajanne.github.io"));
        corsConfig.setAllowedMethods(List.of("POST", "OPTIONS")); // OPTIONS is needed due to pre-flight
        corsConfig.setAllowedHeaders(List.of("Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return source;
    }
}
