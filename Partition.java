//Partition of a List
//Program By: Chris Huynh

import java.util.Scanner;

public class Partition {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list: ");
		int listLength = input.nextInt();						//gets first input which determines list length
		int[] numberList = new int[listLength];					//creates an array with designated length
		
		for (int i = 0; i < numberList.length; i++) {			//stores rest of input into number list
			numberList[i] = input.nextInt();
		}
		
		partition(numberList);									//partitions list given
		
		System.out.print("After the partition, the list is ");
		
		for (int i = 0; i < numberList.length; i++) {			//outputs partitioned list
			System.out.print(numberList[i] + " ");
		}
	}
	
	public static int partition(int[] list) {					//partitions list using first entry as a pivot
		
		int pivot = list[0];									//obtains pivot value
		int index = 0;											//initializes current location being searched
		int last = list.length - 1;								//initializes last location in number list
		
		while (index < last) {									//loops through each value in number list
			
			if (pivot >= list[index + 1]) {						//if the pivot is >= to the current number...
				
				list[index] = list[index + 1];					//swap that number and the pivot
				list[index + 1] = pivot;
				index++;
			} else {											//if the pivot is less than the current number...
				
				int temporary = list[last];				
				list[last] = list[index + 1];					//move the number to the end of the list
				list[index + 1] = temporary;	
				last--;
			}	
		}
		return index;											//return the index of the pivot after partition
	}
}
