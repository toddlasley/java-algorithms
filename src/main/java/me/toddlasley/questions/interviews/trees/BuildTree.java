package me.toddlasley.questions.interviews.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildTree {
    public static class TreeNodeInput {
        public String id;
        public List<String> children;

        public TreeNodeInput(final String id) {
            this.id = id;
            this.children = new ArrayList<>();
        }

        public TreeNodeInput(final String id, final List<String> children) {
            this.id = id;
            this.children = children == null ? new ArrayList<>() : children;
        }
    }

    public static class TreeNode extends TreeNodeInput {
        public List<TreeNode> childNodes;

        public TreeNode(final TreeNodeInput input) {
            super(input.id, input.children);
            this.childNodes = new ArrayList<>();
        }
    }

    public static TreeNode buildWithoutRootIndicator(final List<TreeNodeInput> nodes) throws Exception {
        TreeNode root = null;
        final Set<String> nodeSet = new HashSet<>();
        final List<String> children = new ArrayList<>();
        final Map<String, TreeNode> nodeLookup = new HashMap<>();

        for (TreeNodeInput node : nodes) {
            nodeLookup.put(node.id, new TreeNode(node));
            nodeSet.add(node.id);
            children.addAll(node.children);
        }

        for (String child : children) {
            nodeSet.remove(child);
        }

        root = new TreeNode(lookupNode((String)nodeSet.toArray()[0], nodeLookup));

        for (String s : root.children) {
            final TreeNode node = lookupNode(s, nodeLookup);
            root.childNodes.add(buildHelper(node, nodeLookup));
        }

        return root;
    }

    public static TreeNode build(final List<TreeNodeInput> nodes) throws Exception {
        TreeNode root = null;
        final Map<String, TreeNode> nodeLookup = new HashMap<>();

        for (TreeNodeInput input : nodes) {
            if (input.id.equals("root")) {
                root = new TreeNode(input);
            } else {
                nodeLookup.put(input.id, new TreeNode(input));
            }
        }

        for (String id : root.children) {
            root.childNodes.add(buildHelper(nodeLookup.get(id), nodeLookup));
        }

        return root;
    }

    private static TreeNode buildHelper(final TreeNode node, final Map<String, TreeNode> nodeLookup) throws Exception {
        for (String id : node.children) {
            node.childNodes.add(buildHelper(lookupNode(id, nodeLookup), nodeLookup));
        }

        return node;
    }

    private static TreeNode lookupNode(final String id, final Map<String, TreeNode> nodeLookup) throws Exception {
        final TreeNode node = nodeLookup.get(id);

        if (node == null) {
            throw new Exception(String.format("Missing tree node: %s", id));
        } else {
            return node;
        }
    }
}
