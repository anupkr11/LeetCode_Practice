class Solution {
    public int minSteps(int n) {
        int ans = 0;
        int i = 2;
        while(i<=n) {
            if(n%i == 0 && isPrime(i)) {
                ans += i;
                n = n/i;
            }
            else i++;
        }

        return ans;
    }

    public boolean isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) return false;
        }

        return true;
    }
}