package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Producer shop = new Producer();
        Runnable produce = shop::produce;
        Runnable sell = shop::sell;
        Const.get().setConst("DelayProduce",200);
        Const.get().setConst("DelaySell",100);
        Const.get().setConst("CarQty",10);
        new Thread(null, sell, "Покупатель 1").start();
        new Thread(null, sell, "Покупатель 2").start();
        new Thread(null, sell, "Покупатель 3").start();
        new Thread(null, produce, "TOYOTA").start();

    }
}
