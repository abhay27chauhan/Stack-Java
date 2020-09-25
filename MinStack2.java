import java.util.Stack;
class MinStack2{

    public static class MinStack{
        Stack<Integer> allData;
        int min;

        public MinStack(){
            allData = new Stack<>();
        }

        int size(){
            return allData.size();
        }

        void push(int val){
            if(size() == 0){
                allData.push(val);
                min = val;
            }else if(val >= min){
                allData.push(val);
            }else{
                allData.push(2*val - min);
                min = val;
            }
        }

        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else if(allData.peek() >= min){
                return allData.pop();
            }else{
                int ov = min;
                min = 2*min-allData.pop();
                return ov;
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
                return min;
            }
        }
    }

    public static void main(String[] args){
        MinStack ms = new MinStack();
    }
}