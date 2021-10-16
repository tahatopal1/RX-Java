package Section11_SubjectsReplayCaching.SubjectTypes;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectAsync {
    public static void main(String[] args) throws InterruptedException {

        Subject<String> subject = AsyncSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
        subject.onNext("d");
        subject.onNext("e");
        //subject.onComplete();
    }
}
