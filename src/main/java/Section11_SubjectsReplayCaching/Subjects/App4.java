package Section11_SubjectsReplayCaching.Subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class App4 {
    public static void main(String[] args) {

        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("Observer: " + e));

        subject.onNext("Hello");
        subject.onNext("BasicsStrong");
        subject.onComplete();
        subject.onNext("BasicsStrong");

    }
}
