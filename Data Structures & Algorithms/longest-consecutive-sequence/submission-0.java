class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen=0;
        Map<Integer,Boolean> map=new HashMap<>();
        for(int num:nums){
            map.put(num,Boolean.FALSE);
        }
        for(int num:nums){
            int current=1;
            int next=num+1;
            while(map.containsKey(next) && map.get(next)==false){
                current++;
                map.put(num,Boolean.TRUE);
                next++;

            }
            int prev=num-1;
            while(map.containsKey(prev) && !map.get(prev)){
                current++;
                map.put(prev,Boolean.TRUE);
                prev--;
            }
            longestLen=Math.max(current,longestLen);
        }
        return longestLen;
    }
}
