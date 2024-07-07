class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles / numExchange > 0) {
            int div = numBottles / numExchange;
            int mod = numBottles % numExchange;
            result += div;
            numBottles = div + mod;
        }

        return result;
    }
}