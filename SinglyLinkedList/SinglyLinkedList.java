package question1A;

/**
* Assignment 1 
* Question 1A
*  
* Implementation of a singly linked list.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
* 
*/

public class SinglyLinkedList<E>
{
  /**
  * Class - Node of a singly linked list, which stores an element and reference to the next node in the list.
  * @return element from node
  */	
  public static class Node<E> 
  {
    // Element stored at in node
    private E element;           

    // Reference to the next node in the list 
    private Node<E> next;        

    /**
     * Constructor - Creates a node with element and next node.
     * @return element from node
     */
    private Node(E e, Node<E> n)
    {
      element = e;
      next = n;
    }

    /**
     * Returns element stored at the node.
     * @return element from node
     */
    public E getElement() { return element; }

    /**
     * Returns the next node.
     * @return next node in the list
     */
    public Node<E> getNext() { return next; }

    public boolean hasNext()
    {
    	boolean val = (next != null) ? true : false;
    	
    	return val;
    }
    /**
     * Sets the next node's  reference to point to Node.
     * @param next node in the list
     */
    private void setNext(Node<E> n) { next = n; }
  }

  /*
   PRIVATE VARIABLES
  */
  
  // Head node of the list 
  private Node<E> head = null;               

  // Last node in the list
  private Node<E> tail = null;               

  // Number of nodes in the list 
  private int size = 0;                      

  /*
   PRIVATE METHODS
  */
  
  /**
   * Returns node at index.
   * @param index of node you want back
   * @return node at index passed in
   */
  private Node<E> getNodeAtIndex(int index)
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
  
  /*
   PUBLIC METHODS
   */
  
  /**
   * Constructor for an empty list.
   */
  public SinglyLinkedList() { }              
  
  /**
   * Returns the number of elements in the linked list.
   *@return the number of elements in list
   */
  public int size() { return size; }


  /**
   * Tests whether the linked list is empty.
   *@return true if empty false if not empty
   */
  public boolean isEmpty() { return size == 0; }
  
  /**
   * Returns the first element of the list.
   *@return the element at this index
   */
  public E getFirstElement()
  {             
    if (isEmpty()) return null;
    
    return head.getElement();
  }
  
  /**
   * Returns the first node of the list.
   *@return the first node 
   */
  public Node<E> getFirstNode()
  {             
    if (isEmpty()) return null;
    
    return head;
  }
  
  /**
   * Returns just the element at index.
   *@param the index of the element you want back
   *@return the element at this index
   */
  public E getElementAtIndex(int index){return getNodeAtIndex(index).getElement();}

  /**
   * Removes element at index.
   *@param the index of the element you want removed
   */
  public void removeAtIndex(int index)
  {
	if(index < 0 && index >= size())
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
	
	//Get node that precedes the one you wish to delete 
	Node<E> node = getNodeAtIndex(index -1);

    if (index == 0) 
    {
        head = head.getNext();
    } 
    else
    {   
    	// Logic to handle deleting tail node
    	if(node.getNext() != null)
    	{
    		node.next = node.getNext().next;
    	}
    	else
    	{
    		node.next = null;
    		tail = node;
    	}
    }

    size--;    
  }
  
  public void deleteNode(Node<E> node)
  {
	  if(node.next != null)
	  {
		 Node<E> temp = node.next;
		 node.element = temp.element;
		 node.next = temp.next;
	     temp = null;
	     
	     size--;
	  }
  }
 
  /**
   * Returns the last element.
   *@return the last element 
   */
  public E getLastElement()
  {              
    if (isEmpty()) return null;
    
    return tail.getElement();
  }

  /**
   * Adds element to the front of the list.
   * @param the new element to add
   */
  public void addFirst(E e)
  {               
    head = new Node<>(e, head); 

    if (size == 0)
      tail = head; 

    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param the new element to add
   */
  public void addLast(E e)
  {                 
    Node<E> newest = new Node<>(e, null);    
    
    if (isEmpty())
      head = newest;                         
    else
      tail.setNext(newest);   
    
    tail = newest;                           
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element 
   */
  public E removeFirst()
  {                   
    if (isEmpty()) return null;  
    
    E answer = head.getElement();   
    head = head.getNext();       
    size--;
    
    if (size == 0)
      tail = null;   
    
    return answer;
  }
  
}

