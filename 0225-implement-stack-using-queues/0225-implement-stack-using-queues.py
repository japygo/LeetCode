from collections import deque

class MyStack:

    def __init__(self):
        self.queue1 = deque()
        self.queue2 = deque()

    def push(self, x: int) -> None:
        if self.queue1:
            self.queue1.append(x)
        else:
            self.queue2.append(x)

    def pop(self) -> int:
        if self.queue1:
            while len(self.queue1) > 1:
                self.queue2.append(self.queue1.popleft())
            return self.queue1.popleft()
        else:
            while len(self.queue2) > 1:
                self.queue1.append(self.queue2.popleft())
            return self.queue2.popleft()

    def top(self) -> int:
        if self.queue1:
            while len(self.queue1) > 1:
                self.queue2.append(self.queue1.popleft())
            result = self.queue1.popleft()
            self.queue2.append(result)
            return result
        else:
            while len(self.queue2) > 1:
                self.queue1.append(self.queue2.popleft())
            result = self.queue2.popleft()
            self.queue1.append(result)
            return result

    def empty(self) -> bool:
        return not self.queue1 and not self.queue2


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()