// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//


class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, max=0;
        while(i<j){
            if(height[i]<height[j]){
                max=(height[i]*(j-i)>max)? height[i]*(j-i):max;
                i++;
            }
            else{
                max=(height[j]*(j-i)>max)? height[j]*(j-i):max;
                j--;                
            }
        }return max;
    }
}
