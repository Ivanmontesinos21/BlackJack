package EjerciciosPOO.BlackJack;

import Heritage.Exercise5.Cliente;

public class Main {
    public static void main(String[] args) {
//       ListaDE<Bicicleta> listaDE= new ListaDE<>();
//       listaDE.addHead(new Bicicleta(45,"Electrica"));
//        listaDE.addHead(new Bicicleta(45,"Montaña"));
//        listaDE.addHead(new Bicicleta(45,"Paseo"));
//        System.out.println(listaDE);
        Lista lista =new Lista<>();
        lista.addhead(new Cliente("Pepe","Garcia Torres","52736483K","La casa de Pepeito",01));

        lista.addhead(new Cliente("Carloa","a b","52736486K","La casa de caio",02));

        lista.addTail(new Cliente("Ivan","Lis Leon","52736485K","La casa de Pepelu",03));

        lista.addTail(new Cliente("Carlos","Enrique Casemiro","52736488K","La casa de Los robos ",04));
//        System.out.println(lista);
//        lista.removeHead();
//        System.out.println(lista);
//        lista.removeTail();
//        System.out.println(lista);
//        System.out.println(lista.get(1));
        System.out.println(lista.contains("52736485K"));




    }

}
