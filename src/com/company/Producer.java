package com.company;

import java.util.ArrayList;
import java.util.List;

public class Producer {

    static List<Car> stock = new ArrayList<>();


    public void produce() {
        for (int i = 1; i <= Const.get().getConst("CarQty"); i++) {
            synchronized (this) {
                try {
                    Thread.currentThread().sleep(Const.get().getConst("DelayProduce"));
                    stock.add(new Car());
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Car> getStock() {
        return stock;
    }

    public void sell() {

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " зашел");
            try {
                while (stock.size() == 0) {
                    System.out.println("Машин нет!");
                    this.wait();
                }
                Thread.currentThread().sleep(Const.get().getConst("DelaySell"));
                System.out.println("Автомобиль продан " + Thread.currentThread().getName());
                stock.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
