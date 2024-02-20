package me.toddlasley.questions.random.heaps;

import me.toddlasley.questions.random.heaps.FindLargestTripleProducts;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindLargestTripleProductsTest {
    @Test
    public void shouldFindLargestTripleProducts() {
        assertArrayEquals(new int[]{-1, -1, 6, 24, 60}, FindLargestTripleProducts.findMaxProducts(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{-1, -1, 56, 56, 140, 140}, FindLargestTripleProducts.findMaxProducts(new int[]{2, 4, 7, 1, 5, 3}));
    }
}
