package structures;

public class Stack<E> extends GeneralList<E> {
	
	public Stack<E> push(E item) {
		add(item);
		return this;
	}
	
	public E pop() { return remove(0);}
	
	public E top() { return head == null ? null : head.getData(); }
	
	
	
}
