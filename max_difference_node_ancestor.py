'''
Considering below binary - We have to find out maximum differnce between node and its ancestor.
		    8
		  // \\
		 3    10
	       //  \\  \\
	       1    6    14
             //\\  //
            4   7 13
'''


import sys

_MIN = sys.maxsize * -1
_MAX = sys.maxsize

class Node:
	def __init__(self,data, left, right ):
		self.left = left
		self.right = right
		self.data = data


def get_maximum_diff(curr_node, result):
	if (curr_node == None):
		return _MAX, result

	if curr_node.left is None and curr_node.right is None:
		return curr_node.data, result

	a , result = get_maximum_diff(curr_node.left , result)
	b , result = get_maximum_diff(curr_node.right, result)

	minimum_value = min(a , b)
	result = max(result , curr_node.data - minimum_value)

	return min(minimum_value, curr_node.data), result


if __name__ == '__main__':
	node_4 = Node(4, None, None)
	node_7 = Node(7, None, None)
	node_13 = Node(13, None, None)

	node_1 = Node(1, None, None)        
	node_6 = Node(6, node_4, node_7)
	node_14 = Node(14,node_13 , None)

	node_3 = Node(3, node_1, node_6)
	node_10 = Node(10,None, node_14)

	root = Node(8, node_3, node_10)

	x, res = get_maximum_diff(root, result=_MIN)
	print(res)
