package EjerciciosPOO.BlackJack;

public enum Tipo {
    AS("A",new int[]{1,11}),
    DOS("2",new int[]{2}),
    TRES("2",new int[]{3}),
    CUATRO("3",new int[]{4}),
    CINCO("4",new int[]{5}),
    SEIS("5",new int[]{6}),
    SIETE("6",new int[]{7}),
    OCHO("6",new int[]{8}),
    NUEVE("6",new int[]{9}),
    JACK("J",new int[]{10}),
    QUEEN("Q",new int[]{10}),
    KING("K",new int[]{10});
    
    private String shape;
    private int[]values;
    Tipo(String shape,int[] values){
        this.shape=shape;
        this.values=values;
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public String toString(){
        return shape;
    }
}
