package exemplolistaestatica;
import listaEstatica.*;

public class ExemploListaEstatica {
    public static void main(String[] args) {
        
        ListaEstatica le = new ListaEstatica();
        le.insere(0);
        le.insere(5);
        le.insere(7);
        le.insere(2);
        
        le.insere(90,0);
        le.insere(56,le.tamanho());
        
        le.insere(100,10);
        
        
        le.imprimeLista();
        
        
    }
    
}
