//import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        GBList<Integer> list = new GBArrayList<>();
//        System.out.println(list.size());
//        list.add(12);
//        list.add(65);
//        list.add(846);
//        System.out.println(list.size());
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        list.update(2, 43);
//        System.out.println(list.get(2));
//        list.add(33);
//        System.out.println(list);
//        System.out.println();
//        list.remove(2);
//        System.out.println(list);
//        System.out.println(list.size());
//
//        list.add(17);
//        list.add(99);
//        System.out.println(list);
//        list.add(0,5);
//        System.out.println(list);
//        Object[] listArray = list.toArray();
//        System.out.println(listArray.length + ": " + (int)listArray[0]);



//        GBList<String> strList = new GBArrayList<>();
//        strList.add("aaa");
//        strList.add("bbbb");
//        System.out.println(strList.get(1));


        GBList<Integer> iList = new GBLinkedList<>();
        System.out.println(iList.size() + ": " + iList);
        iList.add(1);
        System.out.println(iList.size() + ": " + iList);
        iList.add(2);
        System.out.println(iList.size() + ": " + iList);
        iList.add(3);
        System.out.println(iList.size() + ": " + iList);

        iList.add(0,0);
        System.out.println(iList.size() + ": " + iList);
        iList.add( 1, 77);
        iList.add( 5, 88);
        System.out.println(iList.size() + ": " + iList);
        iList.update(5, 10);
        System.out.println(iList.size() + ": " + iList);

        iList.remove(5);
        System.out.println(iList.size() + ": " + iList);
        iList.remove(4);
        System.out.println(iList.size() + ": " + iList);

        for (Integer itm : iList) {
            System.out.println(itm);
        }


        GBList<Node<String>> nodes = new GBLinkedList<>();
        nodes.add(new Node<String>("aaa"));
        nodes.add(new Node<String>("tttth"));
        nodes.add(new Node<String>("hhghghghg"));
        for (Node<String> n:
                nodes) {
            System.out.println(n.value);
        }





    }
}
