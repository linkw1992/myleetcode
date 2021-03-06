// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
// Examples: 
// [2,3,4] , the median is 3
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
//
// Design a data structure that supports the following two operations:
//
//
// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
//
//
//
// For example:
//
// addNum(1)
// addNum(2)
// findMedian() -> 1.5
// addNum(3) 
// findMedian() -> 2
//
//
// Credits:Special thanks to @Louis1992 for adding this problem and creating all test cases.


class MedianFinder {
        Queue<Long>  small=new  PriorityQueue<Long>();
        Queue<Long>  large=new  PriorityQueue<Long>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if(large.size()<small.size())large.add(-small.poll());
    }
    
    public double findMedian() {
        
        return (large.size()>small.size())?large.peek():(large.peek()-small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
