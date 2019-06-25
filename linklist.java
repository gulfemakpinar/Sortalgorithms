
//-----------------------------------------------------
//Description: This class defines a linked list. 
//-----------------------------------------------------
import java.util.Iterator;

public class linklist<Item> implements Iterable<Item> {

	private Node first = null;
	private Node last = null;
	private int numOfitems = 0;

	public class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty()
	// --------------------------------------------------------
	// Summary: returns true if linked list is empty else returns false.
	// --------------------------------------------------------
	{
		return first == null;
	}

	int size()
	// --------------------------------------------------------
	// Summary: returns the size of the linked list
	// --------------------------------------------------------
	{
		return numOfitems;
	}

	void add(Item item)
	// --------------------------------------------------------
	// Summary: add item to the linked list.
	// Precondition: item is an Item.
	// --------------------------------------------------------
	{
		// increment the numberOFitem.
		numOfitems++;

		// point first node by using oldfirst
		Node oldlast = last;

		// create a node and add item to it and point new node by using last
		// node.
		last = new Node();
		last.item = item;
		// and point null using last next.
		last.next = null;

		// if linked list is empty first node is also the last node.
		if (isEmpty()) {
			first = last;
		}
		// point last using oldlast next so that link last node to linked list.
		else
			oldlast.next = last;
	}

	Item get(int index)
	// --------------------------------------------------------
	// Summary: return item in indexth index in the linked list.
	// Precondition: index is an integer.
	// --------------------------------------------------------
	{
		Node current = first;
		// using for loop point indexth item in the linked list.
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.item;
	}

	Item remove(int index)
	// --------------------------------------------------------
	// Summary: return item in indexth index in the linked list.
	// and remove it.
	// Precondition: index is an integer.
	// --------------------------------------------------------
	{

		numOfitems--;
		Node current = first;
		// using for loop point (index-1)th item in the linked list.
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		// gets the item next to the current one
		Item temp = current.next.item;
		// linked the current node to the next of the next of the current node
		// so that we can remove indexth item.
		current.next = current.next.next;
		// if it is empty assign last to null
		if (isEmpty())
			last = null;

		return temp;
	}

	void addTo(Item item, int index)
	// --------------------------------------------------------
	// Summary:add item to the indexth index.
	// Precondition: index is an integer. item is an Item.
	// --------------------------------------------------------
	{
		// increment the numberOFitem.
		numOfitems++;

		// if index equals to zero, creates new node add item to node's item.
		// first points to new node.
		if (index == 0) {
			Node temp = new Node();
			temp.item = item;
			temp.next = first;
			first = temp;
		} else {

			Node current = first;
			// using for loop point indexth item in the linked list.
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node temp = current.next;
			// creates new node add item to node's item. next of the current
			// points to new node.
			current.next = new Node();
			current.next.item = item;
			current.next.next = temp;
		}

	}

	void removeAll()
	// --------------------------------------------------------
	// Summary: removes all nodes.
	// --------------------------------------------------------
	{
		// assigns first and last to null, numberOfitems to zero.
		first = null;
		numOfitems = 0;
		last = null;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		// assign current to first due to starting from the first.
		private Node current = first;

		public boolean hasNext()
		// if current is not equal to null that means that there is not any item
		// except from item in current.
		{
			return current != null;
		}

		public Item next()
		// items in linked list start from first and go to last.
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
