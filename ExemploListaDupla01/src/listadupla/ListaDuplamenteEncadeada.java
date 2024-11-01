package listadupla;

public class ListaDuplamenteEncadeada {

    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserePrimeiroElemento(double valor) {
        No aux = new No(valor);
        this.inicio = aux;
        this.fim = aux;
        this.tamanho = 1;
    }

    public void insereInicioElemento(double valor) {
        No aux = new No(valor);
        aux.setProx(this.inicio);
        aux.setAnt(null);

        this.inicio.setAnt(aux);
        this.inicio = aux;

        this.tamanho++;
    }

    public void insereFinalElemento(double valor) {
        No aux = new No(valor);
        aux.setAnt(this.fim);
        aux.setProx(null);

        this.fim.setProx(aux);
        this.fim = aux;

        this.tamanho++;
    }

    public void insereMeioElementoDoInicio(double valor, int pos) {
        No aux = new No(valor);
        No ant = this.inicio;
        for (int i = 1; i < (pos); i++) {
            ant = ant.getProx();
        }
        No prox = ant.getProx();
        aux.setProx(prox);
        aux.setAnt(ant);
        ant.setProx(aux);
        prox.setAnt(aux);
        this.tamanho++;
    }

    public void insereMeioElementoDoFim(double valor, int pos) {
        No aux = new No(valor);
        No ant = this.fim;
        for (int i = tamanho - 1; i >= (pos); i--) {
            ant = ant.getAnt();
        }
        No prox = ant.getProx();
        aux.setProx(prox);
        aux.setAnt(ant);
        ant.setProx(aux);
        prox.setAnt(aux);
        this.tamanho++;
    }

    public int tamanho() {
        return tamanho;
    }

    public void insereMeioElemento(double valor, int pos) {
        if (pos < (int) (tamanho / 2)) {
            insereMeioElementoDoInicio(valor, pos);
        } else {
            insereMeioElementoDoFim(valor, pos);
        }
    }

    public void imprimeOrdem() {
        No aux = this.inicio;
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getProx();
        }
    }

    public void removeUltimoElemento() {
        No ant = this.inicio;
        for (int i = 1; i < tamanho() - 1; i++) {
            ant = ant.getProx();
        }
        No ultimo = ant.getProx();
        ant.setProx(null);
        this.fim = ant;
        this.tamanho--;
        ultimo = null;

    }

    public void removePrimeiroElemento() {
        No ant = this.inicio;
        this.inicio = ant.getProx();
        ant = null;
        System.gc();
        tamanho--;
    }

    public boolean listaVazia() {
        return (this.inicio == null);
    }

    public boolean posValida(int pos) {
        return ((pos >= 0) && (pos <= this.tamanho));
    }

    public boolean insere(double valor) {
        if (listaVazia()) {
            inserePrimeiroElemento(valor);
        } else {
            insereInicioElemento(valor);
        }
        return true;
    }

    public boolean insere(double valor, int pos) {
        if (!posValida(pos)) {
            return false;
        }

        if ((pos == 0) && (tamanho == 0)) {
            inserePrimeiroElemento(valor);
        } else if (pos == 0) {
            insereInicioElemento(valor);
        } else if (pos == tamanho) {
            insereFinalElemento(valor);
        } else {
            insereMeioElemento(valor, pos);
        }
        return true;
    }

}
