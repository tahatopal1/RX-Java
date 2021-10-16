package Section10_ConcurrencyNParallelization;

import Section10_ConcurrencyNParallelization.Scheduler.Generator;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class Flatmap {
    public static void main(String[] args) throws InterruptedException {

        Generator.observable()
                .flatMap(s -> Observable.just(s).subscribeOn(Schedulers.computation())
                        .map(str -> compute(str))).subscribe(System.out::println);

        Thread.sleep(7000);

    }

    public static String compute(String element) throws InterruptedException{
        return element + ": printed by: " + Thread.currentThread().getName()
                + " at: " + LocalTime.now();
    }
}
