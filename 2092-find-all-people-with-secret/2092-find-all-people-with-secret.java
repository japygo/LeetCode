class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            int first = meeting[0];
            int second = meeting[1];
            int time = meeting[2];

            List<int[]> list = map.getOrDefault(time, new ArrayList<>());
            list.add(new int[]{first, second});
            map.put(time, list);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        union(0, firstPerson, arr);

        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : collect) {
            Set<Integer> set = new HashSet<>();
            List<int[]> meets = map.get(key);
            for (int[] meet : meets) {
                int first = meet[0];
                int second = meet[1];
                union(first, second, arr);
                set.add(first);
                set.add(second);
            }
            for (Integer index : set) {
                if (find(index, arr) != 0) {
                    arr[index] = index;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                result.add(i);
            }
        }
        return result;
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