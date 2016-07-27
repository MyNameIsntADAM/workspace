package hash;

import structures.*;

public class HashTable<V extends Comparable<V>> {
	//Might have to use Object[] rather than K[] or V[]
	private Object[] values;
	private int capacity, size;
	private float loadFactor, incPCT;
	
	public HashTable() {
		generate(10, 80.0f, 50.0f);
	}
	
	public HashTable(int capacity) {
		generate(capacity, 80.0f, 50.0f);
	}
	
	public HashTable(int capacity, float loadFactor) {
		generate(capacity, loadFactor, 50.0f);
	}
	
	public HashTable(int capacity, float loadFactor, float incPCT) {
		generate(capacity, loadFactor, incPCT);
	}
	
	private void generate(int capacity, float loadFactor, float incPCT) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		this.incPCT = incPCT;
		values = new Object[capacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		generate(capacity, loadFactor, incPCT);
	}
	
	public V putPull(V value) {
		
		return value;
	}
	
	public boolean isFull() {
		for(int i = 0; i < values.length; i++) {
			if(values[i] == null) return false;
		}
		return true;
	}
	
	private int distance(int home, int key) {
		return home > key ? capacity + (key - home) : (key - home); 
	}
	
	private int hash(int key) {
		return key % capacity;
	}
	
	//Finish this
	public HashTable<V> rehash() {
		//Increment capacity by incPCT
		capacity += capacity*incPCT/100;
		Object[] temp = new Object[capacity];
		for(int i = 0; i < values.length; i++) {
			temp[i] = values[i];
		}
		values = temp;
		return this;
	}
	
	public HashTable<V> put(V value) {
		int home = hash(value.hashCode());
		//Check for no collision
		//Since we always increment values[] before it is full, we can safely assume values[] is NOT full.
		while(values[home] != null) {
			home = (home + 1) % capacity;
		}
		values[home] = value;
		size++;
		if(size*100.0/capacity > loadFactor) rehash();
		return this;
	}
	
	public HashTable<V> put(int key, V value) {
		int home = hash(key);
		//Check for no collision
		//Since we always increment values[] before it is full, we can safely assume values[] is NOT full.
		while(values[home] != null) {
			home = (home + 1) % capacity;
		}
		values[home] = value;
		size++;
		if(size*100.0/capacity > loadFactor) rehash();
		return this;
	}
	
	public V remove(V value) {
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public void show() {
		V obj;
		System.out.println("\t\t=========Hashtable Contents=========");
		for(int i = 0; i < capacity; i++) {
			//if(i != 0 && i % 6 == 0) System.out.println();
			obj = (V) values[i];
			System.out.printf("%s\n", obj == null ? "null" : obj);
		}
	}
	
	public static void main(String[] args) {
		HashTable<Member> members = new HashTable<Member>();
		/*for(int i = 0; i < 10; i++) {
			members.put(10, new Member());
		}*/
		for(int i = 0; i < 50; i++) {
			members.put(new Member());
		}
		members.show();
	}
	
}
