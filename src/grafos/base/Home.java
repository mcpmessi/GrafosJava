/**
 * @author Messias Pinheiro
 * 
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
		int a = 1;
		int b = 1;
		
		int c = a = a + 1;
		print(":: "+c);
		
		
		read = new Scanner(System.in);
		print("Informe o numero de vertices:: ");
		nVertice = read.nextInt();
		
		//criar o grafo nVertices (numero de vertices)
		grafo = new Grafo(nVertice);
		
		/*
		 * Criar a lista ade adjacencia, (Grafos não direcionados)::Observe que ao inserir (0,1) 
		 * automaticamente (1,0) será inserido, não sendo necessáriuo repetir.
		 **/
		
		int  opt=-1;
		
		do{
			
			opt = menu();
			
			switch (opt) {
			case 1:
				readEdge();
				break;
			case 2:
				DFS = new BuscaEmProfundidade(grafo, 0);
				
				print(grafo.showGrafo());
				
				DFS.tempoDeDescoberta();
				print("\n");
				DFS.tempoDeFinalizacao();
				
				print("Digite qualquer coisa para continuar..");
				read.next();
				
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
		print("\t1) Add aresta\n\t2) DFS\n\t3) Sair");
		
		return read.nextInt();
		
	}
	/**
	 * Obter arestas
	 * */
	private void readEdge(){
		String sV, sW;
		int s, w;
		print("Pressione -1 para sair.");
		do{

				print("Informne as arestas (v, w):: ");
				try{
					print("v:: ");
					sV = read.next();
					//terminar
					if(sV.equals("q"))
						break;
					
					s = Integer.parseInt(sV);
				}catch(Exception ex){
					break;
				}
				
				try{
					print("w:: ");
					sW = read.next();
					w = Integer.parseInt(sW);
				}catch(Exception ex){
					break;
				}
				
				String add = grafo.addAdjacente(s, w);
				
				if(!add.equals("OK")){
					print(add);
				}else{
					print(add);
				}

			
		}while(!sV.equals("q"));
	}
	
	/**
	 * Exibe uma mensagem
	 * @param str conteúdo da mensagem
	 * */
	private void print(String str){
		System.out.println(str);
	}

}
