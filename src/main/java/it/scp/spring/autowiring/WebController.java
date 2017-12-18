package it.scp.spring.autowiring;

import it.scp.resttemplate.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody Customer get(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("age") int age) {
        String info = String.format("/GET info: id=%d, name=%s, age=%d", id, name, age);
        System.out.println(info);
        return new Customer(id, name, age);
    }
}
