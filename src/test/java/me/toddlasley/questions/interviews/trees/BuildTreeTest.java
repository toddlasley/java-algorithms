package me.toddlasley.questions.interviews.trees;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static me.toddlasley.questions.interviews.trees.BuildTree.TreeNodeInput;
import static me.toddlasley.questions.interviews.trees.BuildTree.TreeNode;
import static me.toddlasley.questions.interviews.trees.BuildTree.build;
import static me.toddlasley.questions.interviews.trees.BuildTree.buildWithoutRootIndicator;

public class BuildTreeTest {
    @Test
    public void buildShouldReturnTree() throws Exception {
        //   root
        //   /  \
        //  a     b
        // / \    / \
        // c  d  e   f
        TreeNodeInput c = new TreeNodeInput("c");
        TreeNodeInput d = new TreeNodeInput("d");
        TreeNodeInput e = new TreeNodeInput("e");
        TreeNodeInput f = new TreeNodeInput("f");
        TreeNodeInput a = new TreeNodeInput("a", Lists.newArrayList(c.id, d.id));
        TreeNodeInput b = new TreeNodeInput("b", Lists.newArrayList(e.id, f.id));
        TreeNodeInput root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id));
        List<TreeNodeInput> input = Lists.newArrayList(root, d, c, e, a, f, b);
        TreeNode result = build(input);
        Map<String, List<String>> expectedTreeNodes = new HashMap<>();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b"));
        expectedTreeNodes.put("a", Lists.newArrayList("c", "d"));
        expectedTreeNodes.put("b", Lists.newArrayList("e", "f"));
        expectedTreeNodes.put("c", Lists.newArrayList());
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        // /\   /\   \
        // d e f  g   h

        d = new TreeNodeInput("d");
        e = new TreeNodeInput("e");
        f = new TreeNodeInput("f");
        TreeNodeInput g = new TreeNodeInput("g");
        TreeNodeInput h = new TreeNodeInput("h");
        a = new TreeNodeInput("a", Lists.newArrayList(d.id, e.id));
        b = new TreeNodeInput("b", Lists.newArrayList(f.id, g.id));
        c = new TreeNodeInput("c", Lists.newArrayList(h.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(root, d, c, g, h, e, a, f, b);
        result = build(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList("d", "e"));
        expectedTreeNodes.put("b", Lists.newArrayList("f", "g"));
        expectedTreeNodes.put("c", Lists.newArrayList("h"));
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());
        expectedTreeNodes.put("g", Lists.newArrayList());
        expectedTreeNodes.put("h", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        // /\        \
        // d e        f

        d = new TreeNodeInput("d");
        e = new TreeNodeInput("e");
        f = new TreeNodeInput("f");
        a = new TreeNodeInput("a", Lists.newArrayList(d.id, e.id));
        b = new TreeNodeInput("b");
        c = new TreeNodeInput("c", Lists.newArrayList(f.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(e, b, d, root, f, c, a);
        result = build(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList("d", "e"));
        expectedTreeNodes.put("b", Lists.newArrayList());
        expectedTreeNodes.put("c", Lists.newArrayList("f"));
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        //           \
        //            d

        d = new TreeNodeInput("d");
        a = new TreeNodeInput("a");
        b = new TreeNodeInput("b");
        c = new TreeNodeInput("c", Lists.newArrayList(d.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(b, root, d, a, c);
        result = build(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList());
        expectedTreeNodes.put("b", Lists.newArrayList());
        expectedTreeNodes.put("c", Lists.newArrayList("d"));
        expectedTreeNodes.put("d", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());
    }

    @Test
    public void buildWithoutRootIndicatorShouldReturnTree() throws Exception {
        //   root
        //   /  \
        //  a     b
        // / \    / \
        // c  d  e   f
        TreeNodeInput c = new TreeNodeInput("c");
        TreeNodeInput d = new TreeNodeInput("d");
        TreeNodeInput e = new TreeNodeInput("e");
        TreeNodeInput f = new TreeNodeInput("f");
        TreeNodeInput a = new TreeNodeInput("a", Lists.newArrayList(c.id, d.id));
        TreeNodeInput b = new TreeNodeInput("b", Lists.newArrayList(e.id, f.id));
        TreeNodeInput root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id));
        List<TreeNodeInput> input = Lists.newArrayList(root, d, c, e, a, f, b);
        TreeNode result = buildWithoutRootIndicator(input);
        Map<String, List<String>> expectedTreeNodes = new HashMap<>();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b"));
        expectedTreeNodes.put("a", Lists.newArrayList("c", "d"));
        expectedTreeNodes.put("b", Lists.newArrayList("e", "f"));
        expectedTreeNodes.put("c", Lists.newArrayList());
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        // /\   /\   \
        // d e f  g   h

        d = new TreeNodeInput("d");
        e = new TreeNodeInput("e");
        f = new TreeNodeInput("f");
        TreeNodeInput g = new TreeNodeInput("g");
        TreeNodeInput h = new TreeNodeInput("h");
        a = new TreeNodeInput("a", Lists.newArrayList(d.id, e.id));
        b = new TreeNodeInput("b", Lists.newArrayList(f.id, g.id));
        c = new TreeNodeInput("c", Lists.newArrayList(h.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(root, d, c, g, h, e, a, f, b);
        result = buildWithoutRootIndicator(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList("d", "e"));
        expectedTreeNodes.put("b", Lists.newArrayList("f", "g"));
        expectedTreeNodes.put("c", Lists.newArrayList("h"));
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());
        expectedTreeNodes.put("g", Lists.newArrayList());
        expectedTreeNodes.put("h", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        // /\        \
        // d e        f

        d = new TreeNodeInput("d");
        e = new TreeNodeInput("e");
        f = new TreeNodeInput("f");
        a = new TreeNodeInput("a", Lists.newArrayList(d.id, e.id));
        b = new TreeNodeInput("b");
        c = new TreeNodeInput("c", Lists.newArrayList(f.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(e, b, d, root, f, c, a);
        result = buildWithoutRootIndicator(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList("d", "e"));
        expectedTreeNodes.put("b", Lists.newArrayList());
        expectedTreeNodes.put("c", Lists.newArrayList("f"));
        expectedTreeNodes.put("d", Lists.newArrayList());
        expectedTreeNodes.put("e", Lists.newArrayList());
        expectedTreeNodes.put("f", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());

        //    root
        //   /  |  \
        //  a   b   c
        //           \
        //            d

        d = new TreeNodeInput("d");
        a = new TreeNodeInput("a");
        b = new TreeNodeInput("b");
        c = new TreeNodeInput("c", Lists.newArrayList(d.id));
        root = new TreeNodeInput("root", Lists.newArrayList(a.id, b.id, c.id));
        input = Lists.newArrayList(b, root, d, a, c);
        result = buildWithoutRootIndicator(input);
        expectedTreeNodes.clear();
        expectedTreeNodes.put("root", Lists.newArrayList("a", "b", "c"));
        expectedTreeNodes.put("a", Lists.newArrayList());
        expectedTreeNodes.put("b", Lists.newArrayList());
        expectedTreeNodes.put("c", Lists.newArrayList("d"));
        expectedTreeNodes.put("d", Lists.newArrayList());

        validateTree(result, expectedTreeNodes);
        assertTrue(expectedTreeNodes.isEmpty());
    }

    static class TreeNodeComparator implements Comparator<TreeNode> {
        public int compare(final TreeNode a, final TreeNode b) {
            return a.id.compareTo(b.id);
        }
    }

    private static void validateTree(final TreeNode node, final Map<String, List<String>> expectedTreeNodes) {
        node.childNodes.sort(new TreeNodeComparator());
        final List<String> expectedIDs = expectedTreeNodes.remove(node.id);
        Collections.sort(expectedIDs);

        assertEquals(expectedIDs.size(), node.childNodes.size());

        for (int i = 0; i < expectedIDs.size(); i++) {
            final TreeNode n = node.childNodes.get(i);
            assertEquals(n.id, expectedIDs.get(i));
            validateTree(n, expectedTreeNodes);
        }

    }
}