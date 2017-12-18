package it.scp.spring.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class MyComponent {

    @Value("${nome}")
    private String nome;
    @Value("${cognome}")
    private String cognome;
    @Value("${sesso}")
    private String sesso;

    public MyComponent() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
}
