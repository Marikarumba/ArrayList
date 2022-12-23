package test;

import StringList.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringListTest {

    private StringListImpl stringList;

    @BeforeEach
    public void setUt(){
    this.stringList = new StringListImpl();

    }

    @Test
    public void addItem(){
        stringList.add("test-");
        System.out.println(stringList.toString());
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        stringList.add(1,"test2");
        Assertions.assertEquals(4,stringList.size());
        Assertions.assertEquals("test0", stringList.get(0));
        Assertions.assertEquals("test2", stringList.get(1));
        Assertions.assertEquals("test1", stringList.get(2));
        Assertions.assertEquals("test-", stringList.get(3));
    }

    @Test
    public void setItem(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        stringList.set(1 ,"test2");
        Assertions.assertEquals(2,stringList.size());
        Assertions.assertEquals("test0", stringList.get(0));
        Assertions.assertEquals("test2", stringList.get(1));
    }
    @Test
    public void removeIndex(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        stringList.remove(1 );
        Assertions.assertEquals(1,stringList.size());
        Assertions.assertEquals("test0", stringList.get(0));
    }
    @Test
    public void removeItem(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        stringList.remove("test0" );
        Assertions.assertEquals(1,stringList.size());
        Assertions.assertEquals("test1", stringList.get(0));
    }
    @Test
    public void containsTrue(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertTrue(stringList.contains("test1"));
    }
    @Test
    public void containsFalse(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertFalse(stringList.contains("test2"));
    }

    @Test
    public void indexOfValid(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertEquals(1, stringList.indexOf("test1"));
    }

    @Test
    public void indexOfNotValid(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertEquals(-1, stringList.indexOf("test2"));
    }

    @Test
    public void LastIndexOfValid(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertEquals(1, stringList.lastIndexOf("test1"));
    }

    @Test
    public void LastIndexOfNotValid(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertEquals(-1, stringList.lastIndexOf("test2"));
    }

    @Test
    public void get(){
        stringList.add(0,"test0");
        stringList.add(1,"test1");
        Assertions.assertEquals("test0", stringList.get(0));

    }

    @Test
    public void nullItem(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringList.add(0,null);
        });
    }

}
