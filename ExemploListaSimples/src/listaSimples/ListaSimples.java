
package listaSimples;

public class ListaSimples {
    
    private No inicio;
    private No fim;
    private int tamanho;
    
    public ListaSimples(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    private void inserePrimeiroElemento(double valor){
        No aux = new No(valor);
        this.inicio = aux;
        this.fim = aux;
        this.tamanho = 1;
    }
    
    private void insereFinalElemento(double valor){
        No aux = new No(valor);
        this.fim.setProximo(aux);
        this.fim = aux;
        this.tamanho++;
    }

    private void insereInicioElemento(double valor){
        No aux = new No(valor);
        aux.setProximo(inicio);
        this.inicio = aux;
        this.tamanho++;
    }
    
    private void insereMeioElemento(double valor, int pos){
        No aux = new No(valor);
        No ant = this.inicio;
        for (int i = 1; i < pos; i++){
            ant = ant.getProximo();
        }
        aux.setProximo(ant.getProximo());
        ant.setProximo(aux);
        this.tamanho++;  
    }
    
    
    public void print(){
        No aux = this.inicio;
        while(aux != null){
            System.out.println(aux.getValor());
            aux = aux.getProximo();
        }
        System.out.println("_______________________________");  
    }
    
    public boolean listaVazia(){
        return tamanho() == 0;
    }
    
    public int tamanho(){
        //return this.tamanho;
        
        int tamanho = 0;
        No aux = this.inicio;
        while(aux != null){
            tamanho++;
            aux = aux.getProximo();
        }
        return tamanho;
    }
    
    public boolean insere(double valor){
        if (listaVazia()) { inserePrimeiroElemento(valor); }
        else { insereFinalElemento(valor);}
        return true;
    }
    
    public boolean insere(double valor, int pos){
        if ((pos < 0) || (pos > tamanho())) {
            return false;
        }
        if (pos == 0 && tamanho() == 0) {inserePrimeiroElemento(valor);}
        else if (pos == 0) {insereInicioElemento(valor);}
        else if (pos == tamanho()) {insereFinalElemento(valor);}
        else {insereMeioElemento(valor, pos);}
        return true;
    }
    
    private void removeUltimoElemento(){
        No ant = this.inicio;
        for (int i = 1; i < tamanho() - 1; i++){
            ant = ant.getProximo();
        }  
        No ultimo = ant.getProximo();
        ant.setProximo(null);
        this.fim = ant;
        this.tamanho--;
        ultimo = null;
        System.gc();
    }
    
    
    private void removePrimeiroElemento(){
        No ant = this.inicio;
        this.inicio = ant.getProximo();
        ant = null;
        System.gc();
        tamanho--;  
    }
    
    private void removeMeioElemento(int pos){
        No ant = this.inicio;
        for (int i = 1; i < pos; i++){
            ant = ant.getProximo();
        }
        No prox = ant.getProximo();
        ant.setProximo(prox.getProximo());
        prox = null;
        System.gc();
        tamanho--; 
    }
    
    private void removeUnicoElemento(){
        No ant = this.inicio;   
        this.inicio = null;
        this.fim = null;
        
        ant = null; 
        System.gc();
        tamanho = 0;
    }
    
    public boolean remove(){
        if (tamanho() == 1) { removeUnicoElemento();}
        else {removeUltimoElemento();}
        return true;
    }
    
    public boolean remove(int pos){
        if ((pos < 0) || (pos >= tamanho())){
            return false;
        }
        if ((pos == 0 ) && (tamanho() == 1)) {removeUnicoElemento();}
        else if (pos == tamanho() - 1){ removeUltimoElemento();}
        else if (pos == 0) {removePrimeiroElemento();}
        else {removeMeioElemento(pos);}
        return true;
    }
    
    
    
}

















