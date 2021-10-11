package Section8_Operators;


import io.reactivex.rxjava3.core.Observable;

public class App {
    public static void main(String[] args) {

        Observable<Employee> observables = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Tom", 94000, 4.7),
                new Employee(101, "Mike", 65000, 4.0),
                new Employee(101, "Anna", 85000, 4.4),
                new Employee(101, "George", 50000, 3.6),
                new Employee(101, "Daniel", 60000, 4.0),
                new Employee(101, "Lucy", 75000, 4.0),
                new Employee(101, "Harry", 55000, 4.0)
        );



    }
}
