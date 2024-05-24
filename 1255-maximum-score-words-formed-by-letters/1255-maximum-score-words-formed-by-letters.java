class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        final WordFreq[] freqs = new WordFreq[words.length];
        for (int i = 0; i < words.length; ++i) {
            freqs[i] = new WordFreq(words[i]);
        }
        final int[] letterFreqs = new int[26];
        for (char ch : letters) {
            letterFreqs[ch - 'a']++;
        }

        final int[] max = new int[1];
        traversePowersetForMaxScore(new WordFreq(""), freqs, 0, letterFreqs, score, max);
        return max[0];
    }

    private void traversePowersetForMaxScore(WordFreq wf, WordFreq[] freqs, int i, int[] lfreqs, int[] scoring, int[] max) {
        if (i >= freqs.length) {
            return;
        }
        final int ip1 = i + 1;
        // Powerset Fork A: DO NOT add element i and continue at i + 1:
        traversePowersetForMaxScore(wf, freqs, ip1, lfreqs, scoring, max);
        // Powerset Fork B: DO add element i, provisionally continue if valid.
        final WordFreq next = wf.adding(freqs[i]);
        final int score = next.score(lfreqs, scoring);
        // Do not continue Powerset Fork B if score < 0.
        if (score >= 0) {
            // Have we seen our max score so far?  If so, update it!
            if (score > max[0]) {
                max[0] = score;
            }
            // Continue Powerset Fork B at i + 1:
            traversePowersetForMaxScore(next, freqs, ip1, lfreqs, scoring, max);
        }
    }

    static class WordFreq {

        final int[] freq;

        public WordFreq(String word) {
            this(new int[26]);
            for (int i = 0; i < word.length(); ++i) {
                this.freq[word.charAt(i) - 'a']++;
            }
        }

        private WordFreq(int[] freq) {
            this.freq = freq;
        }

        public WordFreq adding(final WordFreq wf) {
            final int[] freq = Arrays.copyOf(this.freq, 26);
            for (int i = 0; i < 26; ++i) {
                freq[i] += wf.freq[i];
            }
            return new WordFreq(freq);
        }

        public int score(final int[] letterFreqs, final int[] scoring) {
            int score = 0;
            for (int i = 0; i < 26; ++i) {
                if (this.freq[i] > letterFreqs[i]) {
                    return -1;
                }
                score += (this.freq[i] * scoring[i]);
            }
            return score;
        }

    }

}