#include <iostream>
using namespace std; 

template<typename T> class Node {
   
        T data;
        struct Node<T>* next; 
        struct Node<T>* prev; 
  
};