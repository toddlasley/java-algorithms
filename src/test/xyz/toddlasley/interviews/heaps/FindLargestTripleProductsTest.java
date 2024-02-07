package xyz.toddlasley.interviews.heaps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindLargestTripleProductsTest {
    @Test
    public void shouldFindLargestTripleProducts() {
        assertEquals(new int[]{-1, -1, 6, 24, 60}, FindLargestTripleProducts.findMaxProducts(new int[]{1, 2, 3, 4, 5}));
        assertEquals(new int[]{-1, -1, 56, 56, 140, 140}, FindLargestTripleProducts.findMaxProducts(new int[]{2, 4, 7, 1, 5, 3}));
    }
}
