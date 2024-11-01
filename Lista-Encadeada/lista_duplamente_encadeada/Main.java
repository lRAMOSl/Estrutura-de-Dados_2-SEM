package lista_duplamente_encadeada;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeadas ld = new ListaDuplamenteEncadeadas();

        ld.InserePrimeiroElemento(0);
        ld.InsereInicioElemento(10);
        ld.InsereFimElemento(9);
        ld.InsereFimElemento(15);
        ld.InsereMeioElementoDoFim(25, 2);
        ld.imprimeOrdem();

    }

}
