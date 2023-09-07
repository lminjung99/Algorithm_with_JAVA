package ch01;

import java.util.ArrayList;
import java.util.Random;

public class MinMaxProblem {
	Random rand = new Random();
	
	class Minimum{
		int min;
		int minPos;
		
		public Minimum() {
			this.min = 0;
			this.minPos = 0;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMinPos() {
			return minPos;
		}
		public void setMinPos(int minPos) {
			this.minPos = minPos;
		}
		
	}
	
	class Maximum{
		int max;
		int maxPos;
		public Maximum() {
			this.max = 0;
			this.maxPos=0;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public int getMaxPos() {
			return maxPos;
		}
		public void setMaxPos(int maxPos) {
			this.maxPos = maxPos;
		}
		
	}
	
	public boolean checkDupl(ArrayList<Integer> arr) {
		int count=0;
		for(int i=0; i<arr.size()-1; i++) {
			for(int j=i+1; j<arr.size(); j++) {
				if(arr.get(i)==arr.get(j)) {
					count++;
				}
			}
			
		}
		//System.out.print(count+"\t");
		if(count>0) return true;
		return false;
	}
	
	public ArrayList<Integer> generateArr(int limit){
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<10; i++) {
			int num = rand.nextInt(limit);
			arr.add(num);
		}
		return arr;
	}
	
	public ArrayList<Integer> generateNonDupl(int limit){
		ArrayList<Integer> my_arr = null;
		while(true) {
			ArrayList<Integer> arr = generateArr(limit);
			if(checkDupl(arr)) {
				continue;
			}else {
				my_arr = arr;
				break;
			}
		}
		return my_arr;
	}

	public Minimum getMin(ArrayList<Integer> arr) {
		Minimum min_class = new Minimum();
		
		int min = arr.get(0);
		int minPos = 0;
		
//		for(int i=0; i<arr.size()-1; i++) {
//			for(int j=i+1; j<arr.size(); j++) {
//				if(arr.get(i)<arr.get(j)) {
//					min = arr.get(i);
//					minPos = i;
//				}
//			}
//			
//		}
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i)<min) {
				min = arr.get(i);
				minPos = i;
			}
		}
		min_class.setMin(min);
		min_class.setMinPos(minPos);
		
		return min_class;
	}
	
	public Maximum getMax(ArrayList<Integer> arr) {
		Maximum max_class = new Maximum();
		int max = 0;
		int maxPos = 0;
		
//		for(int i=0; i<arr.size()-1; i++) {
//			for(int j=i+1; j<arr.size(); j++) {
//				if(arr.get(i)<arr.get(j)) {
//					max = arr.get(j);
//					maxPos = j;
//				}
//			}	
//		}
		for(int i=0; i<arr.size(); i++) {
			if(max<arr.get(i)) {
				max = arr.get(i);
				maxPos = i;
			}
		}
		max_class.setMax(max);
		max_class.setMaxPos(maxPos);
		
		return max_class;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinMaxProblem test = new MinMaxProblem();
		ArrayList<Integer> arr;
		int upperbound = 100;
		arr = test.generateNonDupl(upperbound);
		System.out.println(arr);
		
		Maximum MaxClass = test.getMax(arr);
		Minimum MinClass = test.getMin(arr);
		
		System.out.println("max : "+MaxClass.getMax()+", maxPos : "+MaxClass.getMaxPos());
		System.out.println("min : "+MinClass.getMin()+", minPos : "+MinClass.getMinPos());
		
		
		
	}

}
