public class ArrayQueue<T> implements QueueInterface<T>
{
    public static final int MAX = 10;

    //use only these 3 instance variables!
    //you are NOT ALLOWED to add more instance variables
    private T elements[];
    private int front;
    private int rear;

    public ArrayQueue()
    {
        //awkward syntax!
        elements = (T[]) new Object[MAX];
        //the usual initialisations
        // front = MAX - 1;
        // rear = MAX - 1;
        
        //tweaked here to deliberately force early wrapping!
        front = MAX - 3;
        rear = MAX - 3;
    }
    
    //implement your methods with Javadoc comments here
    //again, you are NOT ALLOWED to add more instance variables


    /**
     * Insert a T element inside the circular queue.
     * 
     * @param inputString the T element the use is going to insert to the queue
     */
    public void insert(T inputString) throws QueueOverFlowException{

        // set the item to T as require.
        Item<T> item = new Item<T>(inputString);

        //check if the queue is full
        if((rear + 1) % MAX == front){

            //throw the error message of overflow exception
            throw new QueueOverFlowException("Can not add into full queue");
        
        //check if the queue is empty using the isEmpty method
        }else if(isEmpty()){

            //if the queue is empty and the rear pointer is at the last index
            if(rear == MAX - 1){

                //set the rear to 0 index and inset the item to the front index
                rear = 0;
                elements[front] = item.info;

            //if the queue is empty and rear is not at the last index
            }else{

                //increment the rear index by one and set the element to the front index 
                rear++;
                elements[front] = item.info;
            }
        
        //if the queue is not empty and the rear index is at last one
        }else if(rear == MAX - 1){

            //set the item to the rear index and change the rear index to 0
            elements[rear] = item.info;
            rear = 0;

        //if the queue is not empty and rear index is not at last index
        }else{

            //set the item to the rear index and increment the rear index by one
            elements[rear] = item.info;
            rear++;
        }
    }

    /**
     * Remove a element from the circular array
     * 
     * @return return the element info that has been removed form the queue
     */
    public T remove() throws QueueUnderflowException {
        
        //if the circular queue is empty throw the underflow exception
        if(isEmpty()){
            throw new QueueUnderflowException("Remove attempted on empty queue");
        }

        //if the front index is at the last index
        if(front == MAX - 1){

            //set the front to zero and return the element from the previous index
            front = 0;
            //MAX - 1 is the previous index
            return elements[MAX - 1];

        //if the front index is not ant last one
        }else{

            //increment the front by one and return the element from the previous index
            front++;
            return elements[front - 1];
        }      
    }

    /**
     * Check if the circular queue is empty of not
     * 
     * @return check if the front and rear index is the same
     */
    public Boolean isEmpty() {

        //return the boolean value for compare front and rear index
        return front == rear;
    }
}
