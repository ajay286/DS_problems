import sys

INT_MAX = sys.maxsize

def findShortestPath(i_graph, m, n):
	for i in range(m):
		for j in range(n):
			if i_graph[i][j] == 0:
				i_graph[i][j] = INT_MAX

	for k in range(m):
		for i in range(m):
			for j in range(m):
				i_graph[i][j] = min(i_graph[i][j],i_graph[i][k]+i_graph[k][j])

	return i_graph


def main():
	graph =	[[0,0,2,0,0],
	 [0,0,0,4,2],
	 [2,0,0,3,0],
	 [0,4,3,0,4],
	 [0,2,0,4,0]
	]

	m = n = len(graph)
	
	graph = findShortestPath(graph, m, n)

	for i in range(m):
		print(*graph[i], end='\n')

if __name__ == '__main__':
	main()
