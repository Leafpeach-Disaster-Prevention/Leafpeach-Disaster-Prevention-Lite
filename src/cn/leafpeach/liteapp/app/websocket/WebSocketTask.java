package cn.leafpeach.liteapp.app.websocket;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class WebSocketTask {
    public static void start() {
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        Thread thread = new Thread(integerFutureTask);
        thread.start();

        Task1 task1 = new Task1();
        FutureTask<Integer> integerFutureTask1 = new FutureTask<>(task1);
        Thread thread1 = new Thread(integerFutureTask1);
        thread1.start();
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() {
            Connection.connect();
            return null;
        }
    }

    static class Task1 implements Callable<Integer> {
        @Override
        public Integer call() {
            Connection.IclConnect();
            return null;
        }
    }
}
