class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{i, nums[i]});
        }

        list.sort(((o1, o2) -> {
            int c1 = change(o1[1], mapping);
            int c2 = change(o2[1], mapping);
            if (c1 == c2) {
                return o1[0] - o2[0];
            }
            return c1 - c2;
        }));

        return list.stream().mapToInt(n -> n[1]).toArray();
    }
    
    private int change(int num, int[] mapping) {
        char[] c = String.valueOf(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = Character.forDigit(mapping[Character.getNumericValue(c[i])], 10);
        }
        return Integer.parseInt(new String(c));
    }
}