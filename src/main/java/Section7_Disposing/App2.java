package Section7_Disposing;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class App2 {

    // Composite Disposable: It helps to dispose more than one observers at the same time
    public static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable = source.subscribe(aLong -> System.out.println("Observer 1: " + aLong));
        Disposable disposable1 = source.subscribe(aLong -> System.out.println("Observer 2: " + aLong));
        Disposable disposable2 = source.subscribe(aLong -> System.out.println("Observer 3: " + aLong));

        disp.addAll(disposable, disposable1); // We added all disposable except disposable2
        Thread.sleep(5000);

        disp.dispose(); // After 5 seconds, we disposed 'disposable' and 'disposable1' at the same time
        Thread.sleep(5000);


    }
}
