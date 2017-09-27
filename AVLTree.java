//Homework 2 - AVL Tree
//Program By: Christopher Huynh - cth150030

/*Format of text file example:
 
0786222735 Harry Potter and the Chamber of Secrets
0073383090 Discrete Mathematics and Its Applications
1501135910 Shoe Dog
0060935464 To Kill a Mockingbird
0425285405 Blue: A Novel
0439708184 Harry Potter and the Sorcerer's Stone
0553418025 The Martian
0307887448 Ready Player One

NOTE: ISBN must be an integer (32 bits)
*/

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AVLTree {

	public static void main(String[] args) throws FileNotFoundException{
		List<Book> books = new ArrayList<Book>();
		
		Scanner input = new Scanner(new FileReader("src/filename.txt"));	//Read input file for book isbns/titles
		while (input.hasNextLine()){
			String s = input.nextLine();
			String parts[] = s.split(" ", 2);
			Book book = new Book(parts[1], Integer.parseInt(parts[0]));
			books.add(book);
		}
				
		AVLTree tree = new AVLTree();
			
		for (Book book: books){
			tree.insert(book);
		}
		System.out.println("Done creating AVL tree!");
		
	}
	
	static class Book {
		int isbn;
		String title;
		
		public Book(String title, int isbn){
			this.isbn = isbn;
			this.title = title;
		}
	}
		
	private AVLNode root;
	
	static class AVLNode {
		int key;
		Book value; 
		int height;
		int balance;
		AVLNode leftPtr;
		AVLNode rightPtr;
		AVLNode parent;
		
		public AVLNode(Book info, AVLNode parent){				//AVLNode constructor
			this.key = info.isbn;
			this.value = info;
			this.parent = parent;
		}		
	}
	
	public boolean isAVLTree(AVLNode head){						//Checks if tree is AVL Tree
		return false;
	}
	
	public boolean insert(Book book){							//Insert node into AVL Tree	
		if (root == null){
			root = new AVLNode(book, null);
			return true;
		}
		
		AVLNode current = root;
		while (true) {
			
			if (current.key == book.isbn){
				return false;
			}
			
			AVLNode parent = current;
			
			boolean goLeft = current.key > book.isbn;
			if (goLeft){
				current = current.leftPtr;
			} else {
				current = current.rightPtr;
			}
			
			if (current == null){
				if (goLeft){
					parent.leftPtr = new AVLNode(book, parent);
				} else {
					parent.rightPtr = new AVLNode(book, parent);
				}
				balance(parent);
				break;
			}			
		}
		return true;		
	}
	
	private void balance(AVLNode n){							//Balance tree	
		setBalance(n);
		
		if (n.balance == -2){
			if (height(n.leftPtr.leftPtr) >= height(n.leftPtr.leftPtr)){
				n = rotateRight(n);
			} else {
				n = rotateLeftRight(n);
			}
		}
		else if (n.balance == 2){
			if (height(n.rightPtr.rightPtr) >= height(n.rightPtr.leftPtr)){
				n = rotateLeft(n);
			} else {
				n = rotateRightLeft(n);
			}
		}
		if (n.parent != null){
			balance(n.parent);
		} else {
			root = n;
		}
	}
	
	private AVLNode rotateLeft(AVLNode a){						//Rotate subtree left
		AVLNode b = a.rightPtr;
		b.parent = a.parent;
		
		a.rightPtr = b.leftPtr;
		
		if (a.rightPtr != null){
			a.rightPtr.parent = a;
		}
		
		b.leftPtr = a;
		a.parent = b;
		
		if (b.parent != null){
			if (b.parent.rightPtr == a){
				b.parent.rightPtr = b;
			} else {
				b.parent.leftPtr = b;
			}
		}
		System.out.println("Imbalance occured at inserting ISBN " + a.key + "; fixed in Left rotation");
		setBalance(a,b);
		return b;
	}
	
	private AVLNode rotateRight(AVLNode a){						//Rotate subtree right
		AVLNode b = a.leftPtr;
		b.parent = a.parent;
		
		a.leftPtr = b.rightPtr;
		
		if (a.leftPtr != null){
			a.leftPtr.parent = a;
		}
		
		b.rightPtr = a;
		a.parent = b;
		
		if (b.parent != null){
			if (b.parent.rightPtr == a){
				b.parent.rightPtr = b;
			} else {
				b.parent.leftPtr = b;
			}
		}
		System.out.println("Imbalance occured at inserting ISBN " + a.key + "; fixed in Right rotation");
		setBalance(a,b);
		return b;
	}
	
	private AVLNode rotateLeftRight(AVLNode n){					//LeftRight Rotation
		n.leftPtr = rotateLeft(n.leftPtr);
		System.out.println("Imbalance occured at inserting ISBN " + n.key + "; fixed in LeftRight rotation");
		return rotateRight(n);
	}

	private AVLNode rotateRightLeft(AVLNode n){					//RightLeft Rotation
		n.rightPtr = rotateRight(n.rightPtr);
		System.out.println("Imbalance occured at inserting ISBN " + n.key + "; fixed in RightLeft rotation");
		return rotateRight(n);
	}
	
	private int height(AVLNode n){								//Find height of node
		if (n == null){
			return -1;
		}
		return n.height;
	}
	
	private void setBalance(AVLNode...nodes ){					//Find balance factor 
		for (AVLNode n: nodes){
			newHeight(n);
			n.balance = height(n.rightPtr) - height(n.leftPtr);
		}
	}
	
	private void newHeight(AVLNode n){							//Set new height
		if (n != null){
			n.height = Math.max(height(n.leftPtr), height(n.rightPtr)) + 1;
		}
	}
}
