
public class Queue {
	private Node head;
	private Node tail;

	public Queue() {
		head = null;
		tail = null;
	}

	public Queue(Object... objects) {
		this();
		for (int i = 0; i < objects.length; i++) {
			enqueue(objects[i]);
		}
	}
	// insert data at the back
	public void enqueue(Object data) {
		Node temp = new Node(data);
		if (head == null) {
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}
	// remove data from front of queue
	public void dequeue() {
		if (head != null) {
			head = head.next;
		}
	}
	// Returns data at front
	public Object peek() {
		return head.data;
	}

	// String representation of Object
	public String toString() {
		String output = "{";
		Node current = head;
		while (current != null) {
			output += " " + current.data;
			current = current.next;
		}
		output += " }";
		return output;
	}

}
