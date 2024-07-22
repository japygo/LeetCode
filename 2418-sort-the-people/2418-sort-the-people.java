class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            list.add(new int[]{heights[i], i});
        }
        list.sort((o1, o2) -> o2[0] - o1[0]);

        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = names[list.get(i)[1]];
        }

        return result;
    }
}