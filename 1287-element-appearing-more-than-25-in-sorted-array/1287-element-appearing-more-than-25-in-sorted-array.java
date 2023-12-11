class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        // int i = arr[0];
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int j : hm.keySet()){
            if(hm.get(j)>(int)n*0.25){
                ans = j;
            }
        }
        return ans;
    }
}


// public class Solution {
//     public int findSpecialInteger(int[] arr) {
//         if (arr.length < 2) {
//             return arr[0];
//         }
//         int result = 0;
//         int percent = (int) (arr.length * 0.25);
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int i : arr) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }

//         for (int key : map.keySet()) {
//             if (map.get(key) > percent) {
//                 result = key;
//             }
//         }

//         return result;
//     }
// }