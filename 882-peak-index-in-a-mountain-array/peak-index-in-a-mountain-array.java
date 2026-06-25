class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;

            if(arr[mid] < arr[mid+1]) {
                //main ascending order wale part me hun
                //iska mtlb main left part m hu
                //or mujhe pta h answer right me hun
                //toh fatafat right part me move kro
                s = mid + 1;
            }
            else {
                //arr[mid] >= arr[mid+1]
                // iska mtlb main right part me hun
                //iska matlab me potenstial solution par khada hun
                ans = mid;
                //now i have to find the final solution 
                //mujhe pta h right part descending order wala h
                //toh bada number agar exist krta h, toh pakka left me hi milega 
                //left me move kao
                e = mid - 1;
            
            }

        }
        return ans;  
        
    }
}      
        