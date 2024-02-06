package xyz.toddlasley.sorts;


import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void leavesSortedArrayAlone() {
        int[] a = { 1, 2, 3, 4, 5};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0]);
        Assert.assertEquals(2, a[1]);
        Assert.assertEquals(3, a[2]);
        Assert.assertEquals(4, a[3]);
        Assert.assertEquals(5, a[4]);
    }

    @Test
    public void sortsNumbersInRandomOrder() {
        int[] a = { 3, 1, 5, 4, 2};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0]);
        Assert.assertEquals(2, a[1]);
        Assert.assertEquals(3, a[2]);
        Assert.assertEquals(4, a[3]);
        Assert.assertEquals(5, a[4]);
    }

    @Test
    public void sortsNumbersInReverseOrder() {
        int[] a = { 5, 4, 3, 2, 1};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0]);
        Assert.assertEquals(2, a[1]);
        Assert.assertEquals(3, a[2]);
        Assert.assertEquals(4, a[3]);
        Assert.assertEquals(5, a[4]);
    }

}