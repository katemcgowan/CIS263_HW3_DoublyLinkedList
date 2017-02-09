/*
 * CIS 263-02 Winter 2017
 *
 * This file will contain the struct Node
 * and the rest of the assignment.
 *
 * @authors Jamie Penzien, Natalie Rodriguez,
 * Kate McGowan, and Nathan Pipe.
 */


//typedef struct Node; 

template <typename Object>
typedef struct Node_ {
	Node_ * previous;
	Node_ * next;
	Object * data;
} Node;

//making a linked list- head & tail will be nullptr
//LATER store the size of the list


