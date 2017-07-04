//Merge Two Sorted Lists
//Program By: Chris Huynh

import java.util.Scanner;

public class MergeLists {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);			
		System.out.print("Enter list1: ");														
		int listOneLength = input.nextInt();			//obtains first item of numbers entered
		int[] listOne = new int[listOneLength];			//first item determines length of list one
		
		for (int i = 0; i < listOneLength; i++) {		//stores rest of items into list one
			listOne[i] = input.nextInt();
		}
		
		System.out.print("Enter list2: ");														
		int listTwoLength = input.nextInt();			//obtains first item of numbers entered 
		int[] listTwo = new int[listTwoLength];			//first item determines length of list one
		
		for (int i = 0; i < listTwoLength; i++) {		//stores rest of items into list two
			listTwo[i] = input.nextInt();
		}
		
		int[] mergedList = merge(listOne, listTwo);		//merges list one and two together, sorted
		System.out.print("The merged list is ");
		
		for (int i = 0; i < mergedList.length; i++) {	//outputs the sorted, merged list
			System.out.print(mergedList[i] + " ");
		}
		
	}
	
	public static int[] merge (int[] list1, int[] list2) {			//merges and sorts two lists from lowest to greatest
		
		int[] mergedList = new int[list1.length + list2.length];	//determines length of merged list
		int i = 0, j = 0, k = 0;									//initializes counters to zero
		
		while (i < list1.length && j < list2.length) {				//while counters do not exceed list lengths, sort and store
			
			if (list1[i] < list2[j]) {								//compare each item of each list to eachother						
				
				mergedList[k] = list1[i];							//if item in list one is lesser, store that item into merged list
				i++;												//look at next character in list one
			} else {
				
				mergedList[k] = list2[j];							//if item in list two is lesser, store that item into merged list
				j++;												//look at next character in list two
			}
			k++;													//once item is stored in merged list, move to next open slot
		}
		
		while (i < list1.length) {									//if sorting is finished and items are left over, store the rest
			
			mergedList[k] = list1[i];
			i++;
			k++;
		}
		
		while (j < list2.length) {									//if sorting is finished and items are left over, store the rest						
			
			mergedList[k] = list2[j];
			j++;
			k++;
		}
		return mergedList;											//return merged and sorted list
	}	
}
