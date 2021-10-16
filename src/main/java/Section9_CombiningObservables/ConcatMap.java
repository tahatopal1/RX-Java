package Section9_CombiningObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class ConcatMap {
    public static void main(String[] args) {

        Observable.fromIterable(List.of("Hello", "Reactive", "Programming"))
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}
