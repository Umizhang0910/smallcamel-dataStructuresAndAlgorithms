package com.zhhumi.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author Umizhang
 * @time 2018/8/30
 * 順序栈的实现
 */
public class SeqStack<T> implements Stack<T>, Serializable {
    private static final long serialVersionUID = -5413303117698554397L;
    /**
     * 栈顶指针, -1代表空栈
     */
    private int top=-1;
    /**
     * 栈容量大小,默认是10
     */
    private int capacity=10;
    /**
     * 存放元素的数组
     */
    private T[] array;
    private int size;

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    public  int size(){
        return size;
    }

    /**
     * 判断栈是否为空栈
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top==-1;
    }
    /**
     * 添加元素,从栈顶(数组尾部)插入
     * 容量不足时，需要扩容
     * @param data
     */
    @Override
    public void push(T data) {
        // 判断栈容量是否充足
        if (array.length==size) {
            ensureCapacity(size*2+1); //扩容
        }
        //从栈顶添加元素
        array[++top]=data;
        size++;
    }
    /**
     * 获取栈顶元素的值,不删除
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()){
            new EmptyStackException();
        }
        return array[top];
    }
    /**
     * 从栈顶(顺序表尾部)删除
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        size--;
        return array[top--];
    }
    /**
     * 扩容的方法
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity<size)
            return;

        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for (int i=0; i<size ; i++)
            array[i]=old[i];
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        SeqStack<String> s=new SeqStack<>();
        s.push("A");
        s.push("B");
        s.push("C");

        int l=s.size();//size 在减少,必须先记录
        for (int i=0;i<l;i++){
            System.out.println("s.size->"+s.size());
            System.out.println("s.peek->"+s.peek());
            System.out.println("s.pop->"+s.pop()+"\n");
        }
    }
}
