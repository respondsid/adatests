package com.test.lists.sample;

public class LinkList<T> {
	private static class Node<T>{
		T value;
		Node<T> nextNode;
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public Node<T> getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
		
	}

	Node<T> headNode;
}
