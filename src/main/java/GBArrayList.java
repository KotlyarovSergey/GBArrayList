import java.util.Arrays;
import java.util.Iterator;

public class GBArrayList<T> implements GBList<T> {
    private T[] values;

    @SuppressWarnings("unchecked")
    public GBArrayList() {
        this.values = (T[]) new Object[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(T t) {
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            values[values.length - 1] = t;
            return true;
        } catch (ClassCastException e) {
            return false;
        }

    }

    @Override
    public boolean add(int index, T t) {
        if(index > values.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, values, 0, index);
            System.arraycopy(tempArray, index, values, index+1, tempArray.length-index);
            values[index] = t;
            return true;
        } catch (ClassCastException e) {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public void remove(int index) {
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length - 1];
            System.arraycopy(tempArray, 0, values, 0, index);
            int amountElementsAfterIndex = tempArray.length - index - 1;
            System.arraycopy(tempArray, index+1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T t) {
        values[index] = t;
    }

    @Override
    public Object[] toArray() {
        return values;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(values);
    }

    @Override
    public String toString() {
        return "GBArrayList{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
