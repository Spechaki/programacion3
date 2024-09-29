package clase5Actividad2;

public class MatrizAdyacencia {
	int numVertices;
	private int grafo[][];
	
	//Constructor
	public MatrizAdyacencia(int numVertices) {
		super();
		this.numVertices = numVertices;
		grafo = new int[numVertices][numVertices];
		
		for(int i = 0; i < numVertices;i++)
			for (int j = 0; j < numVertices; j++)
				grafo[i][j] = 0;	
	}
	
	public void insertarArista(int v1, int v2) {
		
		if(v1 >= numVertices|| v2 >= numVertices)
			System.out.println("Vertices invalidos");
		else {
			grafo[v1][v2] = 1;
		}
	}
	
	public boolean VerificarArista(int v1, int v2){
		if(v1 >= numVertices || v2 >= numVertices){ 
			System.out.println("Vertices invalidos");
		}
		else if(grafo[v1][v2] == 1){
			return true;
		}		
		return false;
	}
	
	public void eliminarArista(int v1, int v2) {
		
		if(v1 >= numVertices|| v2 >= numVertices)
			System.out.println("Vertices invalidos");
		else {
			grafo[v1][v2] = 0;
		}
	}
	
	public void listarAdyacentes(int v1) {
		
		if(v1 >= numVertices)
			System.out.println("Vertice invalidos");
		else {
			for(int i = 0; i < numVertices;i++) {
				if (grafo[v1][i] == 1)
					System.out.print(i + ' ');
			}
		}
	}
	
	public int aristasEntrantes(int v1) {
		int j = 0;
		if(v1 >= numVertices)
			System.out.println("Vertice invalidos");
		else {
			for(int i = 0; i < numVertices;i++) {
				if (grafo[i][v1] == 1)
					j++;
			}
		}
		return j;
	}
	
	
	public int aristasSalientes(int v1) {
		int j = 0;
		if(v1 >= numVertices)
			System.out.println("Vertice invalidos");
		else {
			for(int i = 0; i < numVertices;i++) {
				if (grafo[v1][i] == 1)
					j++;
			}
		}
		return j;
	}
}
