import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBLinkedListTest {

    @Test
    void addTest(){
        GBList<Integer> listTest = new GBLinkedList<>();
        Assertions.assertEquals(0, listTest.size());

        listTest.add(22);
        Assertions.assertEquals(1, listTest.size());
        Assertions.assertNotEquals(0, listTest.size());
        Assertions.assertEquals(22, listTest.get(0));

        listTest.add(33);
        listTest.add(55);
        Assertions.assertEquals(3, listTest.size());
        Assertions.assertEquals(22, listTest.get(0));
        Assertions.assertEquals(33, listTest.get(1));
        Assertions.assertEquals(55, listTest.get(2));
    }

    @Test
    void addIndexTest(){
        GBList<Integer> testedList = new GBLinkedList<>();
        Assertions.assertEquals(0, testedList.size());

        testedList.add(0, 101);
        Assertions.assertEquals(1, testedList.size());
        Assertions.assertEquals(101, testedList.get(0));

        testedList.add(0, 202);
        Assertions.assertEquals(2, testedList.size());
        Assertions.assertEquals(202, testedList.get(0));
        Assertions.assertEquals(101, testedList.get(1));

        testedList.add(1, 303);
        Assertions.assertEquals(3, testedList.size());
        Assertions.assertEquals(303, testedList.get(1));
        Assertions.assertEquals(101, testedList.get(2));

        testedList.add(3, 404);
        Assertions.assertEquals(4, testedList.size());
        Assertions.assertEquals(404, testedList.get(3));

    }

    @Test
    void updateTest(){
        GBList<Integer> testedList = new GBLinkedList<>();

        testedList.add(101);
        testedList.add(1, 202);
        testedList.add(303);
        Assertions.assertEquals(101, testedList.get(0));

        testedList.update(0, 555);
        Assertions.assertEquals(555, testedList.get(0));

        testedList.update(1, 73);
        Assertions.assertEquals(73, testedList.get(1));

        testedList.update(2, 654);
        Assertions.assertEquals(654, testedList.get(2));

    }

    @Test
    void deleteTest(){
        GBList<String> testedList = new GBLinkedList<>();
        testedList.add("aaaaa");
        testedList.add("bbbb");
        testedList.add("ccccccc");
        testedList.add("DDD");
        testedList.add("EeEe");
        Assertions.assertEquals("aaaaa", testedList.get(0));
        Assertions.assertEquals("bbbb", testedList.get(1));
        Assertions.assertEquals("EeEe", testedList.get(4));

        testedList.remove(0);
        Assertions.assertEquals("bbbb", testedList.get(0));
        Assertions.assertEquals("EeEe", testedList.get(3));

        testedList.remove(1);
        Assertions.assertEquals("DDD", testedList.get(1));

    }

}
