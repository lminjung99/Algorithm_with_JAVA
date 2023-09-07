package ch03;
import java.util.ArrayList;

import  a_generateArr.generateArray;

class HeapSort{
	//min index = 1
	//pop element at root
	private int SIZE;
	private int heapArr[];
	
	public HeapSort() {
		
		
	}
	
	public void insertHeap(int input) {
		int i = ++SIZE;
		
		//min heap
		while((i!=1) && (input<heapArr[i])) {
			heapArr[i] = heapArr[i/2];
			i = i/2;
		}
		heapArr[i] = input;
	} 
	
	public int deleteElement() {
		//min heap
		
		
		int parent, child;
		int data, temp;
		
		data = heapArr[1];
		temp = heapArr[SIZE];
		SIZE-=1;
		
		parent=1;
		child=2;
		
		while(child<=SIZE) {
			//min heap
			if((child<SIZE)&&(heapArr[child]>heapArr[child+1])) {
				child = child+1;
			}
			if(temp <= heapArr[child]) break;
			heapArr[parent] = heapArr[child];
			parent = child;
			child*=2;
		}
		
		heapArr[parent] = temp;
		return data;
	}

	public int getSIZE() {
		return SIZE;
	}

	public void setSIZE(int sIZE) {
		SIZE = sIZE;
	}

	public int[] getHeapArr() {
		return heapArr;
	}

	public void setHeapArr(int[] heapArr) {
		this.heapArr = heapArr;
	}
	
	
}

public class SortingTest {
	public void printSort(ArrayList<Integer> arr) {
		for(int num : arr) {
			System.out.print(num+"\t");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> insertionSort(ArrayList<Integer> arr){
		int j;
		int temp = 0;
		for(int i=1; i<arr.size(); i++) {
			j=i;
			temp = arr.get(i);
			while((j>0) && arr.get(j-1) > temp) {
				arr.set(j, arr.get(j-1));
				j = j-1;
			}
			arr.set(j, temp);
			System.out.println("반복 + "+i);
			printSort(arr);
		}
		
		return arr;		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateArray test = new generateArray();
		ArrayList<Integer> arr = test.generateNonDupl(100);
		
		System.out.println(arr);
		SortingTest Sort = new SortingTest();
		arr = Sort.insertionSort(arr);
		//System.out.println(arr);
		
		
		
	}

}
