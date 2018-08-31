package com.zhhumi.stack;

/**
 * @time 2018/8/30
 * 表达式的检测验证
 */
public class CheckValidateExpression {
    public static String isValid(String expStr) {
        //创建栈
        LinkedStack<String> stack = new LinkedStack<>();
        int i = 0;
        while (i < expStr.length()) {
            char ch = expStr.charAt(i);
            i++;
            switch (ch) {
                case '(': stack.push(ch+""); //左括号直接入栈
                    break;
                case ')': if (stack.isEmpty() || !stack.pop().equals("(")) //遇见右括号左括号直接出栈
                    return "(";
            }
        }
        //最后检测是否为空, 为空则检测通过
        if (stack.isEmpty()) {
            return "check pass!";
        }else {
            return "check exception!";
        }
    }

    public static void main(String[] args) {
        String str = "((5-3)*6-2)";
        System.out.println(str+"    "+isValid(str));
    }
}
