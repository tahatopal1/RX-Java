package Section3_CreatingObservable;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class App4 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("Mike");

        Observable<String> source = Observable.defer(
                () -> Observable.from(list)
        );

        source.subscribe(System.out::println);

        System.out.println("---------------------------");

        list.add("Paul");
        source.subscribe(System.out::println);

        System.out.println("---------------------------");

        // Having an observable from a Callable class
        Observable.fromCallable(() -> new Model("Hello"))
                                .subscribe(System.out::println);


    }
}
