import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public GBLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(T value) {
        Node<T> node = new Node<T>(value);
        if (this.size == 0) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean add(int index, T value) {
        checkIndexOutOfBounds(index);

        Node<T> insertedNode = new Node<T>(value);
        if (index == 0) {
            insertedNode.next = this.head;
            this.head = insertedNode;
            if (this.tail == null) this.tail = insertedNode;
        } else if (index == size) {
            this.tail.next = insertedNode;
            this.tail = insertedNode;
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
            this.head = this.head.next;
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
            Node<T> node = this.head;
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
        if (this.head == null) return "{}";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node<T> node = this.head;
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

//    private Node<T> getLastNode() {
//        if (head == null) return null;
//        Node<T> currentNode = head;
//        while (currentNode.next != null) {
//            currentNode = currentNode.next;
//        }
//        return currentNode;
//    }

    private Node<T> getNodeOfIndex(int index) {
        int i = 0;
        Node<T> currentNode = this.head;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }
}
