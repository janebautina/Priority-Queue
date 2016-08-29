/**
 * Find max element 
 * insert log(N), deleteMax log(n)
 * @param <Key>
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {
	private Key [] array; //priority queue array
	private int n = 0; //array capacity 

	public Comparable [] getArray() {
		return this.array;
	}
	public MaxPriorityQueue(){}
	
	/**
	 * Constructor with initial capacity
	 * @param max - queue capacity
	 */
	public MaxPriorityQueue(int max){
		this.array = (Key[]) new Comparable[max + 1];
	} 
	
	/**
	 * Constructor with initial key values
	 * @param a - Key values array
	 */
	public MaxPriorityQueue(Key[] a){
		this.array = a;
		
	}
	
	/**
	 * Insert a value to the priority queue
	 * @param i - value to add
	 */
	public void insert(Key i) {
		n++;
		array[n] = i;
		swim(n);
	}
	
	/**
	 * Return the maximum value from the 
	 * priority queue
	 * @return max value in the priority queue
	 */
	public Key max(){
		return array[1];
	} 
	
	/**
	 * Return and delete the max value from the 
	 * priority queue
	 * @return max value in the priority queue
	 */
	public Key deleteMax(){
		Key result = array[1];
		swap(1, n);
		array[n] = null;
		n--;
		sink(1);
		return result;
	}
	
	/**
	 * Is the priority queue empty?
	 * @return true if the priority 
	 * queue is empty, otherwise return false
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Get number of keys in the 
	 * priority queue
	 * @return number of keys
	 */
	public int size() {
		return this.n;
	}
	
	/**
	 * 
	 * @param i - index of element in the priority 
	 * queue array
	 * @param j - index of element in the priority 
	 * queue array
	 * @return true if i < j and false otherwise 
	 */
	private boolean less(int i, int j) {
		return array[i].compareTo(array[j]) < 0;
	}
	
	/**
	 * Swaps two elements in the priority queue array
	 * @param i - index of the element to exchange
	 * @param j - index of the element to exchange
	 */
	private void swap(int i, int j){
		Key temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Button - up reheapifying, new node's key is larger
	 * then parent's one. Swim to higher level of the heap
	 * @param k - index of a new element inserted in the 
	 * priority queue
	 */
	private void swim(int k) {
		while (k > 1 && less(k/2, k)){
			swap(k/2, k);
			k = k/2;
		}
	}
	
	/**
	 * Top - down reheapifying. When a parent node become smaller 
	 * then it's children.
	 * @param k -index of a new element inserted in the 
	 * priority queue
	 */
	private void sink(int k) {
		while( 2 * k < n) {
			int j = 2 * k;
			if(j < n && less(j, j+ 1)) j++; 
			if(less(j, k)) 
				break;
			swap(j, k);
			k = j;
		}
	}
	
}
