package exemplolistadupla01;

import listadupla.ListaDuplamenteEncadeada;

public class ExemploListaDupla01 {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada ld = new ListaDuplamenteEncadeada();

        ld.inserePrimeiroElemento(0);
        ld.insereInicioElemento(10);
        ld.insereFinalElemento(9);
        ld.insereFinalElemento(15);
        ld.insereMeioElementoDoInicio(7, 3);
        ld.removeUltimoElemento();
        ld.removePrimeiroElemento();

        for (int i = 0; i < 10; i++) {
            ld.insereMeioElemento(i, (int) (2 * ld.tamanho() / 3));

        }

        ld.imprimeOrdem();

    }

}
