from collections import deque
class Node:
	def __init__(self,left,right,data):
		self.left = left
		self.right = right
		self.data = data

def populateParentChildMap(root, parent, partentChildMap):
	if root is not None:
		partentChildMap[root] = parent
		partentChildMap = populateParentChildMap(root.left, root, partentChildMap)
		partentChildMap = populateParentChildMap(root.right, root, partentChildMap)

	return partentChildMap

def getNodesWithKDistance(root, startNode, K):
	currentLevel = 0
	partentChildMap = {}
	parentChildMap = populateParentChildMap(root, None, partentChildMap)
	visitedNodes = [startNode]
	queue = deque([])
	queue.append(startNode)

	while len(queue)>0:
		if currentLevel == K:
			return (queue)

		layerSize = len(queue)
		for i in range(layerSize):
			tempNode = queue.popleft()

			if tempNode.left is not None and tempNode.left  not in visitedNodes:
				queue.append(tempNode.left)
				visitedNodes.append(tempNode.left)

			if tempNode.right is not None and tempNode.right  not in visitedNodes:
				queue.append(tempNode.right)
				visitedNodes.append(tempNode.right)

			parent = partentChildMap[tempNode]
			if parent is not None and parent  not in visitedNodes:
				queue.append(parent)
				visitedNodes.append(parent)


		currentLevel +=1


def main():
	node10 = Node(None, None, 10)
	node14 = Node(None, None, 14)
	node12 = Node(node10, node14, 12)
	node4  = Node(None, None, 4)
	node8  = Node(node4, node12, 8)
	node22 = Node(None, None, 22)
	root   = Node(node8, node22, 20)
	output = getNodesWithKDistance(root, node8,1)

	for i in output:
		print(i.data, end = ' ')

if __name__ == '__main__':
	main()
