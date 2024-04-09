package me.toddlasley.questions.ctci.treesandgraphs;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Deque;
import java.util.List;

import static org.junit.Assert.*;
import static me.toddlasley.questions.ctci.treesandgraphs.BSTSequences.allSequences;
import static me.toddlasley.questions.ctci.treesandgraphs.BSTSequences.TreeNode;

public class BSTSequencesTest {

    @Test
    public void getArrayCombinationsShouldReturnSequences() {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        a.left = b;
        a.right = c;

        List<List<Integer>> expected = Lists.newArrayList(
                Lists.newArrayList(5, 3, 7),
                Lists.newArrayList(5, 7, 3)
        );

        assertListsEqual(expected, allSequences(a));
    }

    private static void assertListsEqual(final List<List<Integer>> expected, final List<Deque<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (Deque<Integer> l : actual) {
            assertEquals(1, expected.stream().filter(x -> x.equals(l)).count());
        }
    }

}