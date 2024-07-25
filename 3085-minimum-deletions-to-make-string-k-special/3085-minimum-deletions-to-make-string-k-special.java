class Solution {
    public int bs(int[] freqs, int i, int target){
        int l = -1;
        int r = freqs.length;
        l = i;
        while(l < r){
            int mid = (l + r)/2;
            if(freqs[mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    public int findOps(int[] freqs, int k){

        int ans = Integer.MAX_VALUE;
        int[] prefix = new int[freqs.length + 1];
        prefix[0] = 0;
        int sum = 0;
        for(int i = 0; i < freqs.length; i++){
            sum += freqs[i];
            prefix[i+1] = sum;
        }

        for(int i = 0; i < freqs.length; i++){         
            int curr = 0;
            int target = freqs[i] + k;
            int idx = bs(freqs, i, target);
            int cnt = freqs.length - idx;
            int right_sum = prefix[freqs.length] - prefix[idx];
            curr += (right_sum - cnt*target);
            curr += prefix[i];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
    
    public int minimumDeletions(String word, int k) {
        int[] freqs = new int[26];
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            freqs[c - 'a']++;
        }
        
        Arrays.sort(freqs);
        int ans = findOps(freqs, k);
        return ans;
    }
}