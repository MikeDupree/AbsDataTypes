
public class Stack {

	private Node top;

	public Stack() {
		top = null;
	}

	public Stack(Object... objects) {
		this();
		for (int i = 0; i < objects.length; i++) {
			push(objects[i]);
		}
	}

	 // Pushes new data onto the stack
	public void push(Object data) {
		Node temp = new Node(data);
		if (top != null) {
			temp.next = top;
		}
		top = temp;
	}
	// pops top data off stack
	public void pop() {
		if (top != null) {
			top = top.next;
		}
	}

	// Returns data without popping
	public Object peek() {
		return top.data;
	}

	public String toString() {
		String output = "{";
		Node current = top;

		while (current != null) {
			output += " " + current.data;
			current = current.next;
		}
		output += " }";
		return output;
	}
}
