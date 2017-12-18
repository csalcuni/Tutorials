package it.scp.spring.autowiring;

import it.scp.resttemplate.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    final
    MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping("/hello2")
    public @ResponseBody  String hello2() {
        System.out.println("Ciao ciao !");
        myService.printInfo();
        return "OK";
    }

    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserBean user() {
        UserBean userBean = new UserBean();

        userBean.setId("2");
        userBean.setUserId("02");
        userBean.setBody("User Body");
        userBean.setTitle("User Title");

        return userBean;
    }

}
