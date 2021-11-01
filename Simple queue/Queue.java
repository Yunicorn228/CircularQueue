public class Queue
{
    private Item front;
    private Item rear;

    public Queue()
    {
        front = null;
        rear = null;
    }

    public void insert(int i)
    {
        Item item = new Item(i);

        //queue is empty
        if (isEmpty())
            front = item;
        //queue is not empty
        else
            rear.next = item;
        rear = item;
    }

    public int remove()
    {
        int temp = -999;    //initialize to unusual value
        if (isEmpty()) {
            System.out.println("Error in remove() - queue is empty");
            System.err.println("Error in remove() - queue is empty");
            System.exit(1);
        }
        else {
            temp = front.info;
            front = front.next;
        }
        return temp;
    }

    public Boolean isEmpty()
    {
        return front == null;
    }
}
