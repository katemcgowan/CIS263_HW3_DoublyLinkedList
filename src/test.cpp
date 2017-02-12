#include "LinkedList.h"
#include <iostream>

int main(int argc, char* argv[]) {
	LinkedList<int> test;
	test.add(3);
	test.add(2);
	test.add(1);
	test.add(0);
	
	std::cout << *test.get(0)->data << "\n";
	std::cout << *test.get(1)->data << "\n";
	std::cout << *test.get(2)->data << "\n";
	std::cout << *test.get(3)->data << "\n";
	
	test.clear();
}
