public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0)
            return result;

        int wordLength = words[0].length(); 
        int totalWords = words.length; 
        int substringLength = wordLength * totalWords; 

        if (s.length() < substringLength)
            return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentWordCount = new HashMap<>(); 
            int wordsFound = 0; 
            int left = i; 
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                if (wordCount.containsKey(currentWord)) {
                    currentWordCount.put(currentWord, currentWordCount.getOrDefault(currentWord, 0) + 1);
                    wordsFound++;
                    while (currentWordCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentWordCount.put(leftWord, currentWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }
                    if (wordsFound == totalWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        currentWordCount.put(leftWord, currentWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }
                }
                else {
                    currentWordCount.clear();
                    wordsFound = 0;
                    left = j + wordLength;
                }
            }
        }

        return result;
    }
}