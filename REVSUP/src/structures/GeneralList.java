package structures;

import java.util.Iterator;

/**
 *
 * @author Adam H.
 */
public class GeneralList<E> {

    //GList member variables
    Node head, tail; //First and Last node 
    int count = 0;
    
    
    class GLIterator<E> implements Iterator<E> {
    	
    	Node curr;
    	boolean forward = true;
    	
    	public GLIterator() {
    		this(true);
    	}

		public GLIterator(boolean dir) {
			forward = dir;
    		curr = forward ? head : tail;
    	}
    	
    	public boolean hasNext() {
			return curr != null;
		}

		public E next() {
			if(curr == null) {
				return null;
			}
			//Check this
			E object = (E) curr.getData();
			curr = forward ? curr.next  : curr.previous;
			return object;
		}
    	
    }
    
    public GLIterator iterator() {
		return new GLIterator();
	}
	
	public GLIterator iterator(boolean dir) {
		return new GLIterator(dir);
	}
    
    public class Node {   
        Node next, previous;
        private E data;
    
        public Node(E item) {
            data = item; next = previous = null;
        }
        
        public Node next() {
            return next;
        }
        
        public Node prev() {
            return previous;
        }
        
        public void setPrev(Node n) {
            previous = n;
        }
        
        public void setNext(Node n) {
            next = n;
        }
        
        public boolean hasNext() {
            if(next != null) return true;
            return false;
        }
        
        public E getData() {
            return data;
        }
        
    }
    
    public GeneralList() {
        
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count <= 0;
    }
    
    protected GeneralList<E> add(E item) {
    	return insert(item, 0);
    }
    
    protected GeneralList<E> append(E item) {
    	return insert(item, count - 1);
    }
    
    protected GeneralList<E> insert(E item, int pos) {
        Node n = new Node(item);
        if(count <= 0) {
            head = tail = n;
            count++;
            return this;
        }
        if(pos <= 0) {
            addToFront(n);
            return this;          
        }
        if(pos >= count) {
            addToEnd(n);
            return this;
        }
        Node curr = head;
        for(int i = 1; i < pos; i++) {
            curr = curr.next();
        }
        //Inserting the Node n between Node curr and Node curr.next()
        n.setNext(curr.next());
        curr.setNext(n);
        n.setPrev(curr);
        n.next().setPrev(n);
        count++;
        
        return this;
    }
    
    protected void addToFront(Node n) {
        n.setNext(head);
        head.setPrev(n);
        head = n;
        count++;
        
    }
    
    protected void addToEnd(Node n) {
        n.setPrev(tail);
        tail.setNext(n);
        tail = n;
        count++;
    }
    
    public E remove(int pos) {
    	//If empty list or invalid position, do nothing.
    	if(count <= 0 || pos < 0 || pos >= count) {
    		return null;
    	}
		Node ptr = head;
    	if(count == 1) {
    		// ptr points to head's memory address. When we set head = null, ptr does
    		// not point to null, it points to head's old memory address.
    		head = tail = null;
    		count--;
    		return ptr.getData();
    	}
    	// If deleting head
    	if(pos == 0) {
    		head = head.next();
    		//We make ptr.next = null so it can be deallocated.
    		ptr.next = ptr.previous = head.previous = null;
    		count--;
    		return ptr.getData();
    	}
    	// If deleting tail
    	if(pos == count - 1) {	// remove the last one
    		ptr = tail;
    		tail = tail.prev();
    		ptr.previous = tail.next = null;
    		count--;
    		return ptr.getData();
    	}
    	// Deleting between head and tail; there are at >= 3 nodes in the list
    	for(int i = 0; i < pos; i++) {
    		ptr = ptr.next();
    	}
    	// Setting the node right before the node to deleted to have next point to ptr's next
    	// and vice versa for previous
    	ptr.previous.next = ptr.next;
    	ptr.next.previous = ptr.previous;
    	ptr.next = ptr.previous = null;
    	count--;
    	return ptr.getData();
    }
    
    public String toString() {
        Node curr = head;
        String s = head.toString();
        while(curr.next() != head) {
            curr = curr.next();
            
        }
        return s;
    }
    
    public void show() {
        Node curr = head;
        int k = 0;
        while(curr != null) {
            System.out.println(curr.getData());
            curr = curr.next();
        }
    }
    
    
}
