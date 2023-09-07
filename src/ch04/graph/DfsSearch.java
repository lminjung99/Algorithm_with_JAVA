package ch04.graph;

import java.util.Stack;

public class DfsSearch {

	//stored in stack
	
	int count;
	boolean[] visited;
	Stack<Integer> stack;
	int[][] matrix;
	
	public DfsSearch(int count) {
		this.count = count;
		visited = new boolean[count];
		stack = new Stack<Integer>();
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



	public Stack<Integer> getStack() {
		return stack;
	}



	public void setStack(Stack<Integer> stack) {
		this.stack = stack;
	}



	public int[][] getMatrix() {
		return matrix;
	}



	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}



	public void dfsTraversal() {
		stack.push(0);
		visited[0] = true;
		
		while(!stack.empty()) {
			int node = stack.pop();
			System.out.print(node+"\t");
			for(int j=0; j<count; j++) {
				if((matrix[node][j]!=0) && !visited[j]) {
					stack.push(j);
					visited[j] = true;
				}
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 8;
		UndirectedGraph graph = new UndirectedGraph(count);
		
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 1);
		graph.addEdges(1, 3, 1);
		graph.addEdges(1, 4, 1);
		graph.addEdges(2, 5, 1);
		graph.addEdges(2, 6, 1);
		graph.addEdges(3, 7, 1);
		
		DfsSearch dfs = new DfsSearch(count);
		dfs.matrix = graph.getVertexMatrix();
		dfs.dfsTraversal();
		

	}

}
