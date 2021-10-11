package Section3_CreatingObservable;

import rx.Observable;

public class App3 {
    public static void main(String[] args) {
        System.out.println("------------------------------------");

        // It won't emit anything, will just call onComplete action
        Observable.empty()
                        .doOnCompleted(() -> System.out.println("Completed!"))
                        .subscribe(o -> System.out.println()); // If don't emit anything, won't get to work onNext method

        // Just like throw keyword, we may cause an error intentionally by using .error()
        Observable.error(new Throwable("Testing for error"))
                                    .subscribe(o -> System.out.println()); // Won't work anyways, just throws an error

    }
}
