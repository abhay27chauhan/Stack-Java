import java.util.Stack;
class postfixEvalAndConversion{

    public static int operation(int v1, int v2, char op){
        if(op == '+'){
            return v1+v2;
        }else if(op == '-'){
            return v1-v2;
        }else if(op == '*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }

    public static void main(String[] args){
        String str = "264*8/+3-";

        Stack<String> pres = new Stack<>(); //prefix stack
        Stack<String> ins = new Stack<>(); // infix stack
        Stack<Integer> vs = new Stack<>(); // value stack

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v2 = vs.pop();
                int v1 = vs.pop();

                int opv = operation(v1, v2, ch);
                vs.push(opv);

                String prev2 = pres.pop();
                String prev1 = pres.pop();

                String prev = ch + prev1 + prev2;
                pres.push(prev);

                String inv2 = ins.pop();
                String inv1 = ins.pop();

                String inv = "(" + inv1 + ch + inv2 + ")";
                ins.push(inv);
                
            }else{
                vs.push(ch-'0');
                pres.push(ch + "");
                ins.push(ch + "");
            }
        }
        System.out.println(ins.pop());
        System.out.println(pres.pop());
        System.out.println(vs.pop());
    }
}