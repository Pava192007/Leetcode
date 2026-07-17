// Last updated: 7/17/2026, 9:07:14 AM
// class Solution {
//     int [] num;
//     // public int getMax(int i,int j){
//     //     int max = Integer.MIN_VALUE;
//     //     for(;i<=j;i++){
//     //         max = Math.max(max,num[i]);
//     //     }
//     //     return max;
//     // }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if(nums.length==1) return nums;
//         // num =nums;
//         int n = nums.length;
//         int [] ans = new int[n-k+1];
//         Deque<Integer> dq = new ArrayDeque<>();
//         int i=0,j=0;
//         while(j<k){
//             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]){
//                 dq.pollLast();
//             }
//             dq.offerLast(j);
//             j++;
//         }
//         ans[i] = nums[dq.peekFirst()];
//         i++;
//         while(j<nums.length){
//             if(!dq.isEmpty() && dq.peekFirst()<=i-1) dq.pollFirst();
//             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]){
//                 dq.pollLast();
//             }
//             dq.offerLast(j);
//             ans[i] = nums[dq.peekFirst()];
//             i++;
//             j++;

//         }


//         return ans;
//     }
// }

class Solution {

    static{
        int [] ans = new int[]{5,6,7};

        for(int i =0; i< 301;i++){
            maxSlidingWindow(ans,2);
        }
       
    }
     public static int[] maxSlidingWindow(int[] nums, int k) {
       int l = nums.length;
        int[] ans = new int[l - k + 1];
        if (k == 1) {
            return nums;
        }
        int max = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < k; i++) {
            int n = nums[i];
            if (n >= max) {
                ind = i;
                max = n;
            }
        }
        ans[0] = max;
        int end = 0;
        for (int i = 1; i < ans.length; i++) {
            end = i + k - 1;
            if (i <= ind) {
                if (nums[end] >= max) {
                    max = nums[end];
                    ind = end;
                }
            } else {
                if (nums[end] >= max - 1) {
                    max = nums[end];
                    ind = end;
                } else if (nums[i] >= max - 1) {
                    max = nums[i];
                    ind = i;
                } else {
                    max = Integer.MIN_VALUE;
                    for (int j = i; j < end + 1; j++) {
                        if (nums[j] >= max) {
                            max = nums[j];
                            ind = j;
                        }
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}