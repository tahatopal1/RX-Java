package Section8_Operators;


import io.reactivex.rxjava3.core.Observable;

public class SuppressingOperators {
    public static void main(String[] args) {

        Observable<Employee> observable = Employee.observable();

        // Filter
        observable.filter(employee -> employee.getName()
                    .startsWith("A"))
                    .subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        observable.take(4).subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        observable.skip(4).subscribe(System.out::println);

        System.out.println("-----------/---------------/------------");

        Observable<String> strObs = Observable.just("Hello", "Hello", "Hi");
        strObs.distinct().forEach(System.out::println);

        System.out.println("-----------/---------------/------------");

        observable.elementAt(3).subscribe(System.out::println);


    }
}
