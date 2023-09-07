package ch04.graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BfsSearch {
	
	int count;
	boolean[] visited;
	ArrayList<Integer> queue;
	int[][] matrix;
	
	
	public BfsSearch(int count) {
		this.count = count;
		queue = new ArrayList<Integer>(count);
		visited = new boolean[count];
	}
	

	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public boolean[] getVisited() {
		return visited;
	}



	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}



	public ArrayList<Integer> getQueue() {
		return queue;
	}



	public void setQueue(ArrayList<Integer> queue) {
		this.queue = queue;
	}



	public int[][] getMatrix() {
		return matrix;
	}



	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public void BfsTraversal(int from) {
		
		//start
		queue.add(from);
		visited[from] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.remove(0);
			
			System.out.println(node);
			for(int i=0; i<count; i++) {
				if(!visited[i] && matrix[node][i]!=0) {
					queue.add(i);
					visited[i] = true;
				}
			}
			
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 5;
		UndirectedGraph graph = new UndirectedGraph(count);
//		graph.addEdges(0, 1, 1);
//		graph.addEdges(0, 2, 1);
//		graph.addEdges(1, 3, 1);
//		graph.addEdges(1, 4, 1);
//		graph.addEdges(2, 5, 1);
//		graph.addEdges(2, 6, 1);
//		graph.addEdges(3, 7, 1);
		//graph.addEdges(4, 5, 1);
		
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 1);
		graph.addEdges(1, 2, 1);
		graph.addEdges(1, 3, 1);
		graph.addEdges(2, 4, 1);
		graph.addEdges(3, 4, 1);
		
		BfsSearch bfs = new BfsSearch(count);
		bfs.matrix = graph.getVertexMatrix();
		
		bfs.BfsTraversal(3);
		
//		for(int i =0; i<count; i++) {
//			for(int j=0; j<count; j++) {
//				System.out.print(bfs.matrix[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		
		

	}

}
