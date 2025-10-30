class MyCircularQueue
{
    int[] data;
    int front=-1;
    int rear=-1;
    int size=0;
    public MyCircularQueue(int k)
    {
        data=new int[k];
    }
    public boolean enQueue(int value)
    {
        if(isFull())
        {
            return false;
        }
        if(size==0)
        {
            front = 0;

        }
        rear+=1;
        rear=rear%data.length;
        data[rear]=value;
        size++;
        return true;

    }
    public boolean deQueue()
    {
        if(isEmpty())
        {
            return false;
        }
        front+=1;
        front=front%data.length;
        size--;
       
        if(size==0)
        {
            front=-1;
            rear=-1;
        }
         return true;
    }
    public int Front()
    {
        if(size==0)
        return -1;
        return data[front];

    }
    public int Rear()
    {
        if(isEmpty())
        {
            return -1;
        }
        return data[rear];

    }
    public boolean isEmpty()
    {
        return size==0;

    }
    public boolean isFull()
    {
        return size==data.length;
    }
}

