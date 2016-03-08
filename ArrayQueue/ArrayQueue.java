package question1B;

/**
* Assignment 1 
* Question 1B
* 
* Implementation of a queues backed by an array.
*  
* @author  Jake Simmons 
* @version 1.0
* @since   2016-02-10 
*/

public class ArrayQueue<E>
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
  public ArrayQueue(int capacity)
  {             
    data = (E[]) new Object[capacity];          
  }

  /**
   * Inserts an element at the rear of the queue.
   * @param e element to add to queue
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
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  public E dequeue()
  {
    if (isEmpty()) return null;
    
    E elementRemoved = data[front];
    
    data[front] = null;      

    front = (front + 1) % data.length;
    
    size--;
    
    return elementRemoved;
  }
  
  /** Helper to determine if the queue is empty.
   * @return size
   */
  public boolean isEmpty() { return (size == 0); }
}
