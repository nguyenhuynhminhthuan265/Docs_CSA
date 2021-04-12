package com.cybersoft.bst;

import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {
	Node<Character> root;
	private int count = 0;

	public BinarySearchTree() {
		root = null;
	}

	private Node<Character> addRecursive(Node<Character> current, char value) {
		if (current == null) {
			return new Node<Character>(value);
		}

		if (value < current.data) {
			current.left = addRecursive(current.left, value);
		} else if (value >= current.data) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void insert(char data) {
		root = addRecursive(root, data);
	}

	public void CreateTree(String data) {

		for (int i = 0; i < data.length(); i++) {
			insert(data.charAt(i));
		}
	}

	public void NLR(Node<Character> tree) {
		if (tree != null) {
			System.out.format("%c", tree.data);
			NLR(tree.left);
			NLR(tree.right);
		}
	}

	public void LNR(Node<Character> tree) {
		if (tree != null) {

			LNR(tree.left);
			System.out.format("%c", tree.data);
			LNR(tree.right);
		}
	}

	public void LRN(Node<Character> tree) {
		if (tree != null) {

			LRN(tree.left);
			LRN(tree.right);
			System.out.format("%c", tree.data);
		}
	}

	public Node<Character> searchRecursive(Node<Character> root, char x) {
		if (root == null)
			return null;
		if (x < root.data)
			return searchRecursive(root.left, x);
		else if (x > root.data)
			return searchRecursive(root.right, x);
		else {
			return root;
		}

	}

	public boolean search(char key) {
		root = searchRecursive(root, key);
		if (root != null)
			return true;
		else
			return false;
	}

	public int Height(Node<Character> root) {
		if (root == null)
			return 0;
		int HL, HR;
		HL = Height(root.left);
		HR = Height(root.right);
		if (HL > HR)
			return (1 + HL);
		return (1 + HR);
	}

	char minValue(Node<Character> root) {
		// initially minval = root
		char minval = root.data;
		// find minval
		while (root.left != null) {
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}

	public Node<Character> removeNodeRecursive(Node<Character> root, char x) {
		Node<Character> p;
		if (root == null) {
			System.out.format("%d khong co trong cay", x);
			return root;
		}

		else {
			if (x < root.data)
				root.left = removeNodeRecursive(root.left, x);
			else if (x > root.data)
				root.right = removeNodeRecursive(root.right, x);
			else {
				p = root;
				if (p.right == null)
					return root.left;
				else if (p.left == null)
					return root.right;
				else {
					root.data = minValue(root.right);

					root.right = removeNodeRecursive(root.right, root.data);

				}

			}
			return root;
		}

	}

	public void removeNode(char x) {
		root = removeNodeRecursive(root, x);
	}

	public int countCharOfParagraph(Node<Character> root, char check) {

		Node<Character> p = searchRecursive(root, check);
		if (p != null) {

			count++;

			countCharOfParagraph(p.left, check);
			countCharOfParagraph(p.right, check);
		}

		return count;

	}

	public void CountEachCharOfParagraph(Node<Character> root, Character[] characters) {

		for (int j = 0; j < characters.length; j++) {

			System.out.println(characters[j] + ": " + countCharOfParagraph(root, characters[j]));
			count = 0;
		}
	}

	public Character[] ChuanHoaMang(String data) {

		List<Character> characters = data.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		for (int i = 0; i < characters.size(); i++) {
			for (int j = i + 1; j < characters.size(); j++) {
				if (characters.get(i) == characters.get(j)) {
					characters.remove(j);
					j--;
				}

			}

		}
		return characters.toArray(new Character[characters.size()]);

	}
}
