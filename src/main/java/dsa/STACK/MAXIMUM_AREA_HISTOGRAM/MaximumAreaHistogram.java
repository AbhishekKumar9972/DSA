package dsa.STACK.MAXIMUM_AREA_HISTOGRAM;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaximumAreaHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] nsl = nsl(heights);
        int[] nsr = nsr(heights);
        int[] width = new int[heights.length];
        int[] area = new int[heights.length];
        for (int i = 0; i < nsl.length; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
        }


        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            area[i] = heights[i] * width[i];
            if (area[i] > max) {
                max = area[i];
            }
        }
        System.out.println(Arrays.toString(nsl));
        System.out.println(Arrays.toString(nsr));
        System.out.println(Arrays.toString(width));
        System.out.println(Arrays.toString(area));
        return max;
    }


    public int[] nsr(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = arr.length;
            } else if (stack.peek().getKey() < arr[i]) {
                res[i] = stack.peek().getValue();
            } else {
                while (!stack.isEmpty() && stack.peek().getKey() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = arr.length;
                } else {
                    res[i] = stack.peek().getValue();
                }
            }
            stack.push(new Pair<>(arr[i], i));
        }
        Collections.reverse(Arrays.asList(res));
        return res;
    }


    public int[] nsl(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (stack.peek().getKey() < arr[i]) {
                res[i] = stack.peek().getValue();
            } else {
                while (!stack.isEmpty() && stack.peek().getKey() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek().getValue();
                }
            }
            stack.push(new Pair<>(arr[i], i));
        }
        return res;
    }
}