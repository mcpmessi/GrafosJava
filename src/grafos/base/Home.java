/**
 * @author Messias Pinheiro


 * */

package grafos.base;

import java.util.Scanner;

import grafos.direcionados.BuscaEmProfundidade;
import grafos.direcionados.Grafo;

@SuppressWarnings("unused")
public class Home {
	
	private Grafo grafo;
	private int nVertice;
	private Scanner read;
	
	private BuscaEmProfundidade DFS;

	public static void main(String[] args) {
		Home h = new Home();
	}
	
	public Home(){
		read = new Scanner(System.in);
		System.out.println("Informe o numero de vertices:: ");
		
		nVertice = read.nextInt();
		
		//criar o grafo nVertices (numero de vertices)
		grafo = new Grafo(nVertice);
		
		//Criar a lista ade adjacencia, Observe que ao inserir (0,1) automaticamente (1,0) será inserido, 
		//não sendo necessáriuo repetir
		
		int  opt=-1;
		
		do{
			
			opt = menu();
			
			switch (opt) {
			case 1:
				print("Informne as arestas (v, w):: ");
				int v, w;
				print("V:: ");
				try{
					v = read.nextInt();
				}catch(Exception ex){
					break;
				}
				print("W:: ");
				try{
					w = read.nextInt();
				}catch(Exception ex){
					break;
				}
				
				String add = grafo.addAdjacente(v, w);
				
				if(!add.equals("OK")){
					print(add);
				}else{
					print(add);
				}
				break;
			case 2:
				DFS = new BuscaEmProfundidade(grafo, 0);
				
				System.out.println(grafo.toString());
				
				DFS.showTempoDeDescoberta();
				System.out.println("\n\n");
				DFS.showFinalizeTime();
				break;
			default:
				break;
			}
		}while(opt!=3);
		
		read.close();
		
	}
	/**
	 * Menu de opções
	 * @return int Opção
	 * */
	private int menu(){
		print("==============OPCOES==============");
		print("\tEscolha uma ação");
		print("\t1)Add aresta\n\t2)mostrar informações\n\t3) Sair");
		
		return read.nextInt();
		
	}
	
	/**
	 * Exibe uma mensagem
	 * @param str conteúdo da mensagem
	 * */
	private void print(String str){
		System.out.println(str);
	}

}
