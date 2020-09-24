import java.util.Stack;
class smallestNumberFollowingPattern{

    public static void main(String[] args){
        String str = "ddiddidd";

        Stack<Integer> st = new Stack<>();
        int num =1;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == 'd'){
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;
                
                while(st.size()>0){
                    System.out.print(st.pop() + " ");
                }
            }
        }
        st.push(num);
        while(st.size()>0){
            System.out.print(st.pop() + " ");
        }System.out.println();
    }
}