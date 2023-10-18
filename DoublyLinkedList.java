
public class DoublyLinkedList<T extends Comparable<T>> {

	private NodeType<T> head;
	private int length;

	// Constructor
	public DoublyLinkedList() {
		head = null;
		length = 0;
	}

	public void insertItem(T item) {
		NodeType<T> newNode = new NodeType<T>(item);
		NodeType<T> current = head;

		if (head == null) {
			// If the list is empty, insert the new item as the head.
			head = newNode;
		} else if (item.equals(head.getInfo())) {
			// Prevent duplicates at the head.
			System.out.println("Item already exists");
			return;
		} else if (item.compareTo(head.getInfo()) < 0) {
			// If the new item should be inserted before the current head, update the head.
			newNode.next = head;
			head.back = newNode;
			head = newNode;
		} else {
			// Traverse the list to find the correct position to insert the new item.
			while (current.next != null && item.compareTo(current.next.info) > 0) {
				current = current.next;
			}

			if (current.next != null && item.equals(current.next.info)) {
				// Prevent duplicates elsewhere in the list.
				System.out.println("Item already exists");
				return;
			} else {
				// Insert the new item after 'current'.
				newNode.back = current;
				newNode.next = current.next;

				if (current.next != null) {
					current.next.back = newNode;
				}
				current.next = newNode;
			}
		}
	}

	public void deleteItem(T item) {
		NodeType<T> current = head;

		while (current != null) {
			if (item.compareTo(current.getInfo()) == 0) {
				// Found the item to delete.
				if (current == head) {
					// If it's the head, update the head.
					head = current.next;
					if (head != null) {
						head.back = null;
					}
				} else {
					// Update the next and back pointers of neighboring nodes.
					NodeType<T> prevNode = current.back;
					prevNode.next = current.next;
					if (current.next != null) {
						current.next.back = prevNode;
					}
				}
				// Successfully deleted.
				return;
			}
			current = current.next;
		}

		// If item was not found, you can print a message or take other action.
		System.out.println("The item is not present in the list");
	}

	public int length() {
		length = 0;
		NodeType<T> current = head;

		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	public void print() {
		// Print the items in the list in their current order
		NodeType<T> current = head;

		while (current != null) {
			System.out.print(current.getInfo() + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void printReverse() {
		// Print the items in reverse order
		NodeType<T> current = head;
		// Go to back of list
		while (current != null && current.next != null) {
			current = current.next;
		}

		while (current != null) {
			System.out.print(current.getInfo() + " ");
			current = current.back;
		}
		System.out.println();
	}

	public void deleteSubsection(T lower, T upper) {
		NodeType<T> current = head;
		// Check for invalid cases of application
		if (current == null || lower.compareTo(upper) > 0) {
			return;
		} else {
			// Move the lower bound to correct position
			while (current != null && lower.compareTo(current.getInfo()) > 0) {
				current = current.next;
			}
			
			NodeType<T> prevNode = null;
			// Prevents error from case where lower is higher than the highest
			// element in the list
			if (current != null) {
				prevNode = current.back;
			}
			// Get rid of nodes between lower and upper
			while (current != null && prevNode != null && lower.compareTo(current.getInfo()) <= 0
					&& upper.compareTo(current.getInfo()) >= 0) {

				prevNode.next = current.next;
				
				if (current.next != null) {
					current.next.back = prevNode;
				}
				current = current.next;
			}
			// Special case for if lower is less than or equal to head
			if (current == head) {
				while (current != null && upper.compareTo(current.getInfo()) >= 0) {
					current = current.next;
					head = current;
					if (head != null) {
						head.back = null;
					}
				}
			}
		}
	}
	
	public void reverseList() {
		NodeType<T> prev = null;
		NodeType<T> current = head;
		// I feel like this is pretty straight forward but via making these 'prev',
		// 'current', and 'nextNode' variables; we can swap the values of the originals
		// like how one would swap the value of two variables using a 'temp'.
		while (current != null) {
			NodeType<T> nextNode = current.next;
			current.next = prev;
			current.back = nextNode;
			prev = current;
			current = nextNode;
		}
		head = prev;
	}

	public void swapAlternate() {
		NodeType<T> current = head;
		// Make a temp variable so that 'current.info' can be changed and such that
		// 'current.next.info' can equal what it once was. Then iterate by going to the
		// "next next" node as we are doing this in pairs of two.
		while (current != null && current.next != null) {
			T temp = current.info;
			current.info = current.next.info;
			current.next.info = temp;
			current = current.next.next;
		}
	}
    // method in case I needed it. It was mentioned in the prompt
    public NodeType<T> getHead() {
    	return head;
    }
}
