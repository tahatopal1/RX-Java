package Section9_CombiningObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMap {
    public static void main(String[] args) {

        Observable.fromIterable(List.of("Hello", "Reactive", "Programming"))
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

    }
}
