import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T> {
    private Node<T> head;
    private int size;

    public GBLinkedList() {
        size = 0;
    }

    @Override
    public boolean add(T value) {

        Node<T> last = getLastNode();
        if (last == null) {
            head = new Node<T>(value);
        } else {
            last.next = new Node<>(value);
        }
        this.size++;

        return true;
    }

    @Override
    public boolean add(int index, T value) {
        checkIndexOutOfBounds(index);

        Node<T> insertedNode = new Node<T>(value);
        if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else {
            Node<T> previousNode = getNodeOfIndex(index - 1);
            insertedNode.next = previousNode.next;
            previousNode.next = insertedNode;
        }
        this.size++;

        return true;
    }


    @Override
    public void remove(int index) {
        checkIndexOutOfBounds(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> priviousNode = getNodeOfIndex(index - 1);
            priviousNode.next = priviousNode.next.next;
        }

        this.size--;
    }

    @Override
    public T get(int index) {
        checkIndexOutOfBounds(index);
        return getNodeOfIndex(index).value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void update(int index, T value) {
        checkIndexOutOfBounds(index);
        Node<T> node = getNodeOfIndex(index);
        node.value = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(this.toArray());
//        return new Iterator<T>() {
//            int index = 0;
//            @Override
//            public boolean hasNext() {
//                return index < size;
//            }
//            @Override
//            public T next() {
//                return getNodeOfIndex(index++).value;
//            }
//        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] array;
        try {
            array = (T[]) new Object[this.size];
            int i = 0;
            Node<T> node = head;
            while (i < this.size) {
                array[i] = node.value;
                node = node.next;
                i++;
            }
        } catch (ClassCastException e) {
            throw new RuntimeException();
        }
        return array;
    }
    @Override
    public String toString() {
        if (head == null) return "{}";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node<T> node = head;
        stringBuilder.append(node.value);
        while (node.next != null) {
            node = node.next;
            stringBuilder.append(", ");
            stringBuilder.append(node.value);
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private void checkIndexOutOfBounds(int index) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();
    }

    private Node<T> getLastNode() {
        if (head == null) return null;
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node<T> getNodeOfIndex(int index) {
        int i = 0;
        Node<T> currentNode = head;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }


}
