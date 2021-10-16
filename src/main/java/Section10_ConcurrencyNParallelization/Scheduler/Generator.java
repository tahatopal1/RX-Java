package Section10_ConcurrencyNParallelization.Scheduler;

import io.reactivex.rxjava3.core.Observable;

public class Generator {
    public static Observable<String> observable(){
        return Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein");
    }
}
