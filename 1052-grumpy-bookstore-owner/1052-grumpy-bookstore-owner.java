class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int minutes) {
        int res = 0, curr = 0;
        
        // initial satisfied customers
        for (int i = 0; i < cust.length; ++i) {
            if (grumpy[i] == 0) {
                res += cust[i];
            }
        }
        
        // initial additional customers if we use the grumpy technique
        for (int i = 0; i < minutes; ++i) {
            if (grumpy[i] == 1) {
                curr += cust[i];
            }
        }
        
        int addi = curr; 

        // Sliding window to maximize additional customers we can gain
        for (int i = minutes; i < cust.length; ++i) {
            if (grumpy[i -minutes] == 1) {
                curr -= cust[i - minutes]; // Remove if grumpy at 'i - minutes'
            }
            if (grumpy[i] == 1) {
                curr += cust[i]; // Add if grumoy at 'i'
            }

            addi = Math.max(addi, curr); // Update addi 
        }
        
        return res + addi; // total satisfied customers
    }
}