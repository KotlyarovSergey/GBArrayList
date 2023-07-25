import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBLinkedListTest {

    @Test
    void addTest(){
        GBList<Integer> listTest = new GBLinkedList<>();
        Assertions.assertEquals(0, listTest.size());
        listTest.add(22);
        Assertions.assertEquals(1, listTest.size());
        listTest.add(33);
        listTest.add(55);
        Assertions.assertEquals(3, listTest.size());
    }

}
