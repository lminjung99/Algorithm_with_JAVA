package ch04.graph;

public class UndirectedGraph {
	
	private int count;
	private int[][] vertexMatrix;
	
	public UndirectedGraph(int count) {
		this.count = count;
		vertexMatrix = new int[count][count];
	}
	
	
	
	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int[][] getVertexMatrix() {
		return vertexMatrix;
	}



	public void setVertexMatrix(int[][] vertexMatrix) {
		this.vertexMatrix = vertexMatrix;
	}



	public void addEdges(int from, int to, int weight) {
		vertexMatrix[from][to] = weight;
		vertexMatrix[to][from] = weight;
	}

}
