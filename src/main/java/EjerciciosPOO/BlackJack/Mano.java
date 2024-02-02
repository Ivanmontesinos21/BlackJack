package EjerciciosPOO.BlackJack;

import java.util.Arrays;



public class Mano<E> {

    private Lista<Carta>cartas;

    public Mano(){
        cartas=new Lista<>();
    }

    public int obtenerPuntuacion(){

        int puntuacion=0;

        for(Carta carta : cartas)
            puntuacion+=carta.getValues()[0];

        return puntuacion;

    }

    public void addCard(Carta carta){

        Carta[] aux = new Carta[cartas.length+1];

        aux[0] = carta;

        for(int i=0;i< cartas.length;i++)
            aux[i+1]=cartas[i];

        cartas=aux;

    }

    @Override
    public String toString(){
        return cartas.toString();
    }

}