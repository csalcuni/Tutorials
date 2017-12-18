package it.scp.spring.autowiring;

import it.scp.resttemplate.UserBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpringConfig.class);
        annotationConfigApplicationContext.refresh();
        MyService myService = annotationConfigApplicationContext.getBean(MyService.class);
        myService.printInfo();


        MyRestTemplate myRestTemplate = annotationConfigApplicationContext.getBean(MyRestTemplate.class);
        String url = "http://localhost:8080/prova/user";
        UserBean bean = myRestTemplate.getForObject(url, UserBean.class);
        System.out.println("Oggetto ricevuto da chiamata REST : " + bean);


    }

}
