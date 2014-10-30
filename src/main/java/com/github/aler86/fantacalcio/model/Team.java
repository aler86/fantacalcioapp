package com.github.aler86.fantacalcio.model;

import javax.persistence.*;

import java.util.Set;

/**
 * Created by ADMIN on 30/10/2014.
 */

@Entity

public class Team extends JsonObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private User utente;

    @OneToOne //relazione 1 a 1
     private User user;//relazione 1 a 1


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public User getUtente() {
        return utente;
    }

    public void setUtente(User utente) {
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
