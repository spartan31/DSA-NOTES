package bst;

import java.util.LinkedList;
import java.util.Queue;

public class bstClass {

	private Bst<Integer> root;
	
	private  void printlevel(Bst<Integer> root) {
		Queue<Bst<Integer>> start = new LinkedList<>();
		start.add(root);
		while (!start.isEmpty()) {
			Bst<Integer> temp = start.remove();
			System.out.print(temp.data + ": ");
			if (temp.left != null) {
				System.out.print(" L " + temp.left.data);
				start.add(temp.left);
			}
			if (temp.right != null) {
				System.out.print(" R " + temp.right.data);
				start.add(temp.right);
			}

			System.out.println();
		}

	}
	public void print() {
		printlevel(root);
	}

	public void insert(int data) {
		root = inserthelp(root, data);
	}

	private Bst<Integer> inserthelp(Bst<Integer> root, int data) {
		if (root == null) {
			Bst<Integer> newNode = new Bst<Integer>(data);
			return newNode;
		}

		if (root.data > data) {
			root.left = inserthelp(root.left, data);
		} else {
			root.right = inserthelp(root.right, data);
		}
		return root;
	}

	public void delete(int data) {
		root = deletehelp(root, data);
	}

	private Bst<Integer> deletehelp(Bst<Integer> root, int data) {
		if(root == null) {
			return null;
		}
		if(root.data > data) {
			root.left = deletehelp(root.left, data);
			return root;
		} else if(root.data < data) {
			root.right = deletehelp(root.right, data);
			return root ;
		}else{
			if(root.left == null && root.right == null) {
				return null;
			}else if(root.left == null) {
				return root.right ;
			}else if(root.right == null) {
				return root.left ;
			} else {
				Bst<Integer> minNode = root.right;
				while(minNode.left != null ) {
					minNode = minNode.left ;
				}
				root.data = minNode.data;
				root.right = deletehelp(root.right,minNode.data);
			  return root;
			}
		}
	}

	public boolean search(int data) {
		return isdatahelp(root, data);
	}

	private boolean isdatahelp(Bst<Integer> root, int data) {
		if (root == null) {
			return false;
		}

		if (root.data == data) {
			return true;
		} else if (root.data > data) {
			return isdatahelp(root.left, data);
		} else {
			return isdatahelp(root.right, data);
		}

	}

}
