package Section9_CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class MergeNConcat {
    public static void main(String[] args) throws InterruptedException {

        // Merge
        Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
        Observable<String> src2 = Observable.just("Priya", "Chloe");

        Observable.merge(src1, src2)
                .subscribe(e -> System.out.println("Received: " + e));
        System.out.println("-----------/---------------/------------");

        Observable<Long> interval1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> interval2 = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable = Observable.merge(interval1, interval2).subscribe(e -> System.out.println("Received: " + e));
        Thread.sleep(10000);
        disposable.dispose();
        System.out.println("-----------/---------------/------------");

        // Concat
        Observable<String> interval3 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "s1: " + e);
        Observable<String> interval4 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "s2: " + e);
        Disposable d = Observable.concat(interval3, interval4).subscribe(e -> System.out.println("Received: " + e));
        Thread.sleep(10000);
        d.dispose();
        System.out.println("-----------/---------------/------------");

        Observable.interval(1, TimeUnit.SECONDS)
                .map(e -> "src1: " + e)
                .concatWith(Observable.interval(1, TimeUnit.SECONDS)
                .map(t -> "src2: " + t))
                .subscribe(System.out::println);
        Thread.sleep(10000);


    }
}
