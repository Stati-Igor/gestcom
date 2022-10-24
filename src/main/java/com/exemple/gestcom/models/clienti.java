package com.exemple.gestcom.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class clienti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long ID_CLIENT;

    private String Nume_client,Telefon_client;
    public String getNume_client(){return Nume_client;}
    public void setNume_client(String Nume_client){
        this.Nume_client = Nume_client;
    }
    public String getTelefon_client(){
        return Telefon_client;
    }
    public void setTelefon_client(String Telefon_client){
        this.Telefon_client = Telefon_client;
    }

    public clienti(){
    }
    public clienti(String Nume_client,String Telefon_client){
        this.Nume_client=Nume_client;
        this.Telefon_client=Telefon_client;

    }
}

