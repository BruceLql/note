package com.bruce.note;


import org.junit.Test;

import java.util.Stack;

/**
 * @author 李启岚(起冉)
 */
public class StackReverse {

    private static Stack<Integer> stack = new Stack();

    /**
     * 使用递归来完成一个栈的逆序操作。
     * 不能借助任何其他数据结构。
     */
    public void initData() {
//        stack.push(5);
//        stack.push(4);
//        stack.push(3);
//        stack.push(2);
//        stack.push(1);
    }

    /**
     * Reverse a stack
     */
    public void stackReverse(Stack stack) {
        // 递归结束条件
        if (stack.isEmpty()) {
            return;
        }
        //  取栈底数据
        Integer element = getAndRemovTailElement(stack);
        // 递归调用，触发上一步操作
        stackReverse(stack);
        // 原始栈逆序入栈
        stack.push(element);
    }

    /**
     * Get and remove the tail element of a stack;(栈的递归，取栈底)
     */
    public Integer getAndRemovTailElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        //  递归结束条件
        if (stack.isEmpty()) {
            return result;
        }
        // 返回栈底元素
        Integer tail = getAndRemovTailElement(stack);
        // 递归结束条件触发后，将弹出的非栈底元素入栈，保持栈原始结构
        stack.push(result);
        return tail;
    }

    @Test
    public void test001() {
        initData();
        stackReverse(stack);
        for (int size = stack.size(); size > 0; size--) {
            System.out.println(stack.pop());
        }
    }


}
