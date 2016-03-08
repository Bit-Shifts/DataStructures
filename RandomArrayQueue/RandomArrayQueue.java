package question4;

import java.util.Random;

/**
* Assignment 1 
* Question: 4
* Implementation Random Array Queue.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
*/
public class RandomArrayQueue<E>
{
	  // Number of elements in the queue.
	  private int size = 0;   
	  
	  // Index of the first element.
	  private int front = 0;                            

	  // backing array for storage. 
	  private E[] data;                                                     

	  /**
	   * Constructs and empty queue with the given array capacity.
	   * @param capacity  of the underlying array
	   */
	  @SuppressWarnings("unchecked")
	  public RandomArrayQueue(int capacity)
	  {             
	    data = (E[]) new Object[capacity];          
	  }

	  /**
	   * Inserts an element at the rear of the queue.
	   * @param new element to be inserted
	   * @throws IllegalStateException if the array is full
	   */
	  public void enqueue(E e) 
	  {
	    if (size == data.length) throw new IllegalStateException("Queue is full");
	    
	    int avail = (front + size) % data.length;   
	    
	    data[avail] = e;
	    
	    size++;
	  }

	  /**
	   * Returns, but does not remove, the first element of the queue.
	   * @return the first element of the queue (or null if empty)
	   */
	  public E first()
	  {
	    if (isEmpty()) return null;
	    
	    return data[front];
	  }
	  
	  /**
	   * Returns the number of elements in the queue.
	   * @return number of elements in the queue
	   */
	  public int size() { return size; }

	  /**
	   * Removes random element in queue 
	   * Front never changes and the removal comes at the rear
	   * with the random index being swapped with rear element then deleted
	   * @return element removed (or null if empty)
	   */
	  public E remove()
	  {
	    if (isEmpty()) return null;
	    
	    int RearIndex = (front + size()) -1;
	    
	    Random r = new Random();
	    
	    //Get random index
	    int randomIndex = r.nextInt(RearIndex - front) + 0;
	    
	    E RearElement = data[RearIndex];
	    E elementRemoved = data[randomIndex];
	    
	    data[randomIndex] = RearElement;    
	    data[RearIndex] = null;      
	    
	    size--;
	    
	    return elementRemoved;
	  }
	  
	  /** Helper to determine if the queue is empty. */
	  public boolean isEmpty() { return (size == 0); }

}
