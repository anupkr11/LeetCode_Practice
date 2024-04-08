class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int cc = 0, sc = 0;

        for (int n : students) {
            if (n == 0) cc++;
            else sc++;
        }
        for (int s : sandwiches) {
            if (s == 0 && cc == 0) return sc;
            if (s == 1 && sc == 0) return cc;
            if (s == 0) cc--; 
            else sc--;      
        }
        return 0;
    }
}