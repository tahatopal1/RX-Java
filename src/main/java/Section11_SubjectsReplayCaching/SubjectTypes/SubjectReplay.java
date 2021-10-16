package Section11_SubjectsReplayCaching.SubjectTypes;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectReplay {
    public static void main(String[] args) {

        Subject<String> subject = ReplaySubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }
}
