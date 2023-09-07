package ch02;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ch01.MinMaxProblem;

public class BinarySearch {
	
	public ArrayList<Integer> ascendingArr(ArrayList<Integer> arr){
		int small = 0;
		int big = 0;
		
		for(int i=0; i<arr.size()-1; i++) {
			for(int j=i+1; j<arr.size(); j++) {
				if(arr.get(i)>arr.get(j)) {
					small = arr.get(j);
					big = arr.get(i);
					arr.set(i, small);
					arr.set(j, big);
				}
			}
		}
		return arr;
	}
	

	public int getIndex(ArrayList<Integer> arr, int target) {
		System.out.println("\n"+target);
		int index = 0;
		int left = 0;
		int right = arr.size()-1;
		int mid = (left+right)/2;
		
		int temp = arr.get(mid);
		
		boolean find = false;
		
		while(left<=right) {
			
			if(target==temp) {
				find = true;
				index = mid;
				break;
			}else if(target>temp) {
				//target - right side
				left = mid+1;
				
			}else {
				//target - left side
				right = mid-1;
	
			}
			
			mid = (right+left)/2;
			temp = arr.get(mid);
		}
		
		if(find==true) {
			System.out.println("target is found - index : "+mid);
			
		}else {
			System.out.println("target is not found");
			index = -1;
		}
		return index;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MinMaxProblem test = new MinMaxProblem();
		BinarySearch binaryTest = new BinarySearch();
		Scanner sc = new Scanner(System.in);
		int range = 10;
		ArrayList<Integer> arr = new ArrayList<>();
		
		arr = test.generateNonDupl(100);
		System.out.println(arr);
		arr = binaryTest.ascendingArr(arr);
		System.out.println(arr);
		
		int userNum = sc.nextInt();
		int index = binaryTest.getIndex(arr, userNum);
		if(index==-1) {
			System.out.println("Search Fail");
		}else {
			System.out.println("target index : "+index);
		}
		
	}

}
