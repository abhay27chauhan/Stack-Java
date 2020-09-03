import java.util.Stack;
class balancedBrackets{

    public static boolean handleClosing(Stack<Character> st, char corresoCh){

        if(st.size() == 0){
            return false;
        }else if(st.peek() != corresoCh){
            return false;
        }else{
            st.pop();
            return true;
        }
    }

    public static boolean balancedBrackets(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i< str.length(); i++){
            char ch = str.charAt(i);

            if(ch=='[' || ch=='{' || ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                boolean val = handleClosing(st, '(');
                if(val == false){
                    return false;
                }
            }else if(ch == '}'){
                boolean val = handleClosing(st, '{');
                if(val == false){
                    return false;
                }
            }else if(ch == ']'){
                boolean val = handleClosing(st, '[');
                if(val == false){
                    return false;
                }
            }else{
                
            }
        }
        if(st.size() == 0 ){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String str = "[(a+b) + {(c+d)*(e/f)}]";
        boolean isBal = balancedBrackets(str);
        System.out.println(isBal);
    } 
}