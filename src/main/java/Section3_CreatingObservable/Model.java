package Section3_CreatingObservable;

import java.util.concurrent.Callable;

public class Model implements Callable {

    private String value;

    public Model(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
