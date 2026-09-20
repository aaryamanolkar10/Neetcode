class Solution {
    public int rob(int[] nums) {
        //if only one element 
        if(nums.length<2) return nums[0];

        //create array to store max loot at each index
        int[] dp=new int[nums.length];

        //first and second element of array
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //fill out all the indexes in the array
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        //return the max possible loot at the last house
        return dp[nums.length-1];
    }
}
