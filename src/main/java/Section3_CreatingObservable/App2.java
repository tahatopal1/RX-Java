package Section3_CreatingObservable;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) {

        // range (for range based emissions)
        Observable.range(0, 10)
                .subscribe(i -> System.out.println("hello" + i));

        System.out.println("------------------------------------");

        // interval (takes time period)
        Observable
                .interval(1,1, TimeUnit.SECONDS)
                .subscribe(aLong -> System.out.println("Interval: " + aLong));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
