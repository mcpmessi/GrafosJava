package grafos.direcionados;

public class BuscaEmProfundidade {
    private boolean[] marked;    //marked[v] = is there an s-v path?
    private int count;           //numero de vertices conectados a S
    
    private int[] d;
    private int time = 0;
    private int[] f;

    /**
     * Método construtor da classe
     * @param G Grafo
     * @param startVertex vertice raiz
     */
    public BuscaEmProfundidade(Grafo G, int startVertex) {
        marked = new boolean[G.V()];
        d = new int[G.V()];
        f = new int[G.V()];
        dfs(G, startVertex);
    }

    /**
     * Método DFS recursivo
     * @param Grafo
     * @param vertice - vertice de busca
     **/
    private void dfs(Grafo G, int vertice) {
        count++;
        time += 1;
        marked[vertice] = true;
        d[vertice] = time;
        for (int w : G.adj(vertice)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        f[vertice] = time = time + 1;
    }
    
    public void showTempoDeDescoberta(){
    	for(int i=0; i<d.length; i++){
    		System.out.println("d["+i+"] :: "+d[i]);
    	}
    }
    public void showFinalizeTime(){
    	for(int i=0; i<f.length; i++){
    		System.out.println("f["+i+"] :: "+f[i]);
    	}
    }

    /**
     * @param v Vertice
     * @return <tt>true</tt> se existe, <tt>false</tt> caso contrário
     */
    public boolean isMarcked(int v) {
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
