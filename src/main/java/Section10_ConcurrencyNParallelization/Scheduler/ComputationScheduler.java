package Section10_ConcurrencyNParallelization.Scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> src = Generator.observable()
                .subscribeOn(Schedulers.computation());

        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        Thread.sleep(10000);

    }

    public static void compute() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }

}
