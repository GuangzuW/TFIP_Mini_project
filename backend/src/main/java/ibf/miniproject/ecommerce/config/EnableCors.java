package ibf.miniproject.ecommerce.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class EnableCors implements WebMvcConfigurer {

    private String path;
    private String origins;

    public EnableCors(String p, String o) {
        path = p;
        origins = o;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(path)
            .allowedOrigins(origins);
    }
    // private String path;

    // public EnableCors(String p) {
    //     path = p;
    // }

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    //     registry.addMapping(path)
    //         .allowedOrigins("*")
    //         .allowedMethods("*")
    //         .allowedHeaders("*");
    // }
    
}
