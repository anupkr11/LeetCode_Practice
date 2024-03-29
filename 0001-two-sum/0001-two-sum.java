class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            int a = nums[i];
            int req = target-a;
            if(hm.containsKey(req)){
                arr[0] = hm.get(req);
                arr[1] = i;
                return arr;
            }
            hm.put(a,i);
        }
        return arr;
    }
}


// int[] arr = new int[2];
//         arr[0] = arr[1] = -1;
//         Map<Integer,Integer> hm = new HashMap<>();
//         for(int i =0; i<nums.length;i++){
//             int a = nums[i];
//             int req = target-a;
//             if(hm.containsKey(req)){
//                 arr[0] = hm.get(req);
//                 arr[1] = i;
//                 return arr;
//             }
//             hm.put(a,i);
//         }
//         return arr;