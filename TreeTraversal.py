class Node:
	def __init__(self,data,left,right):
		self.data =data
		self.left = left
		self.right = right

def inOrderTraversal(node):
	if node is not None:
		inOrderTraversal(node.left)
		print(node.data, end=' ')
		inOrderTraversal(node.right)

def postOrderTraversal(node):
	if node is not None:
		postOrderTraversal(node.left)
		postOrderTraversal(node.right)
		print(node.data, end=' ')

def preOrderTraversal(node):
	if node is not None:
		print(node.data, end = ' ')
		preOrderTraversal(node.left)
		preOrderTraversal(node.right)

if __name__ == '__main__':
	F = Node('F', None, None)
	G = Node('G', None, None)
	B = Node('B', F, G)
	C = Node('C', None, None)
	root = A = Node('A', B, C)

	preOrderTraversal(root)
	print('\n')
	inOrderTraversal(root)
	print('\n')
	postOrderTraversal(root)
