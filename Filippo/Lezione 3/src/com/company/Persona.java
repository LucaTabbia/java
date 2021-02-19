package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    protected String nome;
    protected String cognome;
    protected Date dataNascita;
    protected int altezza;
    protected Sesso sesso;

    public Persona(String nome, String cognome, Date dataNascita, int altezza, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.altezza = altezza;
        this.sesso = sesso;
    }

    public Persona(String nome, String cognome, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    protected String getDataString() {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String data;
        try{
            data= simpleDateFormat.format(dataNascita);
        }catch(Exception e){
            data= "Non disponibile";
        }

        return
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + data +
                ", altezza=" + altezza +
                ", sesso=" + sesso
                ;
    }

    @Override
    public String toString() {
        return "Persona: {" + getDataString() + "}";
    }
}
