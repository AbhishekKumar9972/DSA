package dsa.STACK.NEXT_GREATER_ELEMENT;

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class NSR
{
    public static int[] nsr(int[] arr)
    {
        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()){
                output[i] = -1;
            }
            else if(stack.peek() <+ arr[i]){
                output[i] = stack.peek();
            }
            else{
                while(!stack.isEmpty() && stack.peek()>arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    output[i] = -1;
                }else{
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(Arrays.asList(output));
        return output;
    }

    public static void main(String[] args) {
        NSR nsr = new NSR();
        int[] ints = nsr.nsr(new int[]{1,3,2,4});
        for(long i:ints){
            System.out.println(i);
        }
    }
}