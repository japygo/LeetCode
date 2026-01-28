class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        node = self.map[key]
        node_prev = node.prev
        node_next = node.next
        node_prev.next = node_next
        node_next.prev = node_prev
        tail_prev = self.tail.prev
        node.prev = tail_prev
        node.next = self.tail
        tail_prev.next = node
        self.tail.prev = node
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node_prev = node.prev
            node_next = node.next
            node_prev.next = node_next
            node_next.prev = node_prev
        new_node = Node(key, value)
        self.map[key] = new_node
        prev = self.tail.prev
        new_node.prev = prev
        new_node.next = self.tail
        prev.next = new_node
        self.tail.prev = new_node
        if len(self.map) > self.capacity:
            del_node = self.head.next
            next_node = del_node.next
            self.head.next = next_node
            next_node.prev = self.head
            del self.map[del_node.key]

class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)