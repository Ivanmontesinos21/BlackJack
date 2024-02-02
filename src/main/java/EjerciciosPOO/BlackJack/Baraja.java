package EjerciciosPOO.BlackJack;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja<E> {

    private Lista<Carta> cartas;

    public Baraja(){

        // cartas = new Carta[52];
      cartas=new Lista<>();

        int i=0;

        for (Palo palo : Palo.values())
            for (Tipo tipo : Tipo.values())
              cartas.addhead(new Carta(tipo,palo));

    }

    public void shuffle(){
        List<Carta> aux = Arrays.asList(cartas.getAsArray(Carta.class));
        Collections.shuffle(aux);

        int i=0;
        for(Carta c : aux)
            cartas[i++]=c;
    }

    public void cut(){
        Carta[] cartas=this.cartas.getAsArray(Carta.class);
        this.cartas.clear();

        if(cartas.length!=0) {

            int cut = (int)(Math.random()* cartas.length);

            Carta[] aux = new Carta[cartas.length];

            for (int i = 0; i + cut < cartas.length; i++)
                aux[i] = cartas[i + cut];

            for (int i = 0; i < cut; i++)
                aux[cartas.length - cut + i] = cartas[i];


            cartas = aux;
            this.cartas.addAll(cartas);
        }

    }

    public Carta showTop(){
        return cartas.get(0);

    }

    public Carta removeTop(){
        return cartas.removeHead();
    }


    public Carta removeBotom(){
        return  cartas.removeTail();
    }

    @Override
    public String toString(){
        return cartas.toString();
    }

}