class Solution {
    public int mySqrt(int x) {
        int s = 1;
        int e = x;
        int ans = -1;

        if(x == 0){
            return 0;
        }
        while(s <= e) {
            int mid = s + (e-s)/2;

            if(mid  == x/mid) {
                return mid;
        }
        else if(mid > x/mid) {
            //move to left 
            e = mid - 1;
        }
        else {
            //mid * mid < x
            //potential solution par khade hai
            //ans store karo and move to right, final ans k liye
            ans = mid;
            s = mid + 1; 
        }
        
    }
    return ans;
  }

}