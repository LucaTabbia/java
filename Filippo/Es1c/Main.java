package com.company;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {

    public static void main(String[] args) {
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
        //richiamo la funzione decodePin
        boolean conferma= decodePin(arrayAssociato1,arrayAssociato2,arrayAssociato3,pin,pinRandom);
        if (conferma== true){
            System.out.println("Accesso garantito!");
        }else{
            System.out.println("Accesso negato!");
        }

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
            randomN= checkValidity(randomN);
            array[i]= randomN;
        }
        return array;
    }
    //creo una funzione che controlli che in numeri inseriti sia compresi fra 1 e 3
    public static int checkValidity(int n){
        Scanner tastiera2= new Scanner(System.in);
        if(n<1 || n>3){
            System.out.println("valore non valido, reinserire valore:");
            n= tastiera2.nextInt();
            n= checkValidity(n);
            return n;
        } else {
            return n;
        }
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
    //creo una funzione che restituisca un boolean, dopo aver decifrato il pin codificato con quello normale
    public static boolean decodePin(int[] arrayAssociato1, int[] arrayAssociato2,
                                    int[] arrayAssociato3, int[] pin, int[] pinRandom){
        for(int i=0; i< pin.length;i++){
            int cifra= pinRandom[i];
            if(cifra==1){
                for(int j=0; j<arrayAssociato1.length;j++){
                    if(pin[i]==arrayAssociato1[j]){
                        break;
                    }
                    if(pin[i]!=arrayAssociato1[j] && j== arrayAssociato1.length-1){
                        return false;
                    }
                }
            }if(cifra==2){
                for(int j=0; j<arrayAssociato2.length;j++){
                    if(pin[i]==arrayAssociato2[j]){
                        break;
                    }
                    if(pin[i]!=arrayAssociato2[j] && j== arrayAssociato2.length-1){
                        return false;
                    }
                }
            }if(cifra==3){
                for(int j=0; j<arrayAssociato3.length;j++){
                    if(pin[i]==arrayAssociato3[j]){
                        break;
                    }
                    if(pin[i]!=arrayAssociato3[j] && j== arrayAssociato3.length-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
