package Common;

/**
* Assignment 1 
* 
* Implementation of a Doubly linked list.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
*/
public class DoublyLinkedList<E>
{
	  
	  /**
	   * Node which stores a reference to its node before and after in the list
	   */
	  public static class Node<E>
	  {

	    // element stored in nod
	    private E element;               

	    // A reference to the previous node in the list 
	    private Node<E> prev;            

	    // A reference to the next node in the list 
	    private Node<E> next;            

	    /**
	     * Constructor to create class of node
	     *
	     * @param p  reference to previous node
	     * @param n  reference to next node
	     * @param e  element to be stored
	     */
	    public Node(Node<E> p, Node<E> n, E e)
	    {
	      element = e;
	      next = n;
	      prev = p;
	    }

	    /**
	     * Sets node's previous reference
	     * @param p  the node you wish to be before
	     */
	    public void setPrev(Node<E> p) { prev = p; }

	    /**
	     * Sets node's next reference
	     * @param n  the node you wish to follow
	     */
	    public void setNext(Node<E> n) { next = n; }
	    
	    /**
	     * Returns the node that previous
	     * @return the previous node
	     */
	    public Node<E> getPrev() { return prev; }

	    /**
	     * Returns the next node 
	     * @return the next node
	     */
	    public Node<E> getNext() { return next; }
	    
	    /**
	     * Returns the element at node.
	     * @return element stored at the node
	     */
	    public E getElement() { return element; }

	  } 

	  // head node
	  private Node<E> head;

	  // tail node
	  private Node<E> tail;                   

	  // Number of elements in the list without dummy head and tail
	  private int size = 0;                     

	  /** Constructor to create new Doubly Linked List. */
	  public DoublyLinkedList()
	  {
		//create dummy head  
	    head = new Node<>(null, null, null);
	    
	    //create dummy tail
	    tail = new Node<>(head, null, null);  
	    
	    head.setNext(tail);                    
	  }
	  
	  /**
	   * Returns first element of the list
	   * @return first element of the list or null if list is empty
	   */
	  public E first()
	  {
	    if (isEmpty()) return null;
	    
	    return head.getNext().getElement();  
	  }

	  /**
	   * Returns the last element of the list
	   * @return last element of the list or null if empty
	   */
	  public E last() 
	  {
	    if (isEmpty()) return null;
	    return tail.getPrev().getElement();   
	  }
	  
	  /**
	   * Adds element to the front of the list
	   * @param e element you wish to add
	   */
	  public void addFirst(E e)
	  {
	    addBetween(e, head, head.getNext());    
	  }

	  /**
	   * Adds an element to the end of the list
	   * @param e   element you wish to add
	   */
	  public void addLast(E e) 
	  {
	    addBetween(e, tail.getPrev(), tail); 
	  }

	  /**
	   * Deletes and returns the first element of the list
	   * @return deleted element or null if empty
	   */
	  public E deleteFirst()
	  {
	    if (isEmpty()) return null;   
	    
	    return delete(head.getNext());             
	  }

	  /**
	   * Deletes and returns the last element of the list
	   * @return deleted element or null if empty
	   */
	  public E deleteLast()
	  {
	    if (isEmpty()) return null;
	    
	    return delete(tail.getPrev());            
	  }
	  
	  /**
	   * Returns the number of elements in the linked list without dummy head and tail
	   * @return number of elements in the linked list
	   */
	  public int size() { return size; }

	  /**
	   * Determines if the list is empty.
	   * @return true if empty, false otherwise
	   */
	  public boolean isEmpty() { return size == 0; }

	  /**
	   * Returns just the element at index.
	   *@param the index of the element you want back
	   *@return the element at this index
	   */
	  public E getElementAtIndex(int index){return getNodeAtIndex(index).getElement();}
	  
	  /**
	   * Returns node at index.
	   * @param index of node you want back
	   * @return node at index passed in
	   */
	  public Node<E> getNodeAtIndex(int index)
	  {
		if(index < 0 && index >= size())
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");

	    Node<E> node = head; 

	    for(int i = 0; i < index; i++)
	    {
	        node = node.getNext();
	    }

	    return node;
	  }
	  
	  /**
	   * Adds an element to list in between nodes.
	   *
	   * @param previousNode   node before where the new element is to be inserted
	   * @param nextNode       node after where the new element is to be inserted
	   */
	  private void addBetween(E e, Node<E> previousNode, Node<E> nextNode)
	  {
	    Node<E> newest = new Node<>(previousNode, nextNode, e);
	    
	    previousNode.setNext(newest);
	    nextNode.setPrev(newest);
	    
	    size++;
	  }

	  /**
	   * Deletes node from the list and returns its value.
	   * @param node    the node to be deleted 
	   */
	  private E delete(Node<E> node)
	  {
	    Node<E> predecessor = node.getPrev();
	    Node<E> successor = node.getNext();
	    
	    predecessor.setNext(successor);
	    successor.setPrev(predecessor);
	    
	    size--;
	    
	    return node.getElement();
	  }
	  
	  /**
	   * Swaps any node with the next node except the tail node.
	   * @throws IllegalStateException
	   * @param Node you want swapped with its next node.
	   */
	  public void swapNodeWithNextNode(Node<E> current)
	  {
		  if(current.next != null)
		  {
			boolean switchHead = false;
			boolean switchTail = false;
			  
			if(current == head) {switchHead = true;}
			  
			if(current.getNext() == tail){switchTail = true;}
			
	        Node<E> tempNextNode = current.getNext();
	        
	        current.setNext(current.getNext().next);
	        tempNextNode.setPrev(current.getPrev());
	        
	        if(!switchTail)
	        {
	        	current.getNext().setPrev(current);
	        }
	        
	        if(!switchHead)
	        {
	        	tempNextNode.getPrev().setNext(tempNextNode);
	        }
	        
	        tempNextNode.setNext(current);
	        current.setPrev(tempNextNode);
	                	       	        
	        //Only switch the head node pointer head node gets swapped 
	        if(switchHead){head.next = tempNextNode;}
	        
	        //Only switch the tail pointer if the tail node gets swapped
	        if(switchTail){tail.prev = current; }	    
	        
		  }
		  else
		  {
			  throw new IllegalStateException("Can't swap tail node.");
		  }
	  }
	  
	  /**
	   * Reverses the order of the list
	   * @throws IllegalStateException
	   */
	  public void reverse()
	  {
		  Node<E> temp= head;
		  head= tail;
		  tail= temp;
		  
		  //create a node and point to head
		  Node<E> current = head; 
		  
		  //Loop through list until end
		  while(current!=null)
		  { 
			  //Set a temp node to next node of current node
		      temp=current.next; 
		      
		      //Swap current nodes next ref to its previous ref
		      current.next=current.prev;
		      
		      //Swap current nodes previous ref to its original next node
		      current.prev=temp;
		      
		      //Set current node to next node to be swapped 
		      current=current.next;
		  }	  
	  }
}
