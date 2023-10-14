// class Solution {
//     public int heightChecker(int[] heights) {
//         int count =0;
//         for(int i=0;i<heights.length;i++){
//             if(i<= heights.length && heights[i]==heights[i]-1 || heights[i]==heights[i+1]){
//                 continue;
//             }
//             else{
//                 count++;
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;

        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }

        return count;
    }
}
