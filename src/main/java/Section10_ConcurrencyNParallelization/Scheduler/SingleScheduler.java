package Section10_ConcurrencyNParallelization.Scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.Executors;

public class SingleScheduler {
    public static void main(String[] args) throws InterruptedException {

        Executors.newFixedThreadPool(20);

        Observable<String> src = Generator.observable()
                .subscribeOn(Schedulers.single());

        src.subscribe(s -> sensitiveTask());
        src.subscribe(s -> sensitiveTask());
        src.subscribe(s -> sensitiveTask());
        src.subscribe(s -> sensitiveTask());
        Thread.sleep(10000);
    }

    public static void sensitiveTask() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
