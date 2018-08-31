package com.zhhumi.stack;

/**
 * @author Umizhang
 * @time 2018/8/30
 * 栈接口,抽象数据类型
 */
public interface Stack<T> {
    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
    /**
     * data元素入栈
     * @param data
     */
    void push(T data);
    /**
     * 出栈,返回栈顶元素,未出栈(未从栈中移除该元素)
     * @return
     */
    T peek();
    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();

}
