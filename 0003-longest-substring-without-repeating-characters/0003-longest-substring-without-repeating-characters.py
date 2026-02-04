class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        _set = set()
        start = 0
        end = 0
        while end < len(s):
            c = s[end]
            if c in _set:
                _set.remove(s[start])
                start += 1
            else:
                _set.add(c)
                result = max(result, len(_set))
                end += 1
        return result