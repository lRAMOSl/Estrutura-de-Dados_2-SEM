package listaSimples;

public class No {

    private double valor; // declaração de uma variavel privada, que só pode ser modificada dentro da
                          // própria classe
    private No proximo;

    public No(double valor) {
        // construtor para a classe NO. public indica que é visivel de qualquer lugar
        // dentro do programa. double valor, esse é o parâmetro do construtor
        this.valor = valor; // se refere ao campo valor do objeto que está sendo criado.
        this.proximo = null; // se refere ao campo proximo do objeto que está sendo criado.

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    // acima são os getter e setter, que são usados para encapsular e controlar o
    // acesso aos atributos privados de uma classe.
}
