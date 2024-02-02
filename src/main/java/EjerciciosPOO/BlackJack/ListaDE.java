package EjerciciosPOO.BlackJack;



public class ListaDE<E> {

    private int size;
    private Nodo<E> head;
    private Nodo<E> tail;

    public void addHead(E num) {

        Nodo<E> nodo = new Nodo<E>(num);

        if (size == 0 || head == null || tail == null) {

            head = nodo;
            tail = nodo;

        } else {

            nodo.next = head;
            head.prev = nodo;

            head = nodo;
        }

        size++;


    }

    public E removeHead(){

        E aux;

        if(size==0) return null;
        if(size==1) {

            aux = head.info;
            head = null;
            tail = null;

        } else {

            aux = head.info;
            head = head.next;
            head.prev=null;

        }

        size--;
        return aux;

    }

    public void addTail(E num) {
        Nodo<E> nodo = new Nodo<E>(num);

        if (size == 0 || head == null || tail == null) {

            head = nodo;
            tail = nodo;

        } else {

            nodo.prev = tail;
            tail.next = nodo;
            tail = nodo;

        }

        size++;
    }

    @Override
    public String toString() {
        Nodo n = head;
        String aux = "Size: " + size + "\nValues: ";

        while (n != null) {

            aux += n.info + " ";

            n = n.next;

        }

        aux += "\nValues: ";

        n = tail;
        while (n != null) {

            aux += n.info + " ";

            n = n.prev;

        }

        return aux;
    }

    private class Nodo<E> {

        private E info;
        private Nodo<E> next;
        private Nodo<E> prev;

        public Nodo(E info) {
            this.info = info;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return info + "";
        }
    }
}