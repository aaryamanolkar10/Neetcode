class Solution {
    public boolean isAnagram(String s, String t) {
        Integer[] freq=new Integer[26];
        Arrays.fill(freq,0);
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=t.length()-1;i>=0;i--){
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==0){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
