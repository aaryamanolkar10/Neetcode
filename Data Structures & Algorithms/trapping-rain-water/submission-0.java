class Solution {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        int left=0,right=n-1;
        int lmax=height[left],rmax=height[right];
        while(left<right){
            if(height[left]<height[right]){
                lmax=Math.max(lmax,height[left]);
                ans+=lmax-height[left];
                left++;
            }
            else{
                rmax=Math.max(rmax,height[right]);
                ans+=rmax-height[right];
                right--;
            }
        }
        return ans;
    }
}
