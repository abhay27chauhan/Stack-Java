// Stack to Queue Adapter -> add efficeint

import java.util.Stack;
class StackToQueueAdapter2{

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
            mainS.push(val);
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
        StackToQueueAdapter st = new  StackToQueueAdapter();
    }
}

