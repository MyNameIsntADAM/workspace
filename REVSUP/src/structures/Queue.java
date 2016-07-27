package structures;

public class Queue<E> extends GeneralList<E> {

	public Queue<E> enqueue(E item) {
		// CHECK THIS. WE MIGHT NEED TO ADD TO 0
		append(item);
		return this;
	}
	
	public E dequeue() {
		return remove(0);
	}
	
}
