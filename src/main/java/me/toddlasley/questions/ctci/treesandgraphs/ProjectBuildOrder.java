package me.toddlasley.questions.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProjectBuildOrder {
    private static class Dependency {
        public String id;
        public int incoming;
        public List<Dependency> adjacent;

        public Dependency(final String id) {
            this.id = id;
            this.incoming = 0;
            this.adjacent = new ArrayList<>();
        }
    }


    public static List<String> buildOrder(final String[] projects, final String[][] dependencies) {
        final Map<String, Dependency> nodes = new HashMap<>();

        for (String s : projects) {
            nodes.put(s, new Dependency(s));
        }

        for (String[] d : dependencies) {
            if (d.length != 2) {
                throw new IllegalArgumentException("dependencies must be an array whose members are array(s) of size 2");
            }

            final Dependency node = nodes.get(d[1]);
            node.incoming++;
            nodes.get(d[0]).adjacent.add(node);
        }

        final Deque<Dependency> toProcess = new LinkedList<>();

        for (Dependency d : nodes.values()) {
            if (d.incoming == 0) {
                toProcess.addLast(d);
            }
        }

        final List<String> result = new ArrayList<>();

        while (!toProcess.isEmpty()) {
            final int n = toProcess.size();

            for (int i = 0; i < n; i++) {
                final Dependency dependency = toProcess.removeFirst();

                result.add(dependency.id);

                for (Dependency d : dependency.adjacent) {
                    d.incoming--;

                    if (d.incoming == 0) {
                        toProcess.addLast(d);
                    }
                }
            }
        }

        return result.size() != projects.length ? null : result;
    }
}
