/*
 * CIS 263-02 Winter 2017
 *
 * This file will contain the struct Node
 * and the rest of the assignment.
 *
 * @authors Jamie Penzien, Natalie Rodriguez,
 * Kate McGowan, and Nathan Pipe.
 */
 
 

template <typename T> 
struct Node{
	Node * previous;
	Node * next;
	T * data;
	
	//might work, might be terrible
	//recursivly calls down next until the end of the list is reached
	//then deletes all the way up
	void clearList() {
		if(next.next != nullptr)
			next.clearList();
		delete next;
		delete data;
	}
};

template <typename T>
class LinkedList {
	
	public:
		LinkedList() {
			size = 0;
			top = nullptr;
			tail = nullptr;
		}
		
		void clear() {
			top.clearList();
		}
	
	private:
		int size;
		struct Node<T> * top;
		struct Node<T> * tail;
		
	
};


//making a linked list- head & tail will be nullptr
//LATER store the size of the list


