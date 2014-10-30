package com.github.aler86.fantacalcio.model;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by ADMIN on 15/10/2014.
 */
public class User extends JsonObject {
    private String username;

    private String password;

    private Integer id;

    private Profile profilo;

    public User(){};

    public User(HttpServletRequest request) throws Exception {
    this.setUsername(this.validate(String.class,request.getParameter("Aler86")));
    this.setPassword(this.validate(String.class,request.getParameter("sirio")));
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Profile getProfilo() {
        return profilo;
    }

    public void setProfilo(Profile profilo) {
        this.profilo = profilo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

