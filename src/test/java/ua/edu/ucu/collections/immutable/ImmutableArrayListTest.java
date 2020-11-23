package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    ImmutableArrayList arrayList;
    ImmutableArrayList emptyList;

    @Before
    public void setUp() {
        this.arrayList = new ImmutableArrayList(new Object[]{1, 2.1, "string"});
        this.emptyList = new ImmutableArrayList();
    }

    @Test
    public void testAddObject() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.add(6);
        ImmutableArrayList newEmptyList = (ImmutableArrayList) emptyList.add(6);

        assertEquals(newArrayList.toString(), "[1, 2.1, string, 6]");
        assertEquals(newEmptyList.toString(), "[6]");

    }

    @Test
    public void testAddObjectByIndex() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.add(1, 6);
        ImmutableArrayList newEmptyList = (ImmutableArrayList) emptyList.add(0, 6);

        assertEquals(newArrayList.toString(), "[1, 6, 2.1, string]");
        assertEquals(newEmptyList.toString(), "[6]");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddObjectByIndexError() {
        arrayList.add(8, "haha");
    }

    @Test
    public void testAddAllObjects() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.addAll(new Object[]{6, 'a'});
        ImmutableArrayList newEmptyList = (ImmutableArrayList) emptyList.addAll(new Object[]{6, 'a'});

        assertEquals(newArrayList.toString(), "[1, 2.1, string, 6, a]");
        assertEquals(newEmptyList.toString(), "[6, a]");
    }

    @Test
    public void testAddAllObjectsByIndex() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.addAll(1, new Object[]{6, 'a'});
        ImmutableArrayList newEmptyList = (ImmutableArrayList) emptyList.addAll(0, new Object[]{6, 'a'});

        assertEquals(newArrayList.toString(), "[1, 6, a, 2.1, string]");
        assertEquals(newEmptyList.toString(), "[6, a]");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllObjectsByIndexError() {
        arrayList.addAll(8, new Object[]{"haha"});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllObjectsByIndexMinusError() {
        arrayList.addAll(-8, new Object[]{"haha"});
    }

    @Test
    public void testGetObject() {
        Object newObj = arrayList.get(2);

        assertEquals(newObj, "string");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetObjectError() {
        arrayList.get(8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetObjectMinusError() {
        arrayList.get(-8);
    }

    @Test
    public void testRemoveObject() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.remove(1);

        assertEquals(newArrayList.toString(), "[1, string]");

    }

    @Test
    public void testRemoveObjectIndexZero() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.remove(0);

        assertEquals(newArrayList.toString(), "[2.1, string]");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveObjectError() {
        emptyList.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveObjectMinusError() {
        emptyList.remove(-5);
    }

    @Test
    public void testSetObject() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.set(1, "2.2");
        assertEquals(newArrayList.toString(), "[1, 2.2, string]");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetObjectMinusError() {
        arrayList.set(-5, "2.2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetObjectError() {
        arrayList.set(5, "2.2");
    }

    @Test
    public void testIndexOfObject() {
        int index = arrayList.indexOf(2.1);
        assertEquals(index, 1);

    }

    @Test
    public void testIndexOfObjectMinusOne() {
        int index1 = arrayList.indexOf("mama");
        int index2 = emptyList.indexOf("haha");
        assertEquals(index1, -1);
        assertEquals(index2, -1);

    }

    @Test
    public void testSize() {
        int size1 = arrayList.size();
        int size2 = emptyList.size();

        assertEquals(size1, 3);
        assertEquals(size2, 0);

    }

    @Test
    public void testClear() {
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.clear();
        int size = newArrayList.size();
        assertEquals(size, 0);
    }

    @Test
    public void testIsEmpty() {
        boolean newArrayList = arrayList.isEmpty();

        assertFalse(newArrayList);
    }

    @Test
    public void testIsEmptyTrue() {
        boolean newEmptyList = emptyList.isEmpty();
        assertTrue(newEmptyList);
    }

    @Test
    public void testToArray() {
        Object[] newArray = arrayList.toArray();
        assertArrayEquals(newArray, new Object[]{1, 2.1, "string"});
    }
}
