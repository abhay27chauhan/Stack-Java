class buildNormalStack{

    public static class CustomStack{
        int[] data;
        int tos;

        public CustomStack(int cap){
            data = new int[cap];
            tos = -1;
        }

        int size(){
            return tos+1;
        }

        void push(int val){
            if(tos == data.length-1){
                System.out.println("Stack Overflow");
            }else{
                tos++;
                data[tos] = val;
            }
        }

        void display(){
            for(int i=tos; i>=0; i--){
                System.out.print(data[i] + " ");
            }
        }

        int pop(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos];
                tos--;
                return val;
            }
        }

        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos];
                return val;
            }
        }
    }

    public static void main(String[] args){
        CustomStack st = new CustomStack(5);
        for(int i=10; i<=50; i+=10){
           st.push(i); 
        }
        st.display();
        System.out.println();
        System.out.println(st.top());
        System.out.println(st.size());
        System.out.println(st.pop());
        st.display();
        System.out.println();
    }
}