package listaSimples;

public class ListaSimples {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaSimples() { // um construtor da clsse ListaSimples
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    private void inserePrimeiroElemento(double valor) {
        No aux = new No(valor); // cria um novo objeto de classe NO
        this.inicio = aux;
        this.fim = aux;
        this.tamanho = 1;
    } // aqui você esta lidando com uma lista que inicialmente está vazia
      // Antes da inserção: cabeça -> nó1 -> nó2 -> fim

    private void insereFinalElemento(double valor) { // insere um elemento no final da lista
        No aux = new No(valor);
        this.fim.setProximo(aux); // o proximo que é o ultimo da lista, é atualizado para o novo NO "aux"
        this.fim = aux; // o AUX se torna o novo ultimo da lista
        this.tamanho++;
    }
    // Após a inserção: cabeça -> nó1 -> nó2 -> novo_nó -> fim

    private void insereInicioElemento(double valor) {
        No aux = new No(valor); // NO criado e armazenado na variável AUX
        aux.setProximo(inicio); // Isso faz com que o novo nó aponte para o antigo primeiro nó.
        this.inicio = aux; // atualizada para apontar para o novo nó aux
        this.tamanho++;
    }
    // Após a inserção: inicio -> novo_nó -> nó1 -> nó2 -> fim

    private void insereMeioElemento(double valor, int pos) {
        No aux = new No(valor);
        No ant = this.inicio; // variavel anterior como o primeiro NO da lista
        for (int i = 1; i < pos; i++) {
            ant = ant.getProximo(); // loop FOR que percorre a lista até encontar a POS(posição) onde o novo
                                    // elemento será inserido.
        }
        aux.setProximo(ant.getProximo());
        ant.setProximo(aux);
        this.tamanho++;
    } // Após a inserção na posição 2: inicio -> nó1 -> novo_nó -> nó2 -> nó3 -> fim

    public void print() {
        No aux = this.inicio; // novo NO criado como o primeiro da lista, usado para percorrer a lista
        while (aux != null) { // enquanto tiver elemento da lista o laço ira rodar
            System.out.println(aux.getValor());
            aux = aux.getProximo(); // o NO auxiliar agora vai apontar para o proximo da lista.
        }
        System.out.println("_______________________________");
    }

    public boolean listaVazia() {
        return tamanho() == 0;
    }

    public int tamanho() {
        int tamanho = 0; // utilizada para contar o numero de NO da lista
        No aux = this.inicio; // usado para percorrer a lista
        while (aux != null) {
            tamanho++;
            aux = aux.getProximo();
        }
        return tamanho; // retorna o valor final da variavel TAMANHO
    }

    public boolean insere(double valor) { // insere um valor especifico á lista
        if (listaVazia()) { // verifica se a lista esta vazia
            inserePrimeiroElemento(valor); // se estiver vazia chama o metodo INSEREPRIMEIROELEMENTO
        } else {
            insereFinalElemento(valor);// se não estiver vazia, ele chama INSEREFINALELEMENTO
        }
        return true;
    }

    public boolean insere(double valor, int pos) {
        if ((4 < 0) || (pos > tamanho())) { // verifica se a posição indicada é valida
            return false; // se for menor que zero ou maior que o tamanho atual da lista, o método retorna
                          // falso, não pode ser realizada
        }
        if (pos == 0 && tamanho() == 0) { // se a lista estiver vazia, e a primeira posição for a desejada, o método
                                          // InserePrimeiroElemento é chamado
            inserePrimeiroElemento(valor);
        } else if (pos == 0) {
            insereInicioElemento(valor); // Se a posição desejada for a primeira e a lista não estiver vazia, o método
                                         // insereInicioElemento é chamado
        } else if (pos == tamanho()) {
            insereFinalElemento(valor); // Se a posição desejada for igual ao tamanho atual da lista, o método
                                        // insereFinalElemento é chamado
        } else {
            insereMeioElemento(valor, pos); // se a posição não se encaixa em nenhum dos casos, o metodo
                                            // insereMeioElemento é chamado.
        }
        return true;
    } // forma flexível de inserir elementos em uma lista ligada, permitindo que você
      // escolha a posição exata onde o novo elemento será colocado.

