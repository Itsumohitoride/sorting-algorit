package sorting;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static Integer[] array;

	/*
	  [3, 1, 8, 5, 9, 4, 2, 6, 7]
	  [1, 3, 5, 8, 4, 2, 6, 7, 9]
	  [1, 3, 5, 4, 2, 6, 7, 8, 9]
	  [1, 3, 4, 2, 5, 6, 7, 8, 9]
	  [1, 3, 2, 4, 5, 6, 7, 8, 9]
	  [1, 2, 3, 4, 5, 6, 7, 8, 9]
	 */

	/**public static void main(String[] args) {
		//array = new int[] {3,1,8,5,9,4,2,6,7};
		
		long star;
		long end;
		
		array = createArray(10000);
		
		Integer[] copyArray = Arrays.copyOf(array, array.length);

		System.out.println("Insertion Started");	
		star = System.nanoTime();
		insertionSort();
		end = System.nanoTime();
		System.out.println("Insertion Terminated");
		
		array = copyArray;
		copyArray = Arrays.copyOf(array, array.length);
		
		System.out.println("Bubble Started in "+(end-star)+" nano seconds");	
		star = System.nanoTime();
		bubbleSort();
		end = System.nanoTime();
		System.out.println("Bubble Terminated in "+(end-star)+" nano seconds");	
		
		array = copyArray;
		copyArray = Arrays.copyOf(array, array.length);
		
		System.out.println("Insertion Started");	
		star = System.nanoTime();
		selectionSort();
		end = System.nanoTime();
		System.out.println("Insertion Terminated in "+(end-star)+" nano seconds");	
	}*/
	
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		System.out.println(myList);
		addSorted(myList,53);
		System.out.println(myList);
		addSorted(myList,21);
		System.out.println(myList);
		addSorted(myList,38);
		System.out.println(myList);
		addSorted(myList,15);
		System.out.println(myList);
		addSorted(myList,76);
		System.out.println(myList);
	}
	
	public static void addSorted(List<Integer> list, int newValue) {
		
		if(list.isEmpty()) {
			list.add(newValue);
		}
		else {
			
			int i = 0;
			
			while(i < list.size() && list.get(i) < newValue) {
				i++;
			}
			System.out.println(i);
			list.add(i, newValue);
		}
	}
	
	public static void comparingSortingAlgorithms() {
		
	}
	
	public static Integer[] createArray(int n) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(i+1);
		}
		
		Collections.shuffle(a);
		return a.toArray(new Integer[0]);
	}

	public static void bubbleSort() {

		int changes = 1;

		for (int i = 1; i < array.length && changes>0; i++) {

			changes = 0;

			for(int j = 0; j<array.length-i; j++) {
				if(array[j] > array[j+1]) {

					int temp = array[j];

					array[j] = array[j+1];
					array[j+1] = temp;
					changes++;
				}
			}	
		}
	}
	
	public static void selectionSort() {

		for (int i = 0; i < array.length-1; i++) {

			int min = array[i];

			for (int j = i+1; j < array.length; j++) {
				if(array[j] < min) {
					int temp = array[j];
					array[j] = min;
					min = temp;
				}
			}
			array[i] = min;
		}

	}

	public static void insertionSort() {
		
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j-1]>array[j]; j--) {
				
				int temp = array[j];
				
				array[j] = array[j-1];
				array[j-1] = temp;
			}
		}
	}
}
