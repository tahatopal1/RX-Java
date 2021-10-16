package Section10_ConcurrencyNParallelization.Scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Generator.observable()
                .subscribeOn(Schedulers.io());

        src.subscribe(s -> ioOperation());
        src.subscribe(s -> ioOperation());
        src.subscribe(s -> ioOperation());
        src.subscribe(s -> ioOperation());
        Thread.sleep(10000);
    }

    public static void ioOperation() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
