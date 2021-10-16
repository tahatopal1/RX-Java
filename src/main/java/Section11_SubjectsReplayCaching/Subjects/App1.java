package Section11_SubjectsReplayCaching.Subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class App1 {
    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> obs1 = Observable.just(5, 10, 15, 20);
        Observable<Integer> obs2 = Observable.just(50, 100, 150, 200);

        PublishSubject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);

        obs2.subscribe(subject);
        obs1.subscribe(subject);

        Thread.sleep(9000);

    }
}
