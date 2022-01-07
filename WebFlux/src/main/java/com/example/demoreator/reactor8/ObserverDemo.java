package com.example.demoreator.reactor8;

import java.util.Observable;

public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        // 添加观察者
        observer.addObserver((o, arg)-> {
            System.out.println("发生了变化");
        });
        observer.addObserver((o, arg)-> {
            System.out.println("收到被观察者通知，准备改变");
        });
        // 监控数据是否发生变化
        observer.setChanged();
        // 通知
        System.out.println("Hello");
        observer.notifyObservers();
    }
}
