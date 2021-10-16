package Section12_BufferingThrottlingSwitching;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Window {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .window(interval)
                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
