package com.zhhumi.stack;

import java.io.Serializable;

/**
 * @author Umizhang
 * @time 2018/8/30
 * 栈的链式实现
 */
public class LinkedStack<T> implements Stack<T>,Serializable {
    private static final long serialVersionUID = 1911829302658328353L;
    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = new Node<>();
    }
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top==null || top.data==null;
    }

    @Override
    public void push(T data) {
        if (data == null) {
            throw new StackException("data can't be null");
        }
        if (this.top == null){ // 调用pop后top可能为空
            this.top = new Node<>(data);
        } else if (this.top.data == null){
            this.top.data = data;
        }else {
            Node<T> push = new Node<>(data, this.top);
            top = push; // 更新栈顶
        }
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    //测试
    public static void main(String[] args){
        LinkedStack<String> sl=new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        sl.push("C");
        int length=sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->"+sl.pop());
        }
    }
}



