package Section8_Operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class TransformingOperators {
    public static void main(String[] args) throws InterruptedException {

        Observable<Employee> observable = Employee.observable();

        // Map
        observable.map(employee -> employee.getName())
                .subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        // Cast
        Observable.just(1,2,3).cast(Number.class)
                .subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        // Delay
        observable.delay(3, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        Thread.sleep(10000);

        System.out.println("-----------/---------------/------------");

        // Delay subscription
        observable.delaySubscription(5, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        Thread.sleep(10000);

        System.out.println("-----------/---------------/------------");

        // Scan
        Observable.just(1,2,3,4,5)
                .scan((a, b) -> a + b)
                .subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        // Sorted
        observable.sorted(Comparator.comparing(Employee::getSalary)).subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        // Repeat
        observable.repeat(2).subscribe(System.out::println);

    }
}
