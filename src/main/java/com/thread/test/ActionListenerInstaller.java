package com.thread.test;

import javax.management.ReflectionException;
import java.awt.event.ActionListener;
import java.lang.reflect.*;

public class ActionListenerInstaller {
    public static void processAnnotitions(Object obj){
        Class<? extends Object> cl = obj.getClass();
        for (Method m : cl.getDeclaredMethods()){
            ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
            if(null != a){
                try {
                    Field f = cl.getDeclaredField(a.source());
                    f.setAccessible(true);
                    addListener(f.get(obj),obj,m);
                } catch (NoSuchFieldException | IllegalAccessException | ReflectionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static  void addListener(Object source,final Object param, final Method m) throws ReflectionException{
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(source.toString());
                System.out.println(method.getName());
                System.out.println(param.toString());
                return m.invoke(param);
            }
        };

        Object listener = Proxy.newProxyInstance(null,new Class[]{ActionListener.class},handler);
        try {
            Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
            adder.invoke(source,listener);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
