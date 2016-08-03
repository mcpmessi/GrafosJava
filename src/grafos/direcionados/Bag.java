package grafos.direcionados;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    //Classe para a lista encadeada
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    
    
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Verificar se o bag est� vazio, se o primeiro item do n� � vazio, 
     * en�o n�o h� refer�ncia para outros N�S, logo o bag � vazio.
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Retorna o numero de items no Bag
     * @return n Numero de Items do Bag
     */
    public int length() {
        return n;
    }

    /**
     * Adicionar um Item ao Bag
     * @param  {Item}
     */
    public void add(Item item) {
    	
        Node<Item> old = first;		//guardar o n� anterior
        first = new Node<Item>();   //criar um no novo
        
        first.item = item;
        first.next = old;
        n++;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    @SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


}