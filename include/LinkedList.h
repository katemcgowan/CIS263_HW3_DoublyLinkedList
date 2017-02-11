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
	
	Node(Node & p , Node & n, T & d) {
		previous = p;
		next = n;
		data = d;
	}
	
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
		
		// adds to end of list
		void add(T & data) {
			if(top == nullptr) {
				top = new struct Node<T>(nullptr, nullptr, data);
				tail = top;
			}
			//
			tail.next = new struct Node<T>(/*not so sure about this*/&tail, nullptr, data);
			tail = tail.next;
			size++;
			
		}
		
		// adds to beginning of list????
		void addFirst(T & data) {
			if(tail == nullptr) {
				tail = new struct Node<T>(nullptr, nullptr, data);
				top = tail;
			}
			top.next = new struct Node<T>(nullptr, &top, data);
			top = top.next;
			size++;
		}
	
		//add at position
		void insert(int index, T data) {
			if(index == 0)
				addFirst(data);
			else if(index == size())
				add(data);
			else {
			//stuff
			}

		}
		
		int size() {
			return size;
		}
		
		//removes all elements from the list
		void clear() {
			top.clearList();
		}
		
		struct Node<T> get(int position) {
			struct Node<T> * pointer = *top;
			if (position < (size()/2)) {
				for(int i = 0; i <= position; i++) {
					pointer = pointer.next;
				}

			} else {
				pointer = *tail;
					for(int i = size(); i >= position; i--) {
					pointer = pointer.next;
				}

			}
		return pointer;
		}
	
		void remove(int position) {
			struct Node<T> * pointer = *top;
			if (position < (size()/2)) {
				for(int i = 0; i <= position; i++) {
					pointer = pointer.next;
				}

			} else {
				pointer = *tail;
					for(int i = size(); i >= position; i--) {
					pointer = pointer.next;
				}

			}
		delete pointer;
		}
	private:
		int Size;
		struct Node<T> * top;
		struct Node<T> * tail;
		
	
};


//making a linked list- head & tail will be nullptr
//LATER store the size of the list


