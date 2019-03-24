package com.thread.test.lee.strings;



import java.util.HashMap;
import java.util.Stack;

//#20
public class IsValid {
    private static HashMap<Character, Character> cache = new HashMap<>();

    static {
        cache.put(')','(');
        cache.put(']','[');
        cache.put('>','<');
    }

    public static void main(String[] args) {
        String s = "([<>])";
        boolean rr = isValid(s);
        System.out.println(rr);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c ==')'||c == '>' || c == ']'){
                Character popped = cache.get(c);
                if(stack.isEmpty()||stack.pop() != popped){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
