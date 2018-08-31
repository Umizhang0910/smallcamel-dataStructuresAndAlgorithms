package com.zhhumi.stack;

/**
 * @author Umizhang
 * @time 2018/8/30
 * 自定义异常
 */
public class StackException extends RuntimeException {
    public StackException(String msg) {
        super(msg);
    }
}
