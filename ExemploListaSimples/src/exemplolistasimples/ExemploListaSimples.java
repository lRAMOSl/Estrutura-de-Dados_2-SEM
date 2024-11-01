/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplolistasimples;

import listaSimples.ListaSimples;

/**
 *
 * @author bruno
 */
public class ExemploListaSimples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ListaSimples ls = new ListaSimples();
        /// ls.inserePrimeiroElemento(5);
        // ls.insereFinalElemento(10);
        // ls.insereFinalElemento(15);
        /// ls.insereMeioElemento(3, 1);
        // ls.insereMeioElemento(9, 4);

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
