class Solution {
    public double averageWaitingTime(int[][] customers) {
        double result = 0;
        int current = 0;

        for (int[] customer: customers) {
            int arrival = customer[0];
            int time = customer[1];

            if (current < arrival) {
                current = arrival;
            }

            result += current + time - arrival;
            current += time;
        }

        return result / customers.length;
    }
}