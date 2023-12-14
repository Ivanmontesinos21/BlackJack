package EjerciciosPOO.BlackJack;

public class Main {
    public static void main(String[] args) {
    Baraja baraja=new Baraja();
    baraja.shuffle();
        System.out.println(baraja);

        baraja.removeBotom();
        baraja.removeTop();
        baraja.cut();

        System.out.println(baraja);


    }


}
