package Section8_Operators;

import io.reactivex.rxjava3.core.Observable;

public class Employee {

    private Integer id;
    private String name;
    private double salary;
    private double rating;

    public Employee(Integer id, String name, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    public static Observable<Employee> observable(){
        Observable<Employee> observables = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Tom", 94000, 4.7),
                new Employee(102, "Mike", 65000, 4.0),
                new Employee(106, "Anna", 85000, 4.4),
                new Employee(105, "George", 50000, 3.6),
                new Employee(111, "Daniel", 60000, 4.0),
                new Employee(112, "Lucy", 75000, 4.0),
                new Employee(1113, "Harry", 55000, 4.0)
        );
        return observables;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        return this.id == emp.getId()
                    && this.name.equals(emp.getId())
                    && this.rating == emp.getId()
                    && this.salary == emp.getSalary();
    }
}
