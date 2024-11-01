package principalista;

import listaSimples.ListaSimples;

public class PrincipalLista {
    public static void main(String[] args) {
        ListaSimples ls = new ListaSimples();

        System.out.println("Inserindo elementos:");
        System.out.println("Inserir 7: " + ls.insere(7));
        System.out.println("Inserir 12: " + ls.insere(12));
        System.out.println("Inserir 30 na posição 0: " + ls.insere(30, 0));
        System.out.println("Inserir 4 na posição 0: " + ls.insere(4, 0));
        System.out.println("Inserir 15 na posição 0: " + ls.insere(15, 0));
        System.out.println("Inserir -100 na posição 2: " + ls.insere(-100, 2));

        System.out.println("Lista: inserções:");
        ls.print();

        System.out.println("Inserindo elementos ordenadamente:");
        ls.inserirOrdenado(25);
        ls.inserirOrdenado(5);
        ls.inserirOrdenado(15);

        System.out.println("Lista: inserções ordenadas:");
        ls.print();

        System.out.println("Removendo elementos:");
        System.out.println("Remover posição 2: " + ls.remove(2));
        System.out.println("Remover primeiro elemento: " + ls.remove());

        System.out.println("Lista após remoções:");
        ls.print();

        System.out.println("Operações: fila e pilha:");
        ls.queue(30);
        ls.queue(40);
        ls.push(50);

        System.out.println("Lista: operações de fila e pilha:");
        ls.print();

        ls.dequeue();
        ls.pop();

        System.out.println("Lista final:");
        ls.print();
    }
}
