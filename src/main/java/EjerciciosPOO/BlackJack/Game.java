package EjerciciosPOO.BlackJack;

import java.util.Scanner;

public class Game {

    private Jugador[] jugadores;
    private Jugador banca;
    private Baraja baraja;

    public Game(){
        baraja = new Baraja();
        banca = new Jugador("PC");
        init();
    }
    public Game(Jugador... jugadores){

        baraja = new Baraja();
        banca = new Jugador("PC");
        this.jugadores=jugadores;

    }


    private void init() {
        // TODO
    }

    public void start(){

        baraja.shuffle();

        jueganJugadores();
        juegaBanca();
        mostrarGanadores();

    }

    private void mostrarGanadores() {

        if(banca.pasado()){

            for(Jugador jugador : jugadores){
                if(jugador.win(banca))
                    System.out.println("El jugador " + jugador.getNombre()+" gana!");
            }

        } else {

            System.out.println("Gana la BANCA!!!");

        }


    }

    private void juegaBanca() {

        while(!banca.pasado() && !banca.winAll(jugadores)) {
            banca.cogerCarta(baraja.removeTop());
            System.out.println(banca);

            try {
                Thread.sleep(2000);
            }catch (Exception e){}
        }

    }

    private void jueganJugadores() {
        boolean quiereCarta;

        for(Jugador jugador: jugadores) {

            quiereCarta=true;

            System.out.println("Empieza a jugar "+ jugador.getNombre());

            do {

                jugador.cogerCarta(baraja.removeTop());
                System.out.println(jugador);

                if(!jugador.pasado())
                    quiereCarta = solicitarQuiereCarta(jugador);

            } while (quiereCarta && !jugador.pasado());

            if(jugador.pasado())
                System.out.println("Te has pasado!!!");

        }
    }


    private boolean solicitarQuiereCarta(Jugador jugador) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres carta " + jugador.getNombre()+"? [s|n]");

        return sc.nextLine().toLowerCase().charAt(0)=='s';

    }
}
