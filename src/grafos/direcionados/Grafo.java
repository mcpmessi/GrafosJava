/**
 * Esta classe é baseada no exemplo do Slide
 * */

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

    //Validar o vertice
    private boolean validateVertex(int v) {
        if (v < 0 || v >= V)
            return false;
        return true;
    }

    /**
     * Add edge
     * @param  v
     * @param  w
     */
    public String addAdjacente(int v, int w) {
    	if(!validateVertex(v) || !validateVertex(w)){
    		return  "Este vertice deve ser >= 0 e <"+V;
    	}
        
        //incrementar numero de Arestas
        E++;
        //adicionar arestas para o grafo nao direcionado. * (x,y),(y,x)
        adj[v].add(w);
        adj[w].add(v);
        
        return "OK";
    }


    /**
     * Retorna a lista de adjacência do vertice v
     * @param  v vertice
     * @return adj - Lista de adjacencia
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
    public String showGrafo() {
        StringBuilder s = new StringBuilder();
        s.append(V + " Vertices, " + E + " Arestas " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append("adj["+v+"]{");
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