package Section8_Operators;

import io.reactivex.rxjava3.core.Observable;

public class ReducingOperators {
    public static void main(String[] args) {

        Observable<Employee> observable = Employee.observable();

        observable.count().subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        Observable.just(1,2,3,4,5)
                .reduce((a, b) -> (a + b))
                .subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        Observable.just(1,2,3,4,5).
                contains(4).
                subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        observable.all(employee -> employee.getRating() > 3)
                .subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        observable.any(employee -> employee.getName().equalsIgnoreCase("Anna"))
                .subscribe(System.out::println);

    }
}
