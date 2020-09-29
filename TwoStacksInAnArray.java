class TwoStacksInAnArray{

    public static class TwoStacks{
        int[] data;
        int tos1;
        int tos2;

        public TwoStacks(int cap){
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1(){
            return tos1+1;
        }

        int size2(){
            return data.length-tos2;
        }

        void push1(int val){
            if(tos2 == tos1+1){
                System.out.println("Stack Overflow");
            }else{
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val){
            if(tos2 == tos1+1){
                System.out.println("Stack Overflow");
            }else{
                tos2--;
                data[tos2] =val;
            }
        }

        int pop1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos1];
                return val;
            }
        }

        int top2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos2];
                return val;
            }
        }
    }

    public static void main(String[] args){
        TwoStacks st = new TwoStacks(5);

        st.push1(10);
        st.push1(20);
        st.push2(30);
        st.push1(40);
        st.push2(50);
       
        System.out.println(st.top1());
        System.out.println(st.top2());

        System.out.println();

        System.out.println(st.size1());
        System.out.println(st.size2());

        System.out.println();

        System.out.println(st.pop1());
        System.out.println(st.pop2());

    }
}