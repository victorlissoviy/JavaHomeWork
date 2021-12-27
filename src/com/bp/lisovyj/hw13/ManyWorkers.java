package com.bp.lisovyj.hw13;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ManyWorkers {
    private final Queue<Integer> list = new ArrayDeque<>();
    private final Random random = new Random();
    private boolean waitEmpty = false;
    private boolean waitFull = false;

    public void produser(){
        while (true) {
            try {
                int num = random.nextInt(10);
                synchronized (this){
                    list.add(num);
                    if (waitEmpty) {
                        waitEmpty = false;
                        this.notify();
                    }
                    while (list.size() >= 5) {
                        waitFull = true;
                        this.wait(100);
                    }
                }
                Thread.sleep(num * 10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void consumer(){
        while (true) {
            try {
                int num;
                synchronized (this){
                    while (list.isEmpty()) {
                        waitEmpty = true;
                        this.wait(100);
                    }
                    num = list.remove();
                    if (waitFull) {
                        waitFull = false;
                        this.notify();
                    }
                }
                System.out.println(num + "\t" + list.size());
                Thread.sleep(num * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ManyWorkers h = new ManyWorkers();

        for(int i = 0; i < 3; i++){
            Thread t = new Thread(h::produser);
            t.setDaemon(true);
            t.start();
        }

        for(int i = 0; i < 10; i++){
            Thread t = new Thread(h::consumer);
            t.setDaemon(true);
            t.start();
        }

        Thread.sleep(10_000);
    }
}
