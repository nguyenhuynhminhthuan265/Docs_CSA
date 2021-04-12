//#include <stdio.h>
//#include <stdlib.h>
//#include<limits.h>
//#include <iostream>
//using namespace std;
//typedef struct Queue
//{
//    int *data;
//    int front, rear;
//    int currentSize;
//    int capacity;
//}Queue;
//
//
//
//
//Queue* createQueue(unsigned capacity)
//{
//    struct Queue* queue = (Queue*)malloc(sizeof(Queue));
//    queue->capacity = capacity;
//    queue->front = queue->rear = queue->currentSize= 0;
//    queue->capacity = capacity;
//    queue->data = (int*)malloc(queue->capacity * sizeof(int));
//    return queue;
//}
// 
//
// int size(Queue *queue) {
//    return  queue->currentSize;
//}
//
//
// bool isEmpty(Queue* queue) {
//    return  queue->currentSize == 0;
//}
//
// bool isFull(Queue *queue) {
//    return queue->currentSize == queue->capacity;
//}
//
// void enqueue(Queue* queue, int element) {
//     if (isFull(queue)) {
//         cout << "Queue is full";
//
//     }
//
//     queue->data[queue->rear++] = element;
//     queue->currentSize++;
//     queue->rear = (queue->rear) % queue->capacity;
//
// }
//
//
//
// int dequeue(Queue* queue) {
//
//     if (isEmpty(queue)) {
//         cout << "Queue is empty";
//
//     }
//
//     queue->front = (queue->front) % queue->capacity;
//     int res = queue->data[queue->front++];
//     queue->currentSize--;
//
//     return res;
// }
//
//
//
// int peek(Queue* queue) {
//     if (isEmpty(queue)) {
//         cout << "Queue is empty";
//     }
//     return  queue->data[queue->front];
// }
//
//
//
// int main()
// {
//     Queue *myQueue = createQueue(5);
//
//     enqueue(myQueue,1);
//     enqueue(myQueue, 2);
//     enqueue(myQueue, 3);
//     enqueue(myQueue, 4);
//     enqueue(myQueue, 5);
//
//     cout << dequeue(myQueue) << endl; // 1
//     cout << dequeue(myQueue) << endl; // 2
//     cout << dequeue(myQueue) << endl; // 3
//     cout << dequeue(myQueue) << endl; // 4
//
//     cout << "current size: " + size(myQueue) << endl; //1
//     cout << isEmpty(myQueue) << endl;// false
//
//     enqueue(myQueue, 1);
//     enqueue(myQueue, 2);
//     enqueue(myQueue, 3);
//
//    
//
//     cout << dequeue(myQueue) << endl; // 5
//     cout << dequeue(myQueue) << endl; // 1
//     cout << dequeue(myQueue) << endl; // 2
//     cout << dequeue(myQueue) << endl; // 3
//
//     cout << "current size: " + size(myQueue) << endl; //0
//     cout << isEmpty(myQueue) << endl; // true
//
//     return 0;
// }