// 3.5: Write a program to sort a stack such that the smallest items are on the top.
//      You can use an additional temporary stack, but you may not copy the elements
//      into any other data structure (such as an array). The stack supports the
//      following operations: push, pop, peek, and isEmpty.

package me.toddlasley.questions.ctci.stacksandqueues;

import java.util.Stack;

public class SortStack {
    public static void sort (Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<Integer>();

        while ( !stack.isEmpty() ) {
            int temp = stack.pop();

            while ( !tempStack.isEmpty() && tempStack.peek() > temp ) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        while ( !tempStack.isEmpty() ) {
            stack.push(tempStack.pop());
        }
    }
}
