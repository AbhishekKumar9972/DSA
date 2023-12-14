package dsa.STACK.PARANTHESIS;

import java.util.Stack;

public class InsertMakeValidParanthesis {

    public static void main(String[] args) {
        String s = "(()))(()))()())))";
        InsertMakeValidParanthesis insertMakeValidParanthesis = new InsertMakeValidParanthesis();
        System.out.println(insertMakeValidParanthesis.minInsertions(s));
    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()){
            if(ch==')' && !stack.isEmpty() && stack.peek()==')'){
                stack.pop();
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(')');
                    stack.push(')');

                }
            }
            else{
                stack.push(ch);
            }
        }

        System.out.println(stack);

        if(stack.isEmpty()){
            return 0;
        }

        int result = 0;

        while(!stack.isEmpty()){
            Character ele = stack.pop();

            if(ele == '('){
                result = result + 2;
            }

            else if(ele == ')'){
                if(stack.isEmpty()){
                    result = result + 2;
                }
                else if(!stack.isEmpty()){
                    stack.pop();
                    result = result + 1;
                }

            }
        }
        return result;
    }
}
