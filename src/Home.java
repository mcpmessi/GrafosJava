import java.util.Scanner;

import grafos.direcionados.BuscaEmProfundidade;
import grafos.direcionados.Grafo;

@SuppressWarnings("unused")
public class Home {
	
	private Grafo grafo;
	private int nVertice;
	
	private BuscaEmProfundidade DFS;

	public static void main(String[] args) {
		Home h = new Home();
	}
	
	public Home(){
		Scanner read = new Scanner(System.in);
		System.out.println("Informe o numero de vertices:: ");
		
		nVertice = read.nextInt();
		
		
		//criar o grafo
		grafo = new Grafo(nVertice);
		
		//Criar a lista ade adjacencia
		
		for(int i=0; i<nVertice; i++){
			System.out.println("Quantos vertices estão conectados a "+i+" ::");
			int vAdj = read.nextInt();
			for(int j=0; j<vAdj; j++){
				System.out.println("Adjacente  a "+i+" ::");
				grafo.addAdjacente(i, read.nextInt());
			}
		} 
		
		read.close();
		
		//a partir daqui
		/*
		grafo = new Grafo(4);
		grafo.addAdjacente(0, 1);
		grafo.addAdjacente(1, 2);
		grafo.addAdjacente(1, 3);
		//inicializar a busca
		
		*/
		
		DFS = new BuscaEmProfundidade(grafo, 0);
		
		System.out.println(grafo.toString());
		
		DFS.showTempoDeDescoberta();
		System.out.println("\n\n");
		DFS.showFinalizeTime();
		
		
	}

}
