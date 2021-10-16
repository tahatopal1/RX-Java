package Section10_ConcurrencyNParallelization;

import io.reactivex.rxjava3.core.Observable;

public class HowTo {
    public static void main(String[] args) {

        // We used new Threads because it is not possible to make an observable concurrent by itself
        // Since Observable has a contract, data must be emitted sequentially
        // In order to make it asynchronous as well as parallel, we create a new Thread for each emission
        Observable.create(emitter -> {
           new Thread(() -> {
               emitter.onNext("Hello");
               emitter.onNext("RxJava");
           }).start();
        });


    }
}
