import java.util.Stack;
class infixConversion{

    public static int precedence(char op){
        if(op == '+'){
            return 1;
        }else if(op == '-'){
            return 1;
        }else if(op == '*'){
            return 2;
        }else{
            return 2;
        }
    }

    public static void main(String[] args){
        String exp = "a*(b-c)/d+e";

        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                ops.push(ch);
            }else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                postfix.push(ch + "");
                prefix.push(ch + "");
            }else if(ch == ')'){
                while(ops.peek() != '('){
                    char op = ops.pop();
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();

                    String postv = postv1 + postv2 + op;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();

                    String prev = op + prev1 + prev2;
                    prefix.push(prev);
                }
                ops.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(ops.size()>0 && ops.peek() != '(' && precedence(ch) >= precedence(ops.peek())){
                    char op = ops.pop();
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();

                    String postv = postv1 + postv2 + op;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();

                    String prev = op + prev1 + prev2;
                    prefix.push(prev);
                }
                ops.push(ch);
            }else{

            }
        }
        while(ops.size()>0){
            char op = ops.pop();
            String postv2 = postfix.pop();
            String postv1 = postfix.pop();

            String postv = postv1 + postv2 + op;
            postfix.push(postv);

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();

            String prev = op + prev1 + prev2;
            prefix.push(prev);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }
}