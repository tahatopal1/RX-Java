package Section8_Operators;

import io.reactivex.rxjava3.core.Observable;

public class ActionOperators {
    public static void main(String[] args) {

        Observable<Employee> observable = Employee.observable();

        // doOnNext
        observable
                .doOnNext(System.out::println)
                .doOnComplete(() -> System.out.print("Completed!"))
                .doOnSubscribe(disposable -> System.out.println("Subscribed: " + disposable))
                .doOnError(throwable -> throwable.printStackTrace())
                .subscribe();

    }
}
