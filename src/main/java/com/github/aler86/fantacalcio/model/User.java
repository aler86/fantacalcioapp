package com.github.aler86.fantacalcio.model;


import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by ADMIN on 15/10/2014.
 */

@Entity
public class User extends JsonObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String username;


    @Column(nullable = false)
    private String password;





    @OneToMany(mappedBy = "user") //relazione 1 a molti
    private Set<Team> Team;//relazione 1 a molti

    @OneToOne //relazione 1 a 1
    private Profile profilo;//relazione 1 a 1


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

    public Set<Team> getTeam() {
        return Team;
    }

    public void setTeam(Set<Team> team) {
        Team = team;
    }
}

