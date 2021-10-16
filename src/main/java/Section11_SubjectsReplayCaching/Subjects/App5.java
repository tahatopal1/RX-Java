package Section11_SubjectsReplayCaching.Subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class App5 {
    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> obs1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> obs2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        PublishSubject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        subject.onNext("Hello");
        subject.onNext("Basics");

        obs2.subscribe(subject);
        obs1.subscribe(subject);

        Thread.sleep(5000);
    }
}
