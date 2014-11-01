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


   /* @Column(nullable = false)
    private User utente;
    */
    @OneToOne //relazione 1 a 1
    @JoinColumn(nullable=false)
     private User utente;//relazione 1 a 1

    @ManyToMany(mappedBy = "team") //relazione 1 a molti
    @JoinColumn(nullable = false)
    private Set<League> League;//relazione 1 a molti


    @OneToMany(mappedBy = "team") //relazione 1 a molti
    @JoinColumn(nullable = false)
    private Set<Player> Player;//relazione 1 a molti

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

    public Set<League> getLeague() {
        return League;
    }

    public void setLeague(Set<League> league) {
        League = league;
    }

    public Set<Player> getPlayer() {
        return Player;
    }

    public void setPlayer(Set<Player> player) {
        Player = player;
    }
}
