#include <stdio.h>
#include <stdlib.h>
#include<limits.h>
#include <iostream>
using namespace std;
struct NODE {
	int data;
	NODE* pNext;

    NODE(int d)
    {
        data = d;
        pNext = NULL;
    }
};

struct Queue {
    NODE* front, * rear;
    Queue()
    {
        front = rear = NULL;
    }

    void enQueue(int x)
    {

        
        NODE* temp = new NODE(x);

      
        if (rear == NULL) {
            front = rear = temp;
            return;
        }

       
        rear->pNext = temp;
        rear = temp;
    }

    
    void deQueue()
    {
        
        if (front == NULL)
            return;

        
        NODE* temp = front;
        front = front->pNext;

      
        if (front == NULL)
            rear = NULL;

        delete (temp);
    }
};

int main()
{

    Queue q;
    q.enQueue(10);
    q.enQueue(20);
    q.deQueue();
    q.deQueue();
    q.enQueue(30);
    q.enQueue(40);
    q.enQueue(50);
    q.deQueue();
    cout << "Queue Front : " << (q.front)->data << endl;
    cout << "Queue Rear : " << (q.rear)->data;

    return 0;
}
