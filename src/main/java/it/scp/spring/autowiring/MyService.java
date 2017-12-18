package it.scp.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    MyComponent myComponent;

    public void printInfo() {
       System.out.println("Bentornato " + myComponent.getNome() + " " + myComponent.getCognome() + " " + myComponent.getSesso());
    }

}
