class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
       Map<Integer,Integer> map = new HashMap<>();
       int j = 0;
       int count = 1;
       int[] arr1 = new int[arr.length];
       for (int i = 0;i<arr.length;i++) {
        arr1[i] = arr[i];
       }
       Arrays.sort(arr1);
       for (int item : arr1) {
            if (!map.containsKey(item)) {
                map.put(item,count++);
            }
       }
       for (int item : arr) {
        ans[j++] = map.get(item);
       }
       return ans;
    }
}