package exemplolistasimples;

import listaSimples.ListaSimples;

public class ExemploListaSimples {

    public static void main(String[] args) {
        ListaSimples ls = new ListaSimples();

        System.out.println(ls.insere(5));
        System.out.println(ls.insere(10));
        System.out.println(ls.insere(20, 0));
        System.out.println(ls.insere(2, 0));
        System.out.println(ls.insere(17, 0));
        System.out.println(ls.insere(-100, 20));
        ls.print();
        // ls.removeMeioElemento(4);
        ls.print();

    }
}
