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

    public void start() {

        jueganJugadores();
        juegaBanca();
        mostrarGanadores();
    }

    private void mostrarGanadores() {
        for (Jugador jugador:jugadores)
            if (jugador.getPuntuacion()>banca.getPuntuacion())
                System.out.println(jugador.getNombre()+" ha ganado");
        else
                System.out.println(jugador.getNombre()+ " ha ganado");

    }

    private void juegaBanca() {
        banca.cogerCarta(baraja.removeTop());
        while (!banca.pasado() && !banca.winAll(jugadores))
            banca.cogerCarta(baraja.removeTop());
        System.out.println(banca);
    }

    public void jueganJugadores() {
        boolean quiereCarta=true;
        baraja.shuffle();

        for(Jugador jugador: jugadores) {
            System.out.println("Empieza a jugar " +jugador.getNombre());
            do {

                jugador.cogerCarta(baraja.removeTop());
                System.out.println(jugador);
                quiereCarta = solicitarQuiereCarta(jugador);
                if (!jugador.pasado())
                    quiereCarta=solicitarQuiereCarta(jugador);

            } while (quiereCarta && !jugador.pasado());
            if (jugador.pasado())
                System.out.println("te has pasado!!!");

        }

    }

    private boolean solicitarQuiereCarta(Jugador jugador) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres carta " + jugador.getNombre()+"? [s|n]");

        return sc.nextLine().toLowerCase().charAt(0)=='s';

    }
}

