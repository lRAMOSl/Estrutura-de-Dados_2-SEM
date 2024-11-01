/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaEstatica;

/**
 *
 * @author bruno
 */
public class ListaEstatica {

    private double[] vetor;
    private int controle;

    public ListaEstatica() {
        this.vetor = new double[20];
        this.controle = 0;
    }

    public boolean vazia() {
        if (controle == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void inserePrimeiroElemento(double x) {
        vetor[0] = x;
        controle = 1;
    }

    private void insereFinalElemento(double x) {
        vetor[controle] = x;
        controle++;
    }

    private void insereInicioElemento(double x) {
        for (int i = controle; i > 0; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[0] = x;
        controle++;
    }

    private void insereMeioElemento(double x, int pos) {
        for (int i = controle; i > pos; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[pos] = x;
        controle++;
    }

    public boolean posValida(int i) {
        if ((i >= 0) && (i <= controle)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean listaCheia() {
        if (controle < vetor.length) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insere(double x) {
        if (listaCheia()) {
            return false;
        }
        if (vazia()) {
            inserePrimeiroElemento(x);
        } else
            insereFinalElemento(x);
        return true;
    }

    public boolean insere(double x, int pos) {
        if (listaCheia() || !posValida(pos)) {
            return false;
        }
        if (pos == 0) {
            insereInicioElemento(x);
        } else if (pos == tamanho()) {
            insereFinalElemento(x);
        } else {
            insereMeioElemento(x, pos);
        }
        return true;
    }

    public int tamanho() {
        return controle;
    }

    public void imprimeLista() {
        for (int i = 0; i < tamanho(); i++) {
            System.out.println("[" + i + "] = " + vetor[i]);
        }
    }

    private void removeFinalElemento() {
        controle--;
    }

    private void removeInicioElemento() {
        for (int i = 0; i < controle; i++) {
            vetor[i] = vetor[i + 1];
        }
        controle--;
    }

}
