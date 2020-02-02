package xyz.toddlasley.leetcode.medium.treesandgraphs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ZigZagLevelTraversalTest {

    @Test
    public void traverseCorrectlyZigZagsThroughLevels() {
        //      10
        //    /     \
        //   5       20
        //  / \     /  \
        // 1   6  15    30
        ZigZagLevelTraversal.TreeNode perfectTreeRoot = new ZigZagLevelTraversal.TreeNode(10);
        perfectTreeRoot.left = new ZigZagLevelTraversal.TreeNode(5);
        perfectTreeRoot.right = new ZigZagLevelTraversal.TreeNode(20);

        perfectTreeRoot.left.left = new ZigZagLevelTraversal.TreeNode(1);
        perfectTreeRoot.left.right = new ZigZagLevelTraversal.TreeNode(6);

        perfectTreeRoot.right.left = new ZigZagLevelTraversal.TreeNode(15);
        perfectTreeRoot.right.right = new ZigZagLevelTraversal.TreeNode(30);

        List<List<Integer>> result = ZigZagLevelTraversal.traverse(perfectTreeRoot);

        List<Integer> list0 = result.get(0);
        assertEquals(1, list0.size());
        assertEquals(10, (int)list0.get(0));
        List<Integer> list1 = result.get(1);
        assertEquals(2, list1.size());
        assertEquals(20, (int)list1.get(0));
        assertEquals(5, (int)list1.get(1));
        List<Integer> list2 = result.get(2);
        assertEquals(4, list2.size());
        assertEquals(1, (int)list2.get(0));
        assertEquals(6, (int)list2.get(1));
        assertEquals(15, (int)list2.get(2));
        assertEquals(30, (int)list2.get(3));
    }
}