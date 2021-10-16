package Section9_CombiningObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Zip {
    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(src1, src2, (e1, e2) -> "Src 1:" + e1 + " Src 2: " + e2)
                .subscribe(System.out::println);
        Thread.sleep(20000);

    }
}
