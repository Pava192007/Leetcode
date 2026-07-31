// Last updated: 7/31/2026, 8:58:09 AM
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        int n=nums.length;

        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            //early check
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;

            if((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;

            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int l=j+1;
                int r=n-1;

                //early check for second pointer
                if((long)nums[i]+nums[j]+nums[j+1]+nums[j+2] > target) break;

                if((long)nums[i]+nums[j]+nums[n-1]+nums[n-2] < target) continue;

                while(l<r){
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;

                        l++;
                        r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}