package structures;

public class SortedQueue<E extends Comparable<E>> extends Queue<E> {
	
	public SortedQueue<E> insert(E item) {
		Node n = new Node(item);
		/*if(head == null || tail == null) {
			insert(item, 0);
			return this;
		}*/
		if(size() < 1 || item.compareTo(head.getData()) < 0) {
			insert(item, 0);
			return this;
		}
		if(item.compareTo(tail.getData()) >= 0) {
			insert(item, count);
			return this;
		}
		// Node must be between two items;
		Node curr = head;
		while(curr.next().getData().compareTo(item) < 0) {
			curr = curr.next();
		}
		//New node will be inserted between current node and curr.next();
		n.next = curr.next();
		n.previous = curr;
		curr.next().previous = n;
		curr.next = n;
		count++;
		return this;
	}
	
	public SortedQueue<E> enqueue(E item) {
		// CHECK THIS. WE MIGHT NEED TO ADD TO 0
		return insert(item);
	}
	
	public E remove(E item) {
		if(isEmpty()) {
			System.out.println("1"); 
			return null;
		}
		if(item.compareTo(head.getData()) < 0) {
			System.out.println("2"); 
			return null;
		}
		if(item.compareTo(tail.getData()) > 0) {
			System.out.println("3"); return null;
		}
		Node curr = head;
		int pos = 0;
		while(curr.getData().compareTo(item) < 0) {
			curr = curr.next(); 
			pos++;
		}
		if(curr.getData().compareTo(item) == 0) {
			return remove(pos);
		}
		else return null;
	}
	
}
