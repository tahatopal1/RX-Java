package Section1_Intro;

import rx.Observable;

public class Hello {
    public static void main(String[] args) {

        Observable<String> source
                = Observable.create(stringEmitter -> {
                    stringEmitter.onNext("Hello");
                    stringEmitter.onNext("RX Java");
        });

        source.subscribe(e -> System.out.println("Observer 1: " + e));
        source.subscribe(e -> System.out.println("Observer 2: " + e));

    }
}
