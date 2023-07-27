public interface GBList<E> extends Iterable<E>{
    boolean add(E e);
    boolean add(int index, E e);

    void remove(int index);

    E get (int index);

    int size();

    void update(int index, E e);

    Object[] toArray();

}
