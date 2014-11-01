package com.github.aler86.fantacalcio.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ADMIN on 30/10/2014.
 */
public class League extends  JsonObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;


    @ManyToMany(mappedBy = "league") //relazione 1 a molti
    @JoinColumn(nullable = false)
    private Set<Team> Team;//relazione 1 a molti



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
