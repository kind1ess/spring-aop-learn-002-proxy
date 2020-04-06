package com.kind1ess.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ProducerImpl producerProxy = (ProducerImpl) Enhancer.create(ProducerImpl.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(new ProducerImpl(),money*0.8f);
                }
                return returnValue;
            }
        });
        producerProxy.saleProduct(10000f);
    }
}
