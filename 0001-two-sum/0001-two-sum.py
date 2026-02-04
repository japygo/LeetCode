class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            map[nums[i]] = i
        for i in range(len(nums)):
            index = target - nums[i]
            if index in map and map[index] != i:
                return [i, map[index]]
        return []