 package tree.genric;

import java.util.ArrayList;
import java.util.Scanner;

public class Gentrictree {

	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	Gentrictree() {
		Scanner s = new Scanner(System.in);
		this.root = takeinput(s, null, 0);
	}

	private Node takeinput(Scanner s, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter data of root node");
		} else {
			System.out.println("Enter the data for the " + ithchild + "th child of" + parent.data);
		}

		int nodedata = s.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		System.out.println("Enter the number of the children for " + node.data);
		int children = s.nextInt();

		for (int i = 0; i < children; i++) {
			Node child = this.takeinput(s, node, i);
			node.children.add(child);
		}

		return node;
	}
}
