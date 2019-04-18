package xyz.toddlasley.sorts;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void leavesSortedArrayAlone() {
        Integer[] a = { 1, 2, 3, 4, 5};
        MergeSort.sort(a);

        Assert.assertEquals(1, (int)a[0]);
        Assert.assertEquals(2, (int)a[1]);
        Assert.assertEquals(3, (int)a[2]);
        Assert.assertEquals(4, (int)a[3]);
        Assert.assertEquals(5, (int)a[4]);
    }

    @Test
    public void sortsNumbersInRandomOrder() {
        Integer[] a = { 3, 1, 5, 4, 2};
        MergeSort.sort(a);

        Assert.assertEquals(1, (int)a[0]);
        Assert.assertEquals(2, (int)a[1]);
        Assert.assertEquals(3, (int)a[2]);
        Assert.assertEquals(4, (int)a[3]);
        Assert.assertEquals(5, (int)a[4]);
    }

    @Test
    public void sortsNumbersInReverseOrder() {
        Integer[] a = {5, 4, 3, 2, 1};
        MergeSort.sort(a);

        Assert.assertEquals(1, (int) a[0]);
        Assert.assertEquals(2, (int) a[1]);
        Assert.assertEquals(3, (int) a[2]);
        Assert.assertEquals(4, (int) a[3]);
        Assert.assertEquals(5, (int) a[4]);
    }
}