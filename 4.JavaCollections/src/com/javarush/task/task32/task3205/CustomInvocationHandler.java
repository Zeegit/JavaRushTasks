package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods inter;

    public CustomInvocationHandler(SomeInterfaceWithMethods inter) {
        this.inter = inter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.format("[%s in]%n", method.getName());
        Object obj = method.invoke(inter, args);
        System.out.format("[%s out]%n", method.getName());
        return obj;
    }
}
