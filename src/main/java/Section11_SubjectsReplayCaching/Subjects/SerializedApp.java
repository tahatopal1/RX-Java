package Section11_SubjectsReplayCaching.Subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SerializedApp {
    public static void main(String[] args) {

        PublishSubject<Object> subject = PublishSubject.create();
        Subject<Object> serialized = subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e -> System.out.print("Observer: " + e));

        serialized.onNext("Hello");
        serialized.onNext("Basics");
        serialized.onComplete();
        serialized.onNext("Basics");

    }
}
