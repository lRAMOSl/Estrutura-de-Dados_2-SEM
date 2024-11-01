package listaEstatica;

public class ListaEstatica {
    private double[] vetor;
    private int controle;

    // Construtor, com array de 20 elementos
    public ListaEstatica() {
        this.vetor = new double[20];
        this.controle = 0;
    }

    public boolean vazia() {
        // Verifica se a variável controle é igual a 0
        if (controle == 0) {
            return true; // Se for 0, retorna true (indicando que está "vazia")
        } else {
            return false; // Caso contrário, retorna false (indicando que não está "vazia")
        }
    }

    private void inserePrimeiroElemento(double x) {
        vetor[0] = x; // Insere o valor 'x' na primeira posição do vetor (índice 0)
        controle = 1; // Define o controle como 1, indicando que há um elemento no vetor
    }

    private void insereFinalElemento(double x) {
        vetor[controle] = x; // Insere o valor 'x' na posição atual do controle (última posição ocupada)
        controle++; // Incrementa o valor do controle, indicando que mais um elemento foi inserido
    }

    private void insereInicioElemento(double x) {
        // Desloca os elementos para a direita para abrir espaço no início
        for (int i = controle; i > 0; i--) {
            vetor[i] = vetor[i - 1];
        }
        // Insere o novo valor na posição 0
        vetor[0] = x;
        controle++; // Incrementa a adição de um novo elemento
    }

    private void insereMeioElemento(double x, int pos) {
        for (int i = controle; i > pos; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[pos] = x;
        controle++;
    }

    // verifica se 'i' é válido com base nas restrições do array
    public boolean posValida(int i) {
        if ((i >= 0) && (i <= controle)) { // i >= 0, quer dizer isso garante que o índice não seja negativo, o que seja
                                           // inválido.

            return true; // i <= controle, quer dizer que ele tem que ser menor ou igual ao valor do
                         // controle, o que garante que 'i' não exceda o numero de elementos presentes.
        } else {
            return false;
        }
    }

    public boolean listaCheia() {
        if (controle < vetor.length) { // se o numero do controle for menor que o array, significa que há espaço
            return false; // Se ainda há espaço no array, retorna false (não está cheia)
        } else {
            return true;
        } // Se não há mais espaço, retorna true (a lista está cheia)
    }

    public boolean insere(double x) {
        if (listaCheia()) {
            return false;
        } // Se a lista está cheia, não insere o elemento e retorna false
        if (vazia()) {
            inserePrimeiroElemento(x); // Se a lista está vazia, insere o primeiro elemento
        } else {
            insereFinalElemento(x);
        }
        return true; // Se conseguiu inserir o elemento, retorna true
        // Se a lista estiver cheia, a inserção falha e o método retorna false.
        // Se a lista estiver vazia, o valor é inserido na primeira posição.
        // Se a lista não estiver vazia, o valor é inserido na próxima posição
        // disponível no final do array.
        // Após uma inserção bem-sucedida, o método retorna true.
    }

    public boolean insere(double x, int pos) {
        // Verifica se a lista está cheia ou se a posição fornecida não é válida
        if (listaCheia() || !posValida(pos)) {
            return false; // Se estiver cheia ou a posição for inválida, retorna false
        }
        // Se a posição for 0, insere o elemento no início da lista
        if (pos == 0) {
            insereInicioElemento(x);
            // Se a posição for igual ao tamanho da lista, insere o elemento no final
        } else if (pos == tamanho()) {
            insereFinalElemento(x);
            // Caso contrário, insere o elemento no meio, na posição específica
        } else {
            insereMeioElemento(x, pos);
        }
        return true; // Se a inserção for bem-sucedida, retorna true
    }

    // retorna o valor da variável controle.
    public int tamanho() {
        return controle;
    }

    public void imprimeLista() {
        for (int i = 0; i < tamanho(); i++) {
            System.out.println("[" + i + "] = " + vetor[i]);
        }
    }

    public void removeFinalElemento() {
        controle--;
    }

    public void removeInicioElemento() {
        // Desloca todos os elementos uma posição para a esquerda
        for (int i = 0; i < controle; i++) {
            vetor[i] = vetor[i + 1];
        }
        controle--; // Reduz o número de elementos no controle
    }
}