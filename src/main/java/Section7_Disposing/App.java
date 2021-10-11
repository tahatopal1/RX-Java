package Section7_Disposing;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable subscriber = source.subscribe(aLong -> System.out.println("Observer 1: " + aLong));
        source.subscribe(aLong -> System.out.println("Observer 2: " + aLong));

        Thread.sleep(5000);
        subscriber.dispose(); // After 5 seconds, this one stop to observe

        Thread.sleep(5000);
    }

}
