package it.scp.resttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

    public static void main(String[] args) {
        new RestTemplateTest().callRest();
    }

    private void callRest2() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Begin /GET request!");
        String getUrl = "http://localhost:8080/prova/get?id=1&name=Mary&age=20";
        ResponseEntity<Customer> getResponse = restTemplate.getForEntity(getUrl, Customer.class);
        if(getResponse.getBody() != null){
            System.out.println("Response for Get Request: " + getResponse.getBody().toString());
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }

    private void callRest() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/prova/user";
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        UserBean bean = restTemplate.getForObject(url, UserBean.class);
        System.out.println("The object received from REST call : " + bean);
    }

}
