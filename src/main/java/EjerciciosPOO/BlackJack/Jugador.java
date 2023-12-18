package EjerciciosPOO.BlackJack;

public class Jugador {

    private Mano mano;
    private String nombre;

    public Jugador(String nombre){
        this.nombre=nombre;
        mano = new Mano();
    }

    public void cogerCarta(Carta carta){
        mano.addCard(carta);
    }

    public int getPuntuacion(){
        return mano.obtenerPuntuacion();
    }
    public boolean win(Jugador jugador){
        return jugador.getPuntuacion()<getPuntuacion();
    }

    public boolean pasado(){
        return getPuntuacion()>21;
    }

    public String getNombre(){
        return nombre;
    }
    public boolean winAll(Jugador... jugadores) {
        if (pasado()) return false;
        boolean gana = true;
        int i = 0;
        while (gana && i < jugadores.length) {
            gana = jugadores[i].pasado() || jugadores[i].getPuntuacion() < getPuntuacion();
            i++;
        }
        return gana;
    }

    @Override
    public String toString(){
        return "Jugador: " + nombre+"\n"+
                "Cartas: " + mano + " Puntuacion: " + getPuntuacion();
    }

}




