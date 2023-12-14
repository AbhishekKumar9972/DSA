package dsa.STACK.NEXT_GREATER_ELEMENT;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        String resultString = "";

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                numberStack.push(Integer.parseInt(String.valueOf(arr[i])));
            } else if (arr[i] == ']') {
                String temp = "";
                String pushBackString = "";

                while (!charStack.isEmpty() && !charStack.peek().equals("[")) {
                    temp = charStack.pop() + temp;
                }

                if (!charStack.isEmpty()) {
                    charStack.pop();
                }

                int number = numberStack.pop();

                for (int j = 0; j < number; j++) {
                    pushBackString = pushBackString + temp;
                }

                charStack.push(pushBackString);

            } else {
                charStack.push(String.valueOf(arr[i]));
            }
        }

        System.out.println(charStack);

        while (!charStack.isEmpty()) {
            resultString = charStack.pop() + resultString;
        }
        return resultString;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.decodeString("3[a]2[bc]");
        System.out.println(s);
    }
}


