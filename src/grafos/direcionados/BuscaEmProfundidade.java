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
     * @param s vertice inicial
     */
    public BuscaEmProfundidade(Grafo G, int s) {
        marked = new boolean[G.V()];
        d = new int[G.V()];
        f = new int[G.V()];
        dfs(G, s);
    }

    /**
     * Método DFS recursivo
     * @param Grafo
     * @param v - vertice raiz
     **/
    private void dfs(Grafo G, int v) {
        count++;
        time += 1;
        System.out.println("time["+v+"]="+time);
        marked[v] = true;
        d[v] = time;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
            	System.err.println("Visitado::"+w);
                dfs(G, w);
            }
        }
        f[v] = time = time + 1;
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
