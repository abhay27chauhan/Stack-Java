import java.util.Stack;
class MinStack1{

    public static class MinStack{
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack(){
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size(){
            return allData.size();
        }

        int pop(){
            if(size() == 0){
                System.out.println("stack underflow");
                return -1;
            }else{
                int val = allData.pop();

                if(val == minData.peek()){
                    minData.pop();
                }
                return val;
            }
        }

        void push(int val){
            allData.push(val);

            if(minData.size() == 0 || val<minData.peek()){
                minData.push(val);
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return allData.peek();
            }
        }

        int min(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return minData.peek();
            }
        }
    }
    public static void main(String[] args){
        MinStack ms = new MinStack();
        for(int i=10; i<=50; i+=10){
           ms.push(i); 
        }
        System.out.println(ms.min());
        System.out.println(ms.top());
        System.out.println(ms.size());
        System.out.println(ms.pop());
    }
}