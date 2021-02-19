package com.company;

public class Studente extends Persona {
    private int id;

    public Studente(String nome, String cognome, Sesso sesso, int id) {
        super(nome, cognome, sesso);
        this.id=id;
    }

    @Override
    public String toString() {
        return "Studente: {" + "id=" + id+ getDataString()+ "}";
    }
}
