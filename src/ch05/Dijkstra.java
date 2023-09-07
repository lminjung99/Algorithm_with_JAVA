package ch05;
import ch04.graph.*;

public class Dijkstra {
	
	private UndirectedGraph vertexMatrix;
	private int count;
	private int[] distance;
	private boolean[] visited;
	private static int UNLIMIT = 999999999;
	
	public Dijkstra(int count) {
		this.count = count;
		vertexMatrix = new UndirectedGraph(count);
		distance = new int[count];
		visited = new boolean[count];
	}
	
	public void calcShortesPath(int from) {
		//initialization
		for(int i=0; i<count; i++) {
			distance[i] = UNLIMIT;
			visited[i] = false;
		}
		
		distance[from] = 0;
		visited[from] = true;
		
		//step1 - update distance to adjacent node
		for(int i=0; i<count; i++) {
			if(visited[from] && vertexMatrix.getVertexMatrix()[from][i]!=0) {
				distance[i] = vertexMatrix.getVertexMatrix()[from][i];
			}
		}
		for(int k=0; k<count-1; k++) {
			//step2 - select unvisited, shortest node (among adjacent nodes)
			int min = UNLIMIT;
			int minIndex = -1;
			for(int i=0; i<count; i++) {
				//if) unvisited, adjacent
				if(!visited[i] && (distance[i]!= UNLIMIT)) {
					
					if(distance[i]<min) {
						min = distance[i];
						minIndex = i;
					}
				}
			}
			
			//step3 - select unvisited node through adjacent node
			visited[minIndex] = true;
			for(int i=0; i<count; i++) {
				if(!visited[i] && vertexMatrix.getVertexMatrix()[minIndex][i]!=0) {
					if(distance[i] > distance[minIndex]+vertexMatrix.getVertexMatrix()[minIndex][i]) {
						distance[i] = distance[minIndex]+vertexMatrix.getVertexMatrix()[minIndex][i];
					}
				}
			}
		}
		
		
	}
	
	public void showDistance(int from) {
		for(int i=0; i<count; i++) {
			System.out.println(from+" 노드로부터 "+i+" 노드 까지의 최단 거리 = "+distance[i]);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 6;
		Dijkstra graph = new Dijkstra(count);
		//UndirectedGraph vertexMatrix = new UndirectedGraph(count);
		
		graph.vertexMatrix.addEdges(0, 1, 1);
		graph.vertexMatrix.addEdges(0, 2, 4);
		graph.vertexMatrix.addEdges(1, 2, 2);
		graph.vertexMatrix.addEdges(2, 3, 1);
		graph.vertexMatrix.addEdges(3, 4, 8);
		graph.vertexMatrix.addEdges(3, 5, 3);
		graph.vertexMatrix.addEdges(4, 5, 4);
		
		
		graph.calcShortesPath(0);
		graph.showDistance(0);
//		for(int i=0; i<count; i++) {
//			for(int j=0; j<count; j++) {
//				System.out.print(vertexMatrix.getVertexMatrix()[i][j]+"\t");
//			}
//			System.out.println();
//		}

	}

}
