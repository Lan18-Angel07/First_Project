
public class NodeType<T extends Comparable<T>> {
	public T info;
	public NodeType<T> next;
	public NodeType<T> back;
	
	// Constructor
	public NodeType(T item) {
		info = item;
		back = null;
		next = null;
	}
	
	// This helped me with my compareTo method calls so that items could
	// be compared easilier 
	public T getInfo() { return info; }
}