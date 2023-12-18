package EjerciciosPOO.BlackJack;

public class Carta {
    private Palo palo;
    private Tipo tipo;

    public Carta( Tipo tipo,Palo palo) {
        this.tipo = tipo;
        this.palo = palo;
    }
    public int[] getValues(){
        return tipo.getValues();
    }

    @Override
    public String toString(){
        return tipo.toString()+palo;
    }
}
