package dsa.STACK.STOCK_SPAN;

import javafx.util.Pair;

import java.util.Stack;

public class StockSpanNSL {

    public int[] stockSpan(int [] arr){
        int [] res = new int[arr.length];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        for(int i =0; i<arr.length-1; i++){
            if(stack.isEmpty()){
                res[i] = -1;
            }
            else if(stack.peek().getKey() <= arr[i]){
                res[i] = stack.peek().getValue();
            }
            else{
                while (!stack.isEmpty() && stack.peek().getKey()>arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }else {
                    res[i] = stack.peek().getValue();
                }
            }
            stack.push(new Pair<>(arr[i],i));
        }
        return res;
    }

    public static void main(String[] args) {
        StockSpanNSL stockSpan = new StockSpanNSL();
        int[] ints = stockSpan.stockSpan(new int[]{100, 80,60,70,60,75,85});
        int[] res = new int[ints.length];
        for(int i=0; i<ints.length; i++){
            res[i] = i - ints[i];
        }

        for(int r : res){
            System.out.println(r);
        }
    }
}
