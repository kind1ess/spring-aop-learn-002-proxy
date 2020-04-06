package com.kind1ess.proxy.impl;

import com.kind1ess.proxy.Producer;

public class ProducerImpl implements Producer {

    /**
     * 销售
     * @param money
     */
    @Override
    public void saleProduct(Float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    /**
     * 售后
     * @param money
     */
    @Override
    public void afterService(Float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }


}
