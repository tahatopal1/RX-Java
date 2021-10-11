package Section3_CreatingObservable;

import rx.Observable;

import java.util.List;

// Creating observable example
public class App {
    public static void main(String[] args) {

        // Create
        Observable<Integer> observable = Observable.create(emitter -> {
           emitter.onNext(10);
           emitter.onNext(11);
           emitter.onNext(12);
           emitter.onCompleted();
        });

        // Only deals with onNext(Integer) method which is actually a Consumer
        // Ignores onCompleted and onError methods
        observable.subscribe(System.out::println);

        System.out.println("------------------------------------");

        // Just
        Observable<Integer> just = Observable.just(1,2,3);
        just.subscribe(System.out::println);

        System.out.println("------------------------------------");

        // fromIterable
        List<String> list = List.of("Hi", "Hello", "Good Morning", "Good Bye", "Take Care");
        Observable<String> fromIterable = Observable.from(list);
        fromIterable.subscribe(System.out::println);

    }
}
