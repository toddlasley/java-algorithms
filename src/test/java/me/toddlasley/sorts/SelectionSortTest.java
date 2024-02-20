package me.toddlasley.sorts;


import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void leavesSortedArrayAlone() {
        final Integer[] a = { 1, 2, 3, 4, 5};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0].intValue());
        Assert.assertEquals(2, a[1].intValue());
        Assert.assertEquals(3, a[2].intValue());
        Assert.assertEquals(4, a[3].intValue());
        Assert.assertEquals(5, a[4].intValue());
    }

    @Test
    public void sortsNumbersInRandomOrder() {
        final Integer[] a = { 3, 1, 5, 4, 2};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0].intValue());
        Assert.assertEquals(2, a[1].intValue());
        Assert.assertEquals(3, a[2].intValue());
        Assert.assertEquals(4, a[3].intValue());
        Assert.assertEquals(5, a[4].intValue());
    }

    @Test
    public void sortsNumbersInReverseOrder() {
        final Integer[] a = { 5, 4, 3, 2, 1};
        SelectionSort.sort(a);

        Assert.assertEquals(1, a[0].intValue());
        Assert.assertEquals(2, a[1].intValue());
        Assert.assertEquals(3, a[2].intValue());
        Assert.assertEquals(4, a[3].intValue());
        Assert.assertEquals(5, a[4].intValue());
    }

}