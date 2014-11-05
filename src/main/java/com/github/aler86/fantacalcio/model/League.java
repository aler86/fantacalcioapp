package com.github.aler86.fantacalcio.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ADMIN on 30/10/2014.
 */
@Entity
public class League extends  JsonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @ManyToMany(fetch = FetchType.EAGER) //relazione 1 a molti
    private Set<Team> team;//relazione 1 a molti



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




    public Set<Team> getTeam() {
        return team;
    }

    public void setTeam(Set<Team> team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
