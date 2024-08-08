class Solution {
    public int longestStrChain(String[] words) {
        words = Arrays.stream(words)
            .sorted(Comparator.comparingInt(String::length))
            .toArray(String[]::new);
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int k = 1;
            for (Map.Entry<String, Integer> tail : map.entrySet()) {
                if (isPredecessor(word, tail.getKey())) {
                    k = Math.max(k, tail.getValue() + 1);
                }
            }
            map.put(word, k);
        }
        return map.values().stream().mapToInt(i -> i).max().orElse(0);
    }
    private boolean isPredecessor(String str, String substr) {
        if (str.length() != substr.length() + 1) {
            return false;
        }
        String regex = substr.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining(".?", ".?", ".?"));
        return str.matches(regex);
    }
}