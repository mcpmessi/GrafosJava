package grafos.direcionados;

public class Grafo {
    public static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    /**
     * @param  V Numero de vertices do grafo
     */
    @SuppressWarnings("unchecked")
	public Grafo(int V) {
        if (V < 0) throw new IllegalArgumentException("O número de vertices não pode ser negativo");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * @return V - Número de vertices do grafo
     */
    public int V() {
        return V;
    }

    /**
     * @return E - O número de arestas do grafo
     */
    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addAdjacente(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        //incrementar numero de Arestas
        E++;
        //adicionar arestas para o grafo nao direcionado. * (x,y),(y,x)
        adj[v].add(w);
        adj[w].add(v);
    }


    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     * @param  v the vertex
     * @return the vertices adjacent to vertex <tt>v</tt>, as an iterable
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * @param  v
     * @return int
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].length();
    }


    /**
     * Mostrar a estrutura do grafo
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " Vertices, " + (E/2) + " Arestas " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + "->adj{");
            int ix = 0; //controlar a vírgura
            for (int w : adj[v]){
                s.append(w + ((ix<adj[v].length()-1)?",":""));
                ix++;
            }
            s.append("}");
            s.append(NEWLINE);
        }
        return s.toString();
    }
}