package question1B;

/**
* Assignment 1 
* Question 1B
* 
* Implementation of a a stack backed my two array queues.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
*/

public class StackedQueueStack<E>
{
	  // one of two backing data structure to the stack
	  private ArrayQueue<E> queueOne = null; 
	  
	  // two of two backing data structure to the stack
	  private ArrayQueue<E> queueTwo = null;
	  	  
	  private Integer capacity = 0;
		  	  
	  /**
	   * Constructs tw0 empty queues with the given array capacity.
	   * @param capacity  of the underlying arrays
	   */
	  public StackedQueueStack(int maxNumberOfElements)
	  {   
		  capacity = maxNumberOfElements;
		  queueOne = new ArrayQueue<>(capacity);
		  queueTwo = new ArrayQueue<>(capacity);
	  }
	  
	  /**
	   * Inserts an element at the top of the stack.
	   * @param e   the element to be inserted
	   * @throws IllegalStateException if the array storing the elements is full
	   */
	  public void push(E e) 
	  {
		  if (size() >= capacity) throw new IllegalStateException("Stack is full");
		  
		  queueOne.enqueue(e);
	  }
	  
	  /**
	   * Removes and returns the top element from the stack.
	   * @return element removed 
	   * @throws IllegalStateException if the array storing the elements is empty.
	   */
	  public E pop()
	  {
		  if (size() == 0) throw new IllegalStateException("Stack is empty");
		  
		  int i = 1;
		  
		  while(i != queueOne.size())
		  {
			  E dequeueVal = queueOne.dequeue();
			  queueTwo.enqueue(dequeueVal);
		  }
		  
		  E FinalDequeueVal = queueOne.dequeue();
		  
		  queueOne = queueTwo;
		  queueTwo = new ArrayQueue<>(capacity);
		  
		  return FinalDequeueVal;		  
	  }
	  
	  /**
	   * Returns number of elements in Stack
	   * @return number of elements in stack
	   */
	  public int size(){return queueOne.size();}
	  
	  /**
	   * Determines if stack is empty
	   * @return boolean 
	   */
	  public boolean isEmpty(){return (queueOne.size() == 0);}

}
