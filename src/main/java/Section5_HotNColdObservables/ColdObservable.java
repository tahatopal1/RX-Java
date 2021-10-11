package Section5_HotNColdObservables;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdObservable {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> source = Observable.from(list);
        source.subscribe(System.out::println);
        System.out.println();

        list = getData(list);
        source.subscribe(System.out::println);

    }

    private static List<Integer> getData(List<Integer> list) {
        list.add(19);
        return list;
    }
}
