package Section10_ConcurrencyNParallelization;

import Section10_ConcurrencyNParallelization.Scheduler.Generator;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws InterruptedException {

        Generator.observable()
                .subscribeOn(Schedulers.computation())
                .map(o -> o.toUpperCase())
                .subscribeOn(Schedulers.newThread())
                .filter(s -> s.startsWith("P"))
                .subscribe(s -> print(s));

        Thread.sleep(6000);

    }

    public static void print(String element) throws InterruptedException{
        System.out.println(element + ": printed by: " + Thread.currentThread().getName());
    }
}
