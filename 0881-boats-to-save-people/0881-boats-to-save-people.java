class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int p1 = people[right];
            if (p1 <= limit) {
                right -= 1;
            }
            int p2 = people[left];
            if (p1 + p2 <= limit) {
                left += 1;
            }
            result += 1;
        }

        return result;
    }
}