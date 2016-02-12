package question1A;

import question1A.SinglyLinkedList.Node;

/**
* Assignment 1 
* Question 1A
* 
* Implementation of a Priority queue backed by a singly linked list.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
*/

public class LinkedListPriorityQueue<E> 
{	
	  // Backing data structure to the priority queue
	  private SinglyLinkedList<Integer> priorityQueue = new SinglyLinkedList<>(); 
	  
	  /**
	  * Constructor
	  */	
	  public LinkedListPriorityQueue() { }                  
	  	  
	  /**
	  * Returns the number of elements in the queue.
	  * @return Integer
	  */
	  public int size() { return priorityQueue.size(); }
	  
	  /**
	  * Adds an element to the front of the queue.
	  * @param Integer
	  */
	  public void add(Integer x) { priorityQueue.addFirst(x); }
	  
	  /**
	  * Removes the smallest element in the queue.
	  */
	  public void deleteMin()
	  {
		int listSize = priorityQueue.size();
		
		if(listSize == 0)
			throw new  IllegalStateException("Queue is empty.");
		
		int lowValueIndex = 0;
		int lowValue = priorityQueue.getElementAtIndex(lowValueIndex);
		
		for(int i=1; i<listSize; i++)
		{
			int currentNodeValue = priorityQueue.getElementAtIndex(i);
			
			if(currentNodeValue < lowValue)
			{
				lowValueIndex = i;
				lowValue = currentNodeValue;
			}			
		}
		
		priorityQueue.removeAtIndex(lowValueIndex);
	  }
	  
	  /**
	  * Removes the smallest element in the queue.
	  */
	  public void deleteMin2()
	  {
		  Node<Integer> node = priorityQueue.getFirstNode();		  
		  Node<Integer> lowNode = priorityQueue.getFirstNode();
		  int lowValue = node.getElement();
		  
		  while(node.hasNext())
		  {
			  Node<Integer> tempNode = node.getNext();
			  
			  int tempVal = tempNode.getElement();
			  
			  if(tempVal < lowValue)
			  {
				  lowNode = tempNode;
				  lowValue = tempVal;
			  }
			  
			  node = node.getNext();
		  }
		 
		  priorityQueue.deleteNode(lowNode);
	  }
	  
	  public void deleteNode(Node<E> node)
	  {

	  }
	  
	  /**
	  * Returns element at index.
	  * @param Integer
	  * @return Integer
	  */
	  public Integer getElementAtIndex(int index){return priorityQueue.getElementAtIndex(index);}
	  
}
