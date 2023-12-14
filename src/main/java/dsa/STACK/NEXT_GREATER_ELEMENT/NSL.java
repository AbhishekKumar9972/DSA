package dsa.STACK.NEXT_GREATER_ELEMENT;

import java.util.Stack;

class NSL
{
    public static int[] nsl(int[] arr)
    {
        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <arr.length; i++) {
            if(stack.isEmpty()){
                output[i] = -1;
            }
            else if(stack.peek() <= arr[i]){
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
        return output;
    }

    public static void main(String[] args) {
        NSL nsl = new NSL();
        int[] ints = nsl.nsl(new int[]{1,3,2,4});
        for(long i:ints){
            System.out.println(i);
        }
    }
}