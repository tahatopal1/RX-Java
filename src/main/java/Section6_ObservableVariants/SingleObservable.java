package Section6_ObservableVariants;

import rx.Completable;
import rx.Observable;
import rx.Single;

public class SingleObservable {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("Alex", "Justin", "Jack");

        // Maybe observable
        source
                .first(s -> s.length() > 4) // Ensures to print Justin only
                .subscribe(System.out::println);

        // Single observable
        Single.just("Alex")
                .subscribe(System.out::println);

        // Completable observable
        Completable.complete()
                .subscribe(() -> System.out.println("Completed"));

        // Completable from Runnable
        Completable.fromAction(() -> System.out.println("Some process executing..."))
                .subscribe(() -> System.out.println("Completed"));


    }
}
