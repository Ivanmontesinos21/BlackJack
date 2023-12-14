package EjerciciosPOO.BlackJack;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private Carta[] cartas;

    public Baraja(){
        cartas=new Carta[Palo.values().length*Tipo.values().length];
       int i=0;
        for (Tipo tipo:Tipo.values())
            for (Palo palo:Palo.values())
                cartas[i++]=new Carta(tipo,palo);

    }
    @Override
    public String toString(){
        return Arrays.toString(cartas);
    }
    public void shuffle(){
        List<Carta> aux= Arrays.asList(cartas);
        Collections.shuffle(aux);
        int i=0;
        for (Carta c:aux)
            cartas[i++]=c;
//        aux.toArray(cartas);
    }
    public void cut(){
        if (cartas.length==0)
            return;
        Carta[]aux=new Carta[cartas.length];
        int cut=(int) (Math.random()*cartas.length);

        for (int i=0;i+cut< cartas.length;i++)
            aux[i]=cartas[i+cut];
        for (int i=0;i<cut;i++)
            aux[cartas.length-cut+i]=cartas[i];


       cartas=aux;
    }
    public Carta showTop(){
        if (cartas.length==0)
            return null;
        return cartas[0];

    }
    public Carta removeTop(){
        if (cartas.length==0)
            return null;
        Carta c=cartas[0];
       Carta[] aux=new Carta[cartas.length-1];
       for (int i=0;i< aux.length;i++) {
           aux[i] = cartas[i + 1];
       }
       cartas=aux;
       return c;

    }
    public Carta removeBotom() {
        if (cartas.length == 0)
            return null;
        Carta c = cartas[cartas.length - 1];
        Carta[] aux = new Carta[cartas.length - 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = cartas[i];

        }
        cartas = aux;
        return c;


    }
}
