package com.example.martinasalis.esercitazionebonus;

import java.io.Serializable;

public class Utente implements Serializable {

    private String username;
    private String password;

    public Utente()
    {
        this.username="";
        this.password="";
    }

    public Utente(String username, String password){
            this.username = username;
            this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
