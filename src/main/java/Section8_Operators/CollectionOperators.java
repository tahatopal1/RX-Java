package Section8_Operators;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionOperators {
    public static void main(String[] args) {

        Observable<Employee> observable = Employee.observable();

        // toList -> Single emission of list
        Single<@NonNull List<Employee>> listSingle = observable.toList();
        listSingle.subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        // sortedList -> Single emission of sortedList
        Single<@NonNull List<Employee>> sortedList
                = observable.toSortedList(Comparator.comparing(Employee::getRating));
        sortedList.subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        // toMap ->
        Single<Map<Integer, String>> mapSingle = observable.toMap(Employee::getId, Employee::getName);
        mapSingle.subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");

        // collect -> Single emission of any collection
        Single<TreeSet<Employee>> collected
                = observable.
                collect(Collectors.toCollection(
                        () -> new TreeSet<Employee>(Comparator.comparing(Employee::getSalary))));
        collected.subscribe(System.out::println);
        System.out.println("-----------/---------------/------------");



    }
}
