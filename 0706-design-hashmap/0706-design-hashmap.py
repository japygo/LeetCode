class MyHashMap:

    def __init__(self):
        self.size = 997
        self.hash_table = [[] for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        index = key % self.size
        for item in self.hash_table[index]:
            if item[0] == key:
                item[1] = value
                return
        self.hash_table[index].append([key, value])

    def get(self, key: int) -> int:
        index = key % self.size
        for item in self.hash_table[index]:
            if item[0] == key:
                return item[1]
        return -1

    def remove(self, key: int) -> None:
        index = key % self.size
        for i in range(len(self.hash_table[index])):
            if self.hash_table[index][i][0] == key:
                self.hash_table[index].pop(i)
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)