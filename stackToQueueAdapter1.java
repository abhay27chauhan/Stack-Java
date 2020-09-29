// Stack to Queue Adapter -> remove efficeint
import java.util.Stack;
class stackToQueueAdapter1{

    public static class StackToQueueAdapter{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter(){
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size(){
            return mainS.size();
        }

        void add(int val){
            while(mainS.size() > 0){
                helperS.push(mainS.pop());
            }
            mainS.push(val);

            while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }
        }

        int remove(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                while(mainS.size()>1){
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();

                while(helperS.size() > 0){
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }

        int peek(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                while(mainS.size()>1){
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();
                helperS.push(val);

                while(helperS.size() > 0){
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }


    }

    public static void main(String[] args){
        StackToQueueAdapter q = new StackToQueueAdapter();
    }
}