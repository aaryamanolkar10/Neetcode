class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minspeed=1;
        int maxspeed=0;
        for(int pile:piles){
            maxspeed=Math.max(pile,maxspeed);
        }
        while(minspeed<maxspeed){
            int  midspeed=minspeed+(maxspeed-minspeed)/2;
            if(canEatInTime(piles,h,midspeed)){
                maxspeed=midspeed;
            }
            else{
                minspeed=midspeed+1;
            }
        }
        return minspeed;
    }
    private boolean canEatInTime(int[] piles,int h,int speed){
        int hours=0;
        for(int pile:piles){
            hours+=(int)Math.ceil((double)pile/speed);
        }
        return hours<=h;
    }
}
