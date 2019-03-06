package xyz.toddlasley.sorts;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sortsNumbersInReverseOrder() {
        Integer[] a = { 5, 4, 3, 2, 1};
        InsertionSort.sort(a);

        Assert.assertEquals((int)a[0], 1);
        Assert.assertEquals((int)a[1], 2);
        Assert.assertEquals((int)a[2], 3);
        Assert.assertEquals((int)a[3], 4);
        Assert.assertEquals((int)a[4], 5);
    }
}