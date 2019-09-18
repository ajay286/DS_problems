class TrieNode:
	def __init__(self):
		self.children = [None] * 26
		self.isLastWord = False	

class Trie:

	def __init__(self):
		self.root = self.getNode()

	def getNode(self):
		return TrieNode()

	def _chatIndex(self,ch):
		return ord(ch) - ord('a')

	def insert(self, key):
		pCrawl = self.root
		len_key = len(key)
		for i in range(len_key):
			depth = self._chatIndex(key[i])
			if not pCrawl.children[depth]:
				pCrawl.children[depth] = self.getNode()

			pCrawl = pCrawl.children[depth]

		pCrawl.isLastWord = True

	def search(self,key):
		pCrawl = self.root
		len_key = len(key)

		for i in range(len_key):
			depth = self._chatIndex(key[i])
			if not pCrawl.children[depth]:
				return 1

			pCrawl = pCrawl.children[depth]

		return pCrawl != None and pCrawl.isLastWord


def main():
	root = Trie()
	keys_to_insert = ["the","hello","theme","by","their"]
	valid_response = ["Key not found","Key found"]

	for key in keys_to_insert:
		root.insert(key)

	print("{}.....{}".format("the",valid_response[ root.search("the")]))
	print("{}.....{}".format("hello",valid_response[root.search("hello")]))
	print("{}.....{}".format("hell",valid_response[root.search("hell")]))


if __name__ == '__main__':
 	main() 
