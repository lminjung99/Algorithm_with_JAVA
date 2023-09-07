package ch06;

class Solution{
	
	public void solution(String[] maps) {
		int[] answer = {};
		String[] temp = null;
		char[][] parseMap = new char[maps.length][maps[0].length()];
		int[][] matrix = new int[maps.length][maps[0].length()];
		int island;
		
		for(int i=0; i<maps.length; i++) {
			parseMap[i] = maps[i].toCharArray();
			//System.out.println(parseMap[i]);
		
		}
		
		
		for(int i=0; i<maps.length; i++) {
			
			for(int j=0; j<parseMap[i].length; j++) {
				if(parseMap[i][j]=='X') {
					matrix[i][j]=0;
				}else {
					island = Character.getNumericValue(parseMap[i][j]);
					matrix[i][j] = island;
				}
				
				
			}
		}
//		
//		for(int i=0; i<maps.length; i++)
//		{
//			for(int j=0; j<maps[0].length(); j++) {
//				System.out.print(matrix[i][j]+"\t");
//			}
//			System.out.println();
//		}
		for(int i=0; i<maps.length; i++) {
			for(int j=0; j<maps[i].length(); j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
		//return answer;
	}
}

public class Maps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String[] strArr = {"X591X","X1X5X","X231X", "1XXX1"};
			Solution test = new Solution();
			test.solution(strArr);
	}

}
