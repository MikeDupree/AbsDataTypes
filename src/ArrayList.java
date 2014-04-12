
public class ArrayList {
	
	private Node head,tail;
	private int size;
	
	public ArrayList() {
		// Initialize Variables
		size=0;
		head=null;
		tail=null;
	}
	
	public ArrayList(Object... objects) {
		this();
		for(int i=0; i<objects.length; i++){
			add(objects[i]);
		}
	}
	
	public int count() {
		// returns Arraylist Size
		return size;
	}
	public void add(Object data){
		Node tmpNode = new Node(data);
		if(size==0){ head=tail=tmpNode; 
		} else {
			tail.next=tmpNode;
			tail = tail.next;
		}
		size++; // increment the size after Add
	}
	public void insertAt(int index, Object data) {
		if(index>size){
			throw new ArrayIndexOutOfBoundsException(
					"Error: Index out of bounds");
		}
		Node tmpNode = new Node(data);
		if(index==0){
			tmpNode.next = head;
			head=tmpNode;
		} else {
			Node current = head;
			for(int i=0; i<index -1; i++){
				current=current.next;
			}
			tmpNode.next = current.next;
			current.next = tmpNode;
			if(index == size) {
				tail=tail.next;
			}
		}
		size++;
	}
	
	public Object getAt(int index){
		if(index>size){
			throw new ArrayIndexOutOfBoundsException(
					"Error: Index is out of bounds.");
		}
		Node current = head;
		for(int i=0; i<index; i++){
			current=current.next;
		}
		return current.data;
		
	}
	
	public void replaceAt(int index, Object data) {
		if (index > size) {
			throw new ArrayIndexOutOfBoundsException("Error: Index is out of bounds.");
		}
		Node temp = new Node(data);
		if (index == 0) {
			temp.next = head.next;
			head = temp;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (index == size - 1) {
				tail = temp;
			} else {
				temp.next = current.next.next;
			}
			current.next = temp;
		}
	}
	public void removeAt(int index) {
		if (index > size) {
			throw new ArrayIndexOutOfBoundsException("Error: Index is out of bounds.");
		}
		if (index == 0) {
			head = head.next;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (index == size - 1) {
				tail = current;
				current.next = null;
			} else {
				current.next = current.next.next;
			}
		}
		size--;
	}

	
	public void remove(Object data){
		if(head.data == data){
			head = head.next;
			size--;
		} else {
			Node current = head;
			while(current.next != null) {
				if(current.next.data==data){
					if(current.next==tail){
						tail=current;
						current.next=null;
					} else {
						current.next = current.next.next;
					}
					size--; return;
				}
				current=current.next;
			}
		}
	}
	
	public String toString() {
		String output = "{";
		
		Node current = head;
		for(int i=0; i<size; i++){
			output += " " + current.data;
			current = current.next;
			if(i != size-1){
				output+=", ";
			}
		}
		output += "}";
		return output;
	}
	
	
	
	
	
}
