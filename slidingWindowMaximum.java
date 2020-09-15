import java.util.Stack;
class slidingWindowMaximum{
    
    public static void main(String[] args){
        int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12};

        int [] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(arr.length-1);
        nge[arr.length-1] = arr.length;

        for(int i=arr.length-2; i>=0; i--){
            while(st.size()>0 && arr[i]>= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                nge[i] = arr.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }

        int j=0, k=4; 
        for(int i=0; i<=arr.length-k; i++){
            if(j<i){
                j=i;
            }

            while(nge[j]< i+k){
                j = nge[j];
            }

            System.out.print(arr[j] + " ");
        }
        System.out.println();

    }
}