// class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int p1 = m - 1;
//         int p2 = n - 1;
//         int pMerge = m + n - 1;
        
//         while (p2 >= 0) {
//             if (p1 >= 0 && nums1[p1] > nums2[p2]) {
//                 nums1[pMerge--] = nums1[p1--];
//             } else {
//                 nums1[pMerge--] = nums2[p2--];
//             }
//         }
//     }
// }
class Solution {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
       int j = n-1;
       int k = m+n-1;
       while(j>=0 ){
           if(i>=0 && nums1[i]>nums2[j]){
               nums1[k] = nums1[i];
               i--;
               k--;
           }
           else{
               nums1[k] = nums2[j];
               k--;
               j--;
           }
       }
    }
}


// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] arr3 = new int[n + m];
//         int left = 0;
//         int right = 0;
//         int index = 0;

//         // Insert the elements from the 2 arrays
//         // into the 3rd array using left and right
//         // pointers:

//         while (left < n && right < m) {
//             if (nums1[left] <= nums2[right]) {
//                 arr3[index] = nums1[left];
//                 left++;
//                 index++;
//             } else {
//                 arr3[index] = nums2[right];
//                 right++;
//                 index++;
//             }
//         }

//         // If right pointer reaches the end:
//         while (left < n) {
//             arr3[index++] = nums1[left++];
//         }

//         // If left pointer reaches the end:
//         while (right < m) {
//             arr3[index++] = nums2[right++];
//         }

//         // Fill back the elements from arr3[]
//         // to arr1[] and arr2[]:
//         for (int i = 0; i < n + m; i++) {
//             if (i < n) {
//                 nums1[i] = arr3[i];
//             } else {
//                 nums2[i - n] = arr3[i];
//             }
//         }
//     }
// }
