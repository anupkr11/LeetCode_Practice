class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();

        for(int currDay = 0;currDay<temperatures.length;currDay++){

            while(!st.isEmpty() &&
             temperatures[currDay]>temperatures[st.peek()]){
                 int prevDay = st.pop();
                 ans[prevDay] = currDay-prevDay;
             }
             st.add(currDay);
        }
        return ans;
    }
}