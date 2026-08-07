class Solution {
    public String minWindow(String s, String t) {
        //initialize variable and data types
        int[] arr=new int[128];
        char[] s_arr=s.toCharArray();
        char[] t_arr=t.toCharArray();

        //increment characters of t 
        for(int cur:t_arr){
            arr[cur]++;
        }
        //define pointers
        int L=0,R=0;

        //define minLength
        int minLen=Integer.MAX_VALUE;
        //define ans
        String ans="";
        int  counter=0;

        //find min window
        while(R<s.length()){
            int curChar=s.charAt(R);
            if(--arr[curChar]>=0){
                counter++;
            }
            while(counter==t_arr.length){
                int curWindow=R-L+1;
                if(curWindow<minLen){
                    minLen=curWindow;
                    ans=s.substring(L,R+1);
                }
                char leftChar=s_arr[L];
                if(++arr[leftChar]>0){
                    counter--;
                }
                L++;
            }
            R++;
        }
        return ans;
    }
}
