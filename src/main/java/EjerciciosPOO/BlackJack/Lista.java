package EjerciciosPOO.BlackJack;

import java.lang.reflect.Array;

public class Lista<E> {
    private int size;
    private Nodo<E> head;
    private Nodo<E> tail;

    public Lista() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
//    public Lista(E nums) {
//        this;
//    }


    public int getSize() {
        return size;
    }

    public void addhead(E num) {
        Nodo<E> nodo = new Nodo<>(num);
        if (size == 0) {
            head = nodo;
            tail = nodo;
            size++;
        } else {
            nodo.setNext(head);
            head = nodo;

        }
        size++;
    }

    public void addTail(E num) {
        Nodo<E> nodo = new Nodo<>(num);
        if (size == 0) {
            head = nodo;

        } else {
            tail.setNext(nodo);

        }
        tail = nodo;
        size++;

    }
    public boolean contains(E num){
        if (size==0) return false;
        boolean encontrado=false;
        Nodo<E> aux=head;
        while (aux != null && !encontrado)
        if (aux.getInfo().equals(num))
            encontrado = true;
            aux = aux.getNext();
            return encontrado;
        }
        public void clear(){
        tail=null;
        head=null;
        size=0;
        }






    public E get(int index){
        if (index>=size) return null;
            if(size<0)
            return null;
        Nodo<E> aux=head;
        while (index>0) {
            aux = aux.next;
            index--;

        }
        return  aux.getInfo();

    }
    public E remove(int index){
        if (index>=size) return null;
        if(size<0) return null;
        if (index==0) removeHead();
        if (index == size-1) removeTail();
        Nodo<E> j=head; Nodo<E> i=head.next;
        int k=0;

        while (k++<index) {
            j = i;
            i = i.next;

        }
        j.next=i.next;
        size--;
        return  i.getInfo();
    }

    public void addAll(E[] nums){

        for(E num : nums) addTail(num);

    }

    public E[] getAsArray(Class clazz){


        E[] aux = (E[]) Array.newInstance(clazz, size);

        Nodo<E> nodo = head;
        int i=0;

        while (nodo!=null) {
            aux[i++] = nodo.info;

            nodo=nodo.next;
        }

        return aux;

    }


    public E removeHead() {
        if (head != null) {
            E num = head.info;
            head = head.getNext();
            size--;

            return num;
        }
        return null;

    }

    public E removeTail() {
        //Solo con una de las tres es correcto
        if (size == 0 || head == null || tail == null)
            if (size == 1 || head == tail) return removeHead();
        Nodo <E>j=head; Nodo<E> i=head.next;
        //sirve cualquiera de las 2
        while (i!=tail|| i.next!=null){
            j=i;
            i=i.next;
        }
        j.next=null;
        tail=j;
        size--;
            return i.info;
        }





    @Override
    public String toString() {
        Nodo n = head;
        String aux = "Size:" + size + "\n Values: ";
        while (n != null) {
            aux += n.getInfo() + " ";
            n = n.getNext();

        }
        return aux;
    }

    private class Nodo<E> {
        private E info;
        private Nodo<E> next;

        public Nodo(E info) {
            this.info = info;
            this.next = null;
        }


        public Nodo<E> getNext() {
            return next;
        }

        public void setNext(Nodo<E> next) {
            this.next = next;
        }

        public E getInfo() {
            return info;
        }


        @Override
        public String toString() {
            return "Nodo{" +
                    "info=" + info +
                    ", next=" + next +
                    '}';
        }
    }
}
