class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return result;
    }

    private void dfs(String s,int start,List<String> current){
        if(s.length()==start){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start,i+1));
                dfs(s,i+1,current);
                current.remove(current.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