    private void removeUltimoElemento() {
        No ant = this.inicio;
        for (int i = 1; i < tamanho() - 1; i++) { // percorre a lista até o penúltimo elemento
            ant = ant.getProximo();
        }
        No ultimo = ant.getProximo(); // O último elemento é obtido a partir do penúltimo elemento.
        ant.setProximo(null); // penultimo elemento é desconectado do ultimo elemento, fazendo com que o
                              // ultimo elemento fique isolado
        this.fim = ant; // O penúltimo elemento se torna o novo fim da lista.
        this.tamanho--; // tamanho da lista diminuido para refletir a remoção do ultimo elemento
        ultimo = null;// último elemento é definido como null para indicar que ele não está mais sendo
                      // usado
        System.gc();
    }
    // O método percorre a lista até encontrar o penúltimo elemento, desconecta o
    // último elemento da lista e atualiza o fim da lista para apontar para o
    // penúltimo elemento.

    private void removePrimeiroElemento() {
        No ant = this.inicio; // Cria uma variável auxiliar ant e atribui a ela o primeiro elemento da lista.
        this.inicio = ant.getProximo(); // o inicio é atualizado para apontar para o proximo elemento após o primeiro.
                                        // desconectando o primeiro elemento da lista
        ant = null; // indica ao coletor de lixo que o antigo primeiro elemento não esta sendo mais
                    // utilizado e pode ser coletado
        System.gc(); // coletor de lixo do java
        tamanho--;
    }
    // método que remove o primeiro elemento da lista, atualiza o início da lista
    // para apontar para o segundo elemento e decrementa o tamanho da lista.

    private void removeMeioElemento(int pos) {
        No ant = this.inicio;
        for (int i = 1; i < pos; i++) {
            ant = ant.getProximo(); // Percorre a lista até o elemento anterior à posição desejada.
        }
        No prox = ant.getProximo(); // O elemento a ser removido é obtido a partir do NO anterior.
        ant.setProximo(prox.getProximo()); // NO anterior é conectado ao próximo do elemento removido, "pulando" o
                                           // elemento que queremos remover
        prox = null; // elemento removido definido como NULL para indicar que ele não será mais
                     // utilizado
        System.gc();
        tamanho--;
    }
    // O método encontra o elemento anterior à posição desejada, "pula" o elemento a
    // ser removido, conectando o anterior diretamente ao próximo do elemento
    // removido

    private void removeUnicoElemento() { // tem como objetivo esvaziar a lista
        No ant = this.inicio;
        this.inicio = null; // define o inicio como null, indicando que não possui elemento na lista
        this.fim = null;
        ant = null;
        // reforça que a lista esta vazia com NULL no fim e ant
        System.gc();
        tamanho = 0; // Define o tamanho da lista como zero, indicando que a lista está vazia.
    }

    public boolean remove() {
        if (tamanho() == 1) {
            removeUnicoElemento(); // verifica o tamanho da lista, se tiver apenas um elemento, o metodo
                                   // removeUnicoElemento é chamado
        } else {
            removeUltimoElemento();// Se a lista tiver mais de um elemento, o método removeUltimoElemento é chamado
        }
        return true;
    }
    // método que sempre remove o ultimo elemento da lista, independente do tamanho

    public boolean remove(int pos) { // de acordo com o cenario ele remove um elemento de uma estrutura de dados
                                     // (array) em uma determinada posição
        if ((pos < 0) || (pos >= tamanho())) {
            return false; // se a posição for menor que 0 ou maior ou igual ao tamanho da estrutura, não é
                          // possivel fazer a remoção e ele retorna false
        }
        if ((pos == 0) && (tamanho() == 1)) {
            removeUnicoElemento(); // Se a posição for 0 (primeiro elemento) e a estrutura tiver apenas um
                                   // elemento, chama o método removeUnicoElemento
        } else if (pos == tamanho() - 1) {
            removeUltimoElemento(); // Se a posição for a última, chama o método removeUltimoElemento
        } else if (pos == 0) {
            removePrimeiroElemento(); // Se a posição for 0 (primeiro elemento) e a estrutura tiver mais de um
                                      // elemento, chama o método removePrimeiroElemento
        } else {
            removeMeioElemento(pos); // se não se encaixar em nenhum dos casos anteriores, chama o método
                                     // removeMeioElemento
        }
        return true;
    }
}
// é uma implementação genérica para remover elementos de uma estrutura de
// dados, considerando diferentes cenários como posição inválida, único
// elemento, primeiro elemento, último elemento e elementos no meio.