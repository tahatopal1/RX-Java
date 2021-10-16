package Section9_CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Amb {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> obs1 = Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map(e -> "Ob 1: " + e);

        Observable<String> obs2 = Observable.interval(1, TimeUnit.MILLISECONDS).take(10)
                .map(e -> "Ob 2: " + e);

        // Prints obs2 because it's faster than obs1 (in milliseconds level)
        Disposable disposable = Observable.amb(Arrays.asList(obs1, obs2))
                .subscribe(System.out::println);
        Thread.sleep(11000);
        disposable.dispose();



    }
}
