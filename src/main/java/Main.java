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

        System.out.println(iList.get(0));
        System.out.println(iList.get(1));
//        System.out.println(iList.get(22));



        List<Integer> l = new LinkedList<>();



    }
}
