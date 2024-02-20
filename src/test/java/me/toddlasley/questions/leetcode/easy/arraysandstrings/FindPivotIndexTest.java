package me.toddlasley.questions.leetcode.easy.arraysandstrings;


import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPivotIndexTest {
    @Test
    public void findPivotFindsPivot() {
        assertEquals(3, FindPivotIndex.findPivot(Lists.newArrayList(1, 7, 3, 6, 5, 6)));
        assertEquals(-1, FindPivotIndex.findPivot(Lists.newArrayList(1, 2, 3)));
        assertEquals(0, FindPivotIndex.findPivot(Lists.newArrayList(2, 1, -1)));
    }
}