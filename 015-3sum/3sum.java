// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//
//


 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res=new LinkedList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0 &&nums[i]!=nums[i-1])){
                int sum=-nums[i],j=i+1,k=nums.length-1;
                while(j<k){
                    if(nums[j]+nums[k]==sum){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1])j++;
                        while(j<k && nums[k]==nums[k-1])k--;
                        j++;k--;
                    }
                    else if(nums[j]+nums[k]>sum)k--;
                    else j++;
                    }
        
                    }
        }
        return res;
        }
    }
