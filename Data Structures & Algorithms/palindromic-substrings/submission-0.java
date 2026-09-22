class Solution {
    public int countSubstrings(String s) {
        int count=0;

        for(int i=0;i<s.length();i++){
            //count palindromes for odd length
            count+=countPalindrome(s,i,i);
            //count palindromes for even length
            count+=countPalindrome(s,i,i+1);
        }
        return count;
    }

    private int countPalindrome(String s,int left,int right){
        int count=0;

        while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}
