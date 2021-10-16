package Section12_BufferingThrottlingSwitching;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Buffering {
    public static void main(String[] args) throws InterruptedException {

        Observable.range(1, 30)
                .buffer(4)
                .subscribe(System.out::println);

        System.out.println("********/**************/********");

        Observable.range(1, 30)
                .buffer(4, 1)
                .subscribe(System.out::println);

        System.out.println("********/**************/********");

        Disposable disposable = Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(8000);
        disposable.dispose();
        System.out.println("********/**************/********");

        Disposable disposable2 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS, 2)
                .subscribe(System.out::println);

        Thread.sleep(8000);
        disposable.dispose();
        Thread.sleep(1000);
        System.out.println("********/**************/********");


        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(System.out::println);

        Thread.sleep(8000);
        System.out.println("********/**************/********");


    }
}
