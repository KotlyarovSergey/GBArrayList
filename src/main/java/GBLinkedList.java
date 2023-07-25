import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T> {
    private Node<T> head;
    private int size;

    public GBLinkedList() {
        size = 0;
    }

    @Override
    public boolean add(T value) {
        try {
            Node<T> last = getLastNode();
            if(last==null){
                head = new Node<T>(value);
            }else {
                last.next = new Node<>(value);
            }
            this.size++;
        } catch (ClassCastException e){
            return false;
        }
        return true;
    }

    public boolean add(T value, int index)
    {
        if(index >= this.size) return this.add(value);

        return  true;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public T get(int index) {
//        Node<T> node = getNodeOfIndex(index);
//        return node.value;
        return getNodeOfIndex(index).value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void update(int index, Object o) {

    }

    @Override
    public Iterator iterator() {        // !!!!!!!!!!!!!!!!!1
        return null;
    }

    @Override
    public String toString() {
        if (head == null) return "{}";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node<T> node = head;
        stringBuilder.append(node.value);
        while (node.next != null){
            node = node.next;
            stringBuilder.append(", ");
            stringBuilder.append(node.value);
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private Node<T> getLastNode(){
        if (head == null) return  null;
        Node<T> currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private  Node<T> getNodeOfIndex(int index){
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
//        if (head == null) return null;
//        if (index == size-1) return getLastNode();

        int i = 0;
        Node<T> currentNode = head;
        while (i != index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

}
