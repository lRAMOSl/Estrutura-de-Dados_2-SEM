package listaSimples;

public class ListaSimples {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaSimples() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public ListaSimples(int valor) {
        this.inserirPrimeiro(valor);
    }

    public int buscarPosicao(int valor) {
        int indice = 0;
        No noAtual = this.inicio;
        for (int i = 1; i <= this.tamanho; i++) {
            if (noAtual.getValor() == valor) {
                return indice;
            }
            noAtual = noAtual.getProximo();
            indice++;
        }
        return -1;
    }

    public void print() {
        if (tamanho > 0) {
            No noAtual = this.inicio;
            System.out.println(noAtual.getValor());
            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
                System.out.println(noAtual.getValor());
            }
        }
        System.out.println("");
    }

    private void inserirPrimeiro(int valor) {
        No auxiliar = new No(valor);
        if (this.tamanho == 0) {
            this.inicio = auxiliar;
            this.fim = auxiliar;
        } else {
            auxiliar.setProximo(this.inicio);
            this.inicio = auxiliar;
        }
        this.tamanho++;
    }

    private void inserirUltimo(int valor) {
        No auxiliar = new No(valor);
        this.fim.setProximo(auxiliar);
        this.fim = auxiliar;
        this.tamanho++;
    }

    public No buscarNo(int posicao) {
        No noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }

    private void removePrimeiro() {
        if (this.tamanho == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = inicio.getProximo();
        }
        tamanho--;
    }

    private void removeUltimo() {
        No noAnterior = this.buscarNo(tamanho - 2);
        noAnterior.setProximo(null);
        this.fim = noAnterior;
        this.tamanho--;
    }

    private void removePosicao(int posicao) {
        No noAnterior = buscarNo(posicao - 1);
        noAnterior.setProximo(noAnterior.getProximo().getProximo());
        this.tamanho--;
    }

    public boolean remove() {
        switch (this.tamanho) {
            case 0:
                return false;
            case 1:
                removePrimeiro();
                break;
            default:
                this.removeUltimo();
                break;
        }
        return true;
    }

    public boolean remove(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            return false;
        }
        if (posicao == 0) {
            removePrimeiro();
        } else if (posicao == this.tamanho - 1) {
            removeUltimo();
        } else {
            removePosicao(posicao);
        }
        return true;
    }

    private void inserirPosicao(int valor, int posicao) {
        No noAuxiliar = new No(valor);
        No noAnterior = buscarNo(posicao - 1);
        noAuxiliar.setProximo(noAnterior.getProximo());
        noAnterior.setProximo(noAuxiliar);
        this.tamanho++;
    }

    public boolean insere(int valor) {
        if (this.tamanho == 0) {
            this.inserirPrimeiro(valor);
        } else {
            this.inserirUltimo(valor);
        }
        return true;
    }

    public boolean insere(int valor, int posicao) {
        if (this.tamanho == 0 && posicao == 0) {
            this.inserirPrimeiro(valor);
        } else if (posicao == this.tamanho) {
            this.inserirUltimo(valor);
        } else {
            this.inserirPosicao(valor, posicao);
        }
        return true;
    }

    public void ordenar() {
        for (int i = 0; i < this.tamanho; i++) {
            No no = this.inicio;
            for (int n = 0; n < this.tamanho - (i + 1); n++) {
                No proximo = no.getProximo();
                if (no.getValor() > proximo.getValor()) {
                    double valor = no.getValor();
                    no.setValor(proximo.getValor());
                    proximo.setValor(valor);
                }
                no = no.getProximo();
            }
        }
    }

    public void inserirOrdenado(int valor) {
        this.insere(valor);
        this.ordenar();
    }

    public void queue(int valor) {
        this.insere(valor, 0);
    }

    public void dequeue() {
        this.remove(0);
    }

    public void push(int valor) {
        this.insere(valor);
    }

    public void pop() {
        this.remove(0);
    }
}
