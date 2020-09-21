import java.util.Stack;
import java.util.Arrays;
class mergeOverlappingInterval{

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair o){
            if(this.st != o.st){
                return this.st-o.st;
            }else{
                return this.et-o.et;
            }
        }
    }

    public static void mergeOverlappingInterval(int[][] arr){

        Pair[] pairs = new Pair[arr.length];

        for(int i=0; i<arr.length; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }  

        Arrays.sort(pairs);
        Stack<Pair> vs = new Stack<>();
        vs.push(pairs[0]);

        for(int i=1; i<pairs.length; i++){
            Pair top = vs.peek();

            if(pairs[i].st > top.et){
                vs.push(pairs[i]);
            }else{
                top.et = Math.max(pairs[i].et, top.et);
            }
        }

        Stack<Pair> st = new Stack<>();

        while(vs.size()>0){
            st.push(vs.pop());
        }

        while(st.size()>0){
            Pair p = st.pop();
            System.out.println(p.st + " " + p.et);
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,8},{22,28},{25,27},{14,19},{27,30},{5,12}};

        mergeOverlappingInterval(arr);
    }
}