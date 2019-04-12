package Algorithm;

class Node {
	int value;
	Node next;

	Node(int input_value) {
		this.value = input_value;
	}
}

public class SingleLinkedList {
	private Node head;
	private int count;

	public void insertHead(int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
		++count;
	}

	public Node deleteHead() {
		if (isEmpty()) {
			throw new RuntimeException("The list if empty!!");
		}

		Node temp = head;
		--count;
		head = head.next;
		return temp;
	}

	private boolean isEmpty() {
		return count == 0;
		// if (count == 0) {
		// return true;
		// } else {
		// return false;
		// }
	}

	public void print_list() {
		Node current = head;
		while (current != null) {
			System.out.println(current.value + "====");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();

		assert list.isEmpty();

		list.insertHead(5);
		list.insertHead(4);
		list.insertHead(67);

		list.print_list();

		list.deleteHead();
		System.out.println("@@@@@@@@@@@@@");
		list.print_list();

	}

}
