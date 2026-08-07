class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,maxFreq=0,maxLength=0;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq=Math.max(maxFreq,map.get(c));

            while((right-left+1)-maxFreq>k){
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
