package Section5_HotNColdObservables;

import rx.Observable;
import rx.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class HotObservable {
    public static void main(String[] args) throws InterruptedException {

        ConnectableObservable<Long> connectable = Observable.interval(1, TimeUnit.SECONDS)
                .publish();// Publish makes it hot observable

        connectable.connect(); // We has connected

        connectable.subscribe(System.out::println);
        Thread.sleep(10000);

        // This subscriber will start from 10 because observable has been serving data for about 10 seconds
        connectable.subscribe(System.out::println);
        Thread.sleep(10000);



    }
}
