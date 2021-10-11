package Section2_ObservarbleNObserver;

import rx.Observable;
import rx.Observer;

public class App {
    public static void main(String[] args) {

        Observable<Integer> source = Observable.create(emitter -> {
            try{
                emitter.onNext(10);
                emitter.onNext(11);
                emitter.onCompleted();
            }catch (Throwable t){
                emitter.onError(t);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On next: " + integer);
            }

        };

        source.subscribe(observer);

    }
}
