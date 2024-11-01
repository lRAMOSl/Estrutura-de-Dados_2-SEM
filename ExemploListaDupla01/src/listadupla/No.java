package listadupla;

public class No {

    private No prox;
    private No ant;
    private double valor;

    public No(double valor) {
        this.prox = null;
        this.ant = null;
        this.valor = valor;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
