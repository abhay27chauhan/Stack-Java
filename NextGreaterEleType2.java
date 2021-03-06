/*
Leetcode :
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=(2*nums.length)-1; i>=0; i--){
            while(!st.empty() && nums[i%nums.length] >= nums[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nge[i%nums.length] = -1;
            }else{
                nge[i%nums.length] = nums[st.peek()];
            }
            
            st.push(i%nums.length);
        }
        
        return nge;
    }
}
