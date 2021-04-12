package com.cybersoft.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {
	Node<String> root;
	private int count = 0;

	public BinarySearchTree() {
		root = null;
	}

	private Node<String> addRecursive(Node<String> current, String value) {
		if (current == null) {
			return new Node<String>(value);
		}

		if (value.compareTo(current.data) < 0) {
			current.left = addRecursive(current.left, value);
		} else if (value.compareTo(current.data) >= 0) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void insert(String data) {
		root = addRecursive(root, data);
	}

	public String safeString(String str) {
		str = str.trim();
		List<Character> characters = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		for (int i = 0; i < characters.size(); i++) {
			if ((characters.get(i) == ' ') && (characters.get(i + 1) == ' ')) {
				characters.remove(i);
				i--;
			}
		}

		str = characters.stream() // Stream<Character>
				.map(String::valueOf) // Stream<String>
				.collect(Collectors.joining());

		return str;
	}

	public void CreateTree(String data) {
		data = this.safeString(data);
		String[] strings = data.split(" ");
		for (int i = 0; i < strings.length; i++) {
			insert(strings[i]);
		}
	}

	public void NLR(Node<String> root) {
		if (root != null) {
			System.out.format("%s ", root.data);
			NLR(root.left);
			NLR(root.right);
		}
	}

	public void LNR(Node<String> root) {
		if (root != null) {

			LNR(root.left);
			System.out.format("%c", root.data);
			LNR(root.right);
		}
	}

	public void LRN(Node<String> root) {
		if (root != null) {

			LRN(root.left);
			LRN(root.right);
			System.out.format("%c", root.data);
		}
	}

	public Node<String> searchRecursive(Node<String> root, String value) {
		if (root == null || root.data.equals(value))
			return root;
		if (value.compareTo(root.data) < 0)
			return searchRecursive(root.left, value);
		else if (value.compareTo(root.data) >= 0)
			return searchRecursive(root.right, value);
		else {
			return root;
		}

	}

	public boolean search(String key) {
		root = searchRecursive(root, key);
		if (root != null)
			return true;
		else
			return false;
	}

	public int Height(Node<String> root) {
		if (root == null)
			return 0;
		int HL, HR;
		HL = Height(root.left);
		HR = Height(root.right);
		if (HL > HR)
			return (1 + HL);
		return (1 + HR);
	}

	String minValue(Node<String> root) {

		String minval = root.data;

		while (root.left != null) {
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}

	public Node<String> removeNodeRecursive(Node<String> root, String x) {
		Node<String> p;
		if (root == null) {
			System.out.format("%d khong co trong cay", x);
			return root;
		}

		else {
			if (x.compareTo(root.data) < 0)
				root.left = removeNodeRecursive(root.left, x);
			else if (x.compareTo(root.data) >= 0)
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

	public void removeNode(String x) {
		root = removeNodeRecursive(root, x);
	}

	public int countStringOfParagraph(Node<String> root, String check) {

		Node<String> p = searchRecursive(root, check);
		if (p != null) {

			count++;

			countStringOfParagraph(p.left, check);
			countStringOfParagraph(p.right, check);
		}

		return count;

	}

	public void CountEachStringOfParagraph(Node<String> root, String data) {
		List<String> list = this.safeStringDuplicate(data);
		for (int j = 0; j < list.size(); j++) {

			System.out.println(list.get(j) + ": " + countStringOfParagraph(root, list.get(j)));
			count = 0;
		}
	}

	public List<String> safeStringDuplicate(String data) { // delete item duplicate, keep only one

		data = this.safeString(data);
		List<String> list = new ArrayList<>(Arrays.asList(data.split(" ")));
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
					j--;
				}

			}

		}

		return list;

	}
}
