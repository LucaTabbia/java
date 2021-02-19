package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Persona paolo= new Persona("Paolo","Rossi",Sesso.M);
        System.out.println(paolo);
        Studente gianni= new Studente("Gianni", "Bianchi", Sesso.M, 1);
        System.out.println(gianni);
        System.out.println(Compito.getNextId());
        Compito verifica= new Compito();
        Compito esercizio= new Compito();
        System.out.println(verifica);
        System.out.println(esercizio);

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date date = simpleDateFormat.parse("09-09-1995");
            paolo.setDataNascita(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(paolo);
    }
}
