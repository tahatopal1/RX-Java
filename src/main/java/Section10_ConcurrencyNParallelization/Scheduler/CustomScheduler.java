package Section10_ConcurrencyNParallelization.Scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> src = Generator.observable()
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());

    }

    public static void compute() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
