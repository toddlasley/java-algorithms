// Given the root node of a binary tree, print the values of
// each level in the tree with each level separated by a
// newline.

// Example Tree
//   1
//   / \
//   2   3
//   / \   \
//   4  5   6
//    \
//     7

// Prints with newline separators:
//   1
//   23
//   456
//   7
package me.toddlasley.datastructures.trees.traversals;

import me.toddlasley.datastructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstTraversal {
    public static String printNodes(TreeNode root) {
        if ( root != null ) {
            StringBuilder sb = new StringBuilder();

            List list = new ArrayList<TreeNode>();
            list.add(root);

            printNodesHelper(list, sb);

            return sb.toString();
        } else {
            return null;
        }
    }

    private static void printNodesHelper(List<TreeNode> nodeLevel, StringBuilder sb) {
        if ( nodeLevel.size() == 0 ) {
            return;
        }

        List newList = new ArrayList<TreeNode>();

        for ( TreeNode node : nodeLevel ) {
            if ( node.left != null ) {
                newList.add(node.left);
            }

            if ( node.right != null ) {
                newList.add(node.right);
            }

            sb.append(String.format("(%d)", node.data));
        }

        sb.append("\n");

        printNodesHelper(newList, sb);
    }
}
