package hash;

public class HashTable<V extends Comparable<V>> {
	
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
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		generate(capacity, loadFactor, incPCT);
	}
	
	@SuppressWarnings("unchecked")
	public V get(V value) {
		int hashcode = value.hashCode();
		int home = hash(hashcode);
		while(values[home] != null && ((V)(values[home])).compareTo(value) != 0) {
			home = (home + 1) % capacity;
		}
		if(values[home] == null) 
			return null;
		return (V)values[home];
	}
	
	@SuppressWarnings("unchecked")
	public int verify() {
		int num = 0;
		for(int i = 0; i < capacity; i++) {
			if(values[i] != null) {
				if(get((V)values[i]) == null) {
					num++;
				}
			}
		}
		return num;
	}
	
	public boolean isFull() {
		for(int i = 0; i < values.length; i++) {
			if(values[i] == null) 
				return false;
		}
		return true;
	}
	
	private int distance(int home, int key) {
		return home > key ? capacity + (key - home) : (key - home); 
	}
	
	private int hash(int key) {
		return key % capacity;
	}
	
	@SuppressWarnings("unchecked")
	public HashTable<V> rehash() {
		int oldCap = capacity;
		capacity += capacity*incPCT/100 + 1;
		Object[] tempValues = new Object[capacity];
		for(int i = 0; i < oldCap; i++) {
			if(values[i] != null) {
				int newPos = hash(values[i].hashCode());
				int home = hash(values[i].hashCode());
				while(tempValues[newPos] != null) {
					newPos = (newPos + 1) % capacity;
				}
				if(distance(home, newPos) > distance(home, i)) {
					tempValues[i] = (V)values[i];
				}
				else {
					tempValues[newPos] = (V)values[i];
				}
			}
		}
		values = tempValues;
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
		if(size*100.0/capacity > loadFactor) 
			rehash();
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
		if(size*100.0/capacity > loadFactor) 
			rehash();
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public V removeAt(int pos) {
		V value = (V)values[pos];
		if(values[pos] != null) {
			shiftUp(pos);
		}
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public V remove(V value) {
		int hashcode = value.hashCode(), home = hash(hashcode);
		while(values[home] != null && ((V)(values[home])).compareTo(value) != 0) {
			home = (home + 1) % capacity;
		}
		if(values[home] == null) return null;
		V val = (V)values[home]; values[home] = null;
		size--;
		shiftUp(home, (home + 1) % capacity);
		return val;
	}
	
	@SuppressWarnings("unchecked")
	private V shiftUp(int position) {
		V value = (V)values[position];
		if(values[position + 1] == null) {
			values[position] = null;
		}
		else {
			values[position] = values[position + 1];
			shiftUp(position + 1);
		}
		return value;
	}
	
	private void shiftUp(int empty, int nextPos) {
		if(values[nextPos] == null) return;
		int home = hash(values[nextPos].hashCode());
		int homeToEmpty = distance(home, empty);
		int homeToNext = distance(home, nextPos);
		if(homeToEmpty < homeToNext) {
			values[empty] = values[nextPos]; values[nextPos] = null;
			shiftUp(nextPos, (nextPos + 1) % capacity);
		}
		else {
			shiftUp(empty, (nextPos + 1) % capacity);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void show() {
		V value;
		System.out.println("\n\t=========Hashtable Contents=========");
		for(int i = 0; i < capacity; i++) {
			value = (V)values[i];
			System.out.printf("%4d\t%s\n", i, value == null ? "null" : value);
		}
		System.out.print("\t====================================\n");
	}
	
}
