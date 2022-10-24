package com.exemple.gestcom.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class articole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long ARTICOL_ID;

    private String Nume_articol,Cod_machet;
    private Long Cantitate_croita,Cantitate_cusuta,Cantitate_ambalata;

    public String getNume_articol(){return Nume_articol;}
    public void setNume_articol(String Nume_articol){
        this.Nume_articol = Nume_articol;
    }
    public String getCod_machet(){
        return Cod_machet;
    }
    public void setCod_machet(String Cod_machet){
        this.Cod_machet = Cod_machet;
    }

    public Long getCantitate_croita(){return Cantitate_croita;}
    public void setCantitate_croita(Long Cantitate_croita){
        this.Cantitate_croita = Cantitate_croita;
    }
    public Long getCantitate_cusuta(){
        return Cantitate_cusuta;
    }
    public void setCantitate_cusuta(Long Cantitate_cusuta){
        this.Cantitate_cusuta = Cantitate_cusuta;
    }
    public Long getCantitate_ambalata(){
        return Cantitate_ambalata;
    }
    public void setCantitate_ambalata(Long Cantitate_ambalata){
        this.Cantitate_ambalata = Cantitate_ambalata;
    }

    public articole(){
    }
    public articole(String Nume_articol,String Cod_machet){
        this.Nume_articol=Nume_articol;
        this.Cod_machet=Cod_machet;

    }
}
