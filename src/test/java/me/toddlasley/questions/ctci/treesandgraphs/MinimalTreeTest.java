package me.toddlasley.questions.ctci.treesandgraphs;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class MinimalTreeTest {
    @Test
    public void buildMinimalTreeShouldBuildMinimalTree() {
        final int[] array0 = new int[]{0, 1, 2, 3, 4, 5, 6};
        final MinimalTree.Node tree0 = MinimalTree.buildMinimalTree(array0);
        assertEquals(calculateMinimalTreeHeight(array0.length), getTreeHeight(new LinkedList<>(Lists.newArrayList(tree0))));

        final int[] array1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        final MinimalTree.Node tree1 = MinimalTree.buildMinimalTree(array1);
        assertEquals(calculateMinimalTreeHeight(array1.length), getTreeHeight(new LinkedList<>(Lists.newArrayList(tree1))));

        final int[] array2 = new int[]{0, 1};
        final MinimalTree.Node tree2 = MinimalTree.buildMinimalTree(array2);
        assertEquals(calculateMinimalTreeHeight(array2.length), getTreeHeight(new LinkedList<>(Lists.newArrayList(tree2))));

        final int[] array3 = new int[]{0, 1, 2};
        final MinimalTree.Node tree3 = MinimalTree.buildMinimalTree(array3);
        assertEquals(calculateMinimalTreeHeight(array3.length), getTreeHeight(new LinkedList<>(Lists.newArrayList(tree3))));
    }

    private static int calculateMinimalTreeHeight(final int n) {
        return (int)Math.floor((Math.log(n) / Math.log(2))) + 1;
    }

    private static int getTreeHeight(Deque<MinimalTree.Node> level) {
        if (level.size() == 0) {
            return 0;
        } else {
            final int size = level.size();
            for (int i = 0; i < size; i++) {
                final MinimalTree.Node current = level.removeFirst();

                if (current.left != null) {
                    level.addLast(current.left);
                }

                if (current.right != null) {
                    level.addLast(current.right);
                }
            }

            return 1 + getTreeHeight(level);
        }
    }
}