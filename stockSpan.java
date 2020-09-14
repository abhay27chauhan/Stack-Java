// next greater element on the left;
import java.util.Stack;
class stockSpan{

    public static int[] solve(int[] arr){
        int[] ngl = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        ngl[0] = 1;

        for(int i=0; i<ngl.length; i++){
            while(st.size()>0 && arr[i]>= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ngl[i] = i+1;
            }else{
                ngl[i] = i-st.peek();
            }
            st.push(i);
        }
        return ngl;
    }

    public static void main(String[] args){
        int[] a = {5,7,9,6,8,2,3,4,12,10,4,6,7,11,5};
        int[] span = solve(a);
        
        for(int val: span){
            System.out.print(val + " ");
        }System.out.println();
    }
}