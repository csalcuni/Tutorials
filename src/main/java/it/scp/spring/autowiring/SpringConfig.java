package it.scp.spring.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "it.scp.spring.autowiring")
@PropertySource("classpath:config.properties")
@EnableWebMvc
public class SpringConfig {

    @Bean
    public MyComponent getMyComponent() {
        return new MyComponent();
    }

    @Bean
    public MyRestTemplate getMyRestTemplate() {
        MyRestTemplate myRestTemplate = new MyRestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
        messageConverters.add(map);
        myRestTemplate.setMessageConverters(messageConverters);

        return myRestTemplate;
    }
}
