class Solution {
    public String customSortString(String order, String s) {
        return Arrays.stream(s.split(""))
                .sorted(Comparator.comparingInt(order::indexOf))
                .collect(Collectors.joining());
    }
}