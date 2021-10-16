package Section9_CombiningObservables;

import Section8_Operators.Employee;
import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee> observable = Employee.observable();

        observable.groupBy(Employee::getRating)
                .flatMapSingle(key -> key.toMultimap(Employee::getId, Employee::getName))
                .subscribe(System.out::println);

    }
}
