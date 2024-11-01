package listadipla;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() { // construtor da classe ListaDuplamenteEncadeada
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserePrimeiroElemento(double valor) {
        No aux = new No(valor); // cria um novo objeto NO e armazena na variavel AUX
        this.inicio = aux; // faz com que o atributo inicio aponte para o novo NO, fazendo com que o novo
                           // NO vire o primeiro elemento da lista
        this.fim = aux; // Como a lista estava vazia e agora possui apenas um elemento, o atributo fim
                        // também é atualizado para apontar para o novo NO
        this.tamanho = 1; // indica que a lista agora tem um elemento
    }

    public void insereInicioElemento(double valor) {
        No aux = new No(valor); // cria um novo NO
        aux.setProx(this.inicio); // o próximo NO do novo NO aponte para o NO que era anteriormente o primeiro da
                                  // lista
        aux.setAnt(null); // Como o novo NO se tornará o primeiro da lista, ele não tem nenhum NO
                          // anterior. Portanto, o anterior do novo NO é definido como null.
        this.inicio.setAnt(aux); // O NO que era anteriormente o primeiro da lista agora terá o novo NO como seu
                                 // anterior.
        this.inicio = aux; // Atualizando o atributo "inicio" da lista para o novo NO
        this.tamanho++; // indica que um novo elemento foi adicionado
    }
    // insere um novo elemento no inicio da lista, ajustando de forma que o novo NO
    // conecte corretamente aos NOS existentes e se torne o novo primeiro elemento

    public void insereFinalElemento(double valor) {
        No aux = new No(valor);
        aux.setAnt(this.fim); // faz com que o NO anterior aponte para o o NO que era o ultimo da lista
        aux.setProx(null); // como o novo NO se tornará o ultimo da lista, ele não tem nenhum NO posterior
                           // (null)
        this.fim.setProx(aux); // o NO que era o ultimo da lista, terá o novo NO como seu proximo
        this.fim = aux; // atualiza o atributo "fim" da lista para o novo NO
        this.tamanho++;
    }

    public void insereMeioElementoDoInicio(double valor, int pos) {
        No aux = new No(valor);
        No ant = this.inicio; // Inicializa a variável "ant" com o primeiro NO da lista.
        for (int i = 1; i < (pos); i++) {
            ant = ant.getProx(); // um loop que tera de 1 ate a posição desejada e a cada iteração a variavel
                                 // "ant" é avançado para o proximo NO na lista
        }
        No prox = ant.getProx(); // variavel "ant" estara apontando para o NO que esta antes da posição desejada,
                                 // então a variavel "prox" é definida como proximo NO da variavel "ant"
        aux.setProx(prox); // O novo NO "aux" tem seu próximo NO definido como "prox" (NO que estava
                           // originalmente na posição desejada)
        aux.setAnt(ant); // O novo NO "aux" tem seu anterior definido como "ant" (NO que está antes da
                         // posição desejada)
        ant.setProx(aux); // O NO "ant" (o anterior à posição desejada) tem seu próximo definido como
                          // "aux", o novo NO.
        prox.setAnt(aux); // O NO "prox" (o que estava originalmente na posição desejada) tem seu anterior
                          // definido como "aux", o novo NO
        this.tamanho++;
    }

    public void insereMeioElementoDoFim(double valor, int pos) {
        No aux = new No(valor);
        No ant = this.fim; // Inicializa a variável "ant" com o último NO da lista.
        for (int i = tamanho - 1; i >= (pos); i--) {
            ant = ant.getAnt(); // loop que tera o tamanho-1 até a posição desejada
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
        if (pos < (int) (tamanho / 2)) { // verifica se a posição desejada é menor que a metade do tamanho da lista
            insereMeioElementoDoInicio(valor, pos); // se a posição for menor, indica que a posição esta mais proximo do
                                                    // inicio da lista, entao chama o método insereMeioElementoDoInicio
        } else {
            insereMeioElementoDoFim(valor, pos); // se a posição for maior, indica que a posição esta mais proxima do
                                                 // final da lista, então chama o métoto insereMeioElementoDoFim
        }
    }
    // o método oferece uma otimização para a inserção de elementos em listas
    // duplamente encadeadas, escolhendo a melhor abordagem com base na posição
    // desejada

    public void imprimeOrdem() {
        No aux = this.inicio; // cria uma variavel "aux" e inicializa como o primeiro NO da lista
        while (aux != null) { // um loop que continua enquanto a variavel "aux" não for null. loop continuará
                              // até que todos os NOs da lista tenham sido percorridos
            System.out.println(aux.getValor()); // Imprime na tela o valor armazenado no NO atual (aux
            aux = aux.getProx(); // para o próximo NO da lista, atualizando a variável "aux" para apontar para o
                                 // próximo NO.
        }
    }
    // O método começa no início da lista, imprime o valor do primeiro NO e, em
    // seguida, avança para o próximo NO. Ele repete esse processo até chegar ao
    // final da lista (quando aux se torna nulo).

    // Especifica que o método retorna um valor booleano.
    public boolean listaVazia() {
        return (this.inicio == null); // Verifica se o atributo inicio da lista está apontando para null. Se estiver,
                                      // significa que não há nenhum NO na lista, ou seja, a lista está vazia.
    }
    // método simples, mas essencial para verificar o estado de uma lista duplamente
    // encadeada

    public boolean posValida(int pos) { // o método recebe um numero inteiro (int) "pos" como parâmetro
        return ((pos >= 0) && (pos <= this.tamanho));
    }
    // pos >= 0; verifica se o indice é maior ou igual a zero, pois ele não pode ser
    // negativo, a primeira posição geralmente é 0
    // pos <= this.tamanho; verifica se o indice é menor ou igual ao tamanho da
    // estrutura de dados, o "this.tamanho" é um atributo já contido na classe
    // ListaDuplamenteEncadeada que tem seu tamanho definido
    // O método posValida é uma forma de garantir que não ocorram erros de índice ao
    // acessar elementos de uma estrutura de dados
    // ao verificar o indice evitamos exceções como IndexOutOfBoundsException.

    public boolean insere(double valor) {
        if (listaVazia()) { // verifica se a lista esta vazia
            inserePrimeiroElemento(valor); // se estiver vazia chama o metodo InserePrimeiroElemento
        } else {
            insereInicioElemento(valor); // se a lista não estiver vazia, chama o método insereInicioElemento
        }
        return true; // Independentemente do caso, o método sempre retorna true
    }
    // O método insere é um método genérico para adicionar um novo elemento a uma
    // estrutura de dados. Ele sempre insere o novo elemento no início da estrutura,
    // seja ela vazia ou não.

    public boolean insere(double valor, int pos) { // responsavel por inserir um valor numerico de ponto flutuante
                                                   // (double) em uma posição especifica
        if (!posValida(pos)) { // Chama o método posValida para verificar se a posição fornecida é válida.
            return false; // se for valida retorna false
        }
        if ((pos == 0) && (tamanho == 0)) { // se a posição for 0 de uma lista vazia, chama o método
                                            // inserePrimeiroElemento
            inserePrimeiroElemento(valor);

        } else if (pos == 0) { // se a posição for 0 com lista não vazia, chama o método insereInicioElemento
            insereInicioElemento(valor);

        } else if (pos == tamanho) { // se a posição for igual ao tamanho da lista, chama o método
                                     // insereFinalElemento
            insereFinalElemento(valor);

        } else {
            insereMeioElemento(valor, pos); // Se nenhuma das condições anteriores for verdadeira, significa que a
                                            // posição está no meio da lista, então chama o método insereMeioElemento
        }
        return true;
    }
}