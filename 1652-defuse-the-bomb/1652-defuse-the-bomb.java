class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(k == 0) {
            for(int i = 0; i<n; i++) ans[i] = 0;
            return ans;
        }
        int[] c = new int[n*2];
        for(int i = 0; i<n; i++) {
            c[i] = c[i+n] = code[i];
        }
        int curr = 0;
        if(k > 0){
            for(int i = 1; i<=k; i++) curr += c[i];
            int j = 0;
            while(j < n){
                ans[j] = curr;
                curr = curr + c[j+k+1] - c[j+1]; j++;
            }
        }
        else{
            for(int i = n*2-2; i>=n*2+k-1; i--) curr += c[i];
            int j = n-1;
            while(j >= 0){
                ans[j] = curr;
                curr = curr + c[j+n+k-1] - c[j+n-1]; j--;
            }
        }
        return ans;
    }
}