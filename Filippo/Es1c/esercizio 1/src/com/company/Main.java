package com.company;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {

    public static void main(String[] args) {
	    //Scanner tastiera= new Scanner(System.in);
	    //creo un array con il pin dell'utente
	    int[] pin={1,2,3,4,5};
	    //creo due array, uno con la sequenza numerica 0-9, uno vuoto in cui andranno inseriti numeri randomici
	    int[] numeriC={0,1,2,3,4,5,6,7,8,9};
	    int[] numeriRandom= new int[numeriC.length];
	    numeriRandom= generateRandomArray(numeriRandom);
	    //stampo nella console la sequenza di numeri 0-9 e la sequenza di numeri randomici in modo da metterli a confronto
	    System.out.println("insert your pin:");
	    System.out.print("PIN: ");
	    for(int i=0;i< numeriC.length; i++){
	        System.out.print(numeriC[i] + " ");
        }
	    System.out.println("");
	    System.out.print("NUM: ");
	    for(int j=0;j< numeriRandom.length;j++){
            System.out.print(numeriRandom[j] + " ");
        }
	    //creo un array che andrà riempito con il pin convertito associando i numeri randomici al valore effettivo
	    int[] pinRandom= new int[pin.length];
	    System.out.println("");
	    System.out.println("inserisci i valori:");
	    pinRandom= getRandomPin(pinRandom);
	    //richiamo la funzione getAssociatedNum per riempire tre array, uno per ogni numero randomico
        int[] arrayAssociato1= getAssociatedNum(numeriC,numeriRandom, 1);
        int[] arrayAssociato2= getAssociatedNum(numeriC,numeriRandom, 2);
        int[] arrayAssociato3= getAssociatedNum(numeriC,numeriRandom, 3);

    }
    //creo una funzione che riempa un array vuoto con numeri randomici da 1 a 3 compresi
    public static int[] generateRandomArray(int[] array) {
        for(int i=0; i< array.length; i++){
            int numeroRandom = ThreadLocalRandom.current().nextInt(1, 4);
            array[i]= numeroRandom;
        }
        return array;
    }
    //creo una funzione che ottenga i numeri del pin associati a quelli randomici, per riempire un array
    public static int[] getRandomPin(int[] array){
        Scanner tastiera1= new Scanner(System.in);
        for(int i=0;i< array.length;i++){
            int randomN= tastiera1.nextInt();
            array[i]= randomN;
        }
        return array;
    }
    //creo una funzione che crei un array contenente i numeri associati ad ogni numero randomico
    public static int[] getAssociatedNum(int[] arraySequenza, int[] arrayRandom, int num ){
        int count= 0;
        for (int i=0; i< arraySequenza.length;i++){
            if (arrayRandom[i]==num){
                count++;
            }
        }
        int[] arrayAssociato= new int[count];
        int indice=0;
        for(int i=0; i< arrayRandom.length;i++){
            if (arrayRandom[i]==num){
                arrayAssociato[indice]= arraySequenza[i];
                indice++;
            }
        }
        return arrayAssociato;
    }
}
