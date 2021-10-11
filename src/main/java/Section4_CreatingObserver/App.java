package Section4_CreatingObserver;

import rx.Observable;

public class App {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("Orange", "Black", "Red");

        // onNext - onError - onCompleted
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        System.out.println();

        // onNext - onError
        source.subscribe(System.out::println, Throwable::printStackTrace);

        System.out.println();

        // onNext
        source.subscribe(System.out::println, Throwable::printStackTrace);

    }
}
