package grafos.direcionados;

public class BuscaEmProfundidade {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // numero de vertices conectados a S
    
    private int[] d;
    private int time = 0;

    /**
     * Método construtor da classe
     * @param G Grafo
     * @param s vertice inicial
     */
    public BuscaEmProfundidade(Grafo G, int s) {
        marked = new boolean[G.V()];
        d = new int[G.V()];
        dfs(G, s);
    }

    /**
     * Método DFS de fato.
     **/
    private void dfs(Grafo G, int v) {
        count++;
        time += 1;
        marked[v] = true;
        d[v] = time;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * @param v Vertice
     * @return <tt>true</tt> se existe, <tt>false</tt> caso contrário
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Retorna o numero de vertices ligados
     * @return <tt>count</tt>
     */
    public int count() {
        return count;
    }


}
