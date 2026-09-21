class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2)return nums[0];

        int[] skipLast=new int[n-1];
        int[] skipFirst=new int[n-1];

        for(int i=0;i<n-1;i++){
            skipLast[i]=nums[i];
            skipFirst[i]=nums[i+1];
        }

        int skipLastLoot=robHouse(skipLast);
        int skipFirstLoot=robHouse(skipFirst);

        return Math.max(skipLastLoot,skipFirstLoot);
        
    }
    public int robHouse(int[] nums) {
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
