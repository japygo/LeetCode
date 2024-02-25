class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] arr = new int[length + max + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        List<Integer>[] primes = new List[max + 1];
        for (int i = 0; i < max + 1; i++) {
            primes[i] = new ArrayList<>();
        }
        for (int i = 1; i < max + 1; i++) {
            int tmp = i;
            for (int j = 2; j <= tmp / j; j++) {
                if (tmp % j == 0) {
                    primes[i].add(j);
                    while (tmp % j == 0) {
                        tmp /= j;
                    }
                }
            }
            if (tmp > 1) {
                primes[i].add(tmp);
            }
        }
        
        for (int i = 0; i < length; i++) {
            for (Integer prime : primes[nums[i]]) {
                union(i, prime + length, arr);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(find(arr[i], arr));
        }
        return set.size() == 1;
    }

    private int find(int index, int[] arr) {
        if (index == arr[index]) {
            return index;
        }
        arr[index] = find(arr[index], arr);
        return arr[index];
    }

    private void union(int a, int b, int[] arr) {
        a = find(a, arr);
        b = find(b, arr);
        if (a < b) {
            arr[b] = a;
        } else if (a > b) {
            arr[a] = b;
        }
    }
}