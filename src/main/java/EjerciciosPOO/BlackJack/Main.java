package EjerciciosPOO.BlackJack;

public class Main {
    public static void main(String[] args) {
    Jugador jugador1=new Jugador("Ivan");
    Jugador jugador2=new Jugador("Miguel");
    Game game=new Game(jugador1,jugador2);
    game.start();

    }


}
