package Section11_SubjectsReplayCaching.Subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class App3 {
    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> obs1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        PublishSubject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("This element is: " + e));

        obs1.subscribe(subject);

        Thread.sleep(5000);
    }
}
