package com.kind1ess.client;

import com.kind1ess.proxy.Producer;
import com.kind1ess.proxy.impl.ProducerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();
        Producer producerProxy = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        提供增强的代码
//                        获取方法执行的参数
                        Object returnValue = null;
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                            return returnValue;
                    }
                });
        producerProxy.saleProduct(10000f);
    }
}
