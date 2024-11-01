package lista_duplamente_encadeada;

public class ListaDuplamenteEncadeadas {

    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplamenteEncadeadas() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;

    }

    public void InserePrimeiroElemento(double valor) {
        No aux = new No(valor);
        this.inicio = aux;
        this.fim = aux;
        this.tamanho = 1;
        this.tamanho++;
    }

    public void InsereInicioElemento(double valor) {
        No aux = new No(valor);
        aux.setProx(this.inicio);
        aux.setAnt(null);

        this.inicio.setAnt(aux);
        this.inicio = aux;
        this.tamanho++;
    }

    public void InsereFimElemento(double valor) {
        No aux = new No(valor);
        aux.setAnt(this.fim);
        aux.setProx(null);

        this.fim.setProx(aux);
        this.fim = aux;
        this.tamanho++;
    }

    public void InsereMeioElemento(double valor, int pos) {
        No aux = new No(valor);

        No ant = this.inicio;
        for (int i = 1; i < pos; i++) {
            ant = ant.getProx();

        }

        No prox = ant.getProx();

        aux.setProx(prox);
        aux.setAnt(ant);
        ant.setProx(aux);
        prox.setAnt(aux);
        this.tamanho++;

    }

    public void InsereMeioElementoDoFim(double valor, int pos) {
        No aux = new No(valor);

        No ant = this.fim;
        for (int i = tamanho - 1; i > pos; i--) {
            ant = ant.getAnt();
        }

        No prox = ant.getProx();

        aux.setProx(prox);
        aux.setAnt(ant);
        ant.setProx(aux);
        prox.setAnt(aux);
        this.tamanho++;

    }

    public void InsereMeioElemento(double valor, int pos) {
       if (pos <(int) (tamanho/2)
        InsereMeioElemento();

    }



    public void imprimeOrdem() {
        No aux = this.inicio;

        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getProx();

        }

    }

    public boolean listaVazia() {
        return (this.inicio == null);

    }

    public boolean posValida(int pos) {
        return ((pos >= 0) && (pos <= tamanho));

    }

    public boolean insere(double valor) {
        if (listaVazia())
            InserePrimeiroElemento(valor);
        else
            InsereInicioElemento(valor);
        return true;

    }

    public boolean insere(double valor, int pos) {
        if (!posValida(pos))
            return false;
        if ((pos == 0) && (tamanho == 0))
            InserePrimeiroElemento(valor);
        else if (pos == 0)
            InsereInicioElemento(valor);
        else if (pos == tamanho) {
            InsereFimElemento(valor);
        } else
            InsereMeioElemento(valor, pos);
        return true;
    }

}
