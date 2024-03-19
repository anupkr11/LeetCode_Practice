class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 1) return tasks.length;
        
        int[] freq = count(tasks);
        
        Arrays.sort(freq);

        int max = freq[25]-1;
		int spaces = max * n;
		
		for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) break;
			spaces -= Math.min(max, freq[i]);
		}


		spaces = Math.max(0, spaces);
        
		return tasks.length + spaces;
    }
    
    private int[] count(char[] tasks) {
        int[] freq = new int[26];
        
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        
        return freq;
    }
    
}