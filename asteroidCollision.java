/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
*/

class Solution {
    public int[] asteroidCollision(int[] arr) {
       Stack<Integer> st = new Stack<>();
        
        int j=0;
        
        while(j<arr.length){
            if(st.isEmpty() || arr[j]>0 || st.peek()<0){
                st.push(arr[j]);
                j++;
            }else if(-arr[j]<st.peek()){
                j++;
            }else if(-arr[j]>=st.peek()){
                if(-arr[j]>st.peek()){
                    st.pop();
                }else{
                    st.pop();
                    j++;
                }
            }
        }
        
        int[] ans = new int[st.size()];
        
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}

/*
- - 
+ +
- +
+ - -> ONLY THIS ONE CORRECT
*/
