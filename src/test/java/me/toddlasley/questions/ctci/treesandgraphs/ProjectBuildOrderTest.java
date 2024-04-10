package me.toddlasley.questions.ctci.treesandgraphs;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static me.toddlasley.questions.ctci.treesandgraphs.ProjectBuildOrder.buildOrder;


public class ProjectBuildOrderTest {
    @Test
    public void buildOrderShouldReturnTheCorrectBuildOrder() {
        List<ExpectedDependencyOrder> expected = Lists.newArrayList(
                new ExpectedDependencyOrder(
                        0,
                        1,
                        Sets.newHashSet("e", "f")
                ),
                new ExpectedDependencyOrder(
                        2,
                        3,
                        Sets.newHashSet("b", "a")
                ),
                new ExpectedDependencyOrder(
                        4,
                        4,
                        Sets.newHashSet("d")
                ),
                new ExpectedDependencyOrder(
                        5,
                        5,
                        Sets.newHashSet("c")
                )
        );

        assertBuildOrder(
                expected,
                buildOrder(
                        new String[] {"a", "b", "c", "d", "e", "f"},
                        new String[][]{
                                new String[] {"a", "d"},
                                new String[] {"f", "b"},
                                new String[] {"b", "d"},
                                new String[] {"f", "a"},
                                new String[] {"d", "c"}
                        }
                )
        );

        expected = Lists.newArrayList(
                new ExpectedDependencyOrder(
                        0,
                        1,
                        Sets.newHashSet("f", "d")
                ),
                new ExpectedDependencyOrder(
                        2,
                        4,
                        Sets.newHashSet("c", "b", "g")
                ),
                new ExpectedDependencyOrder(
                        5,
                        5,
                        Sets.newHashSet("a")
                ),
                new ExpectedDependencyOrder(
                        6,
                        6,
                        Sets.newHashSet("e")
                )
        );

        assertBuildOrder(
                expected,
                buildOrder(
                        new String[] {"a", "b", "c", "d", "e", "f", "g"},
                        new String[][]{
                                new String[] {"f", "b"},
                                new String[] {"b", "a"},
                                new String[] {"f", "c"},
                                new String[] {"c", "a"},
                                new String[] {"a", "e"},
                                new String[] {"d", "g"},
                                new String[] {"f", "a"},
                                new String[] {"b", "e"},
                        }
                )
        );
    }

    private static class ExpectedDependencyOrder {
        public int start;
        public int end;
        public Set<String> dependencies;

        public ExpectedDependencyOrder(final int start, final int end, final Set<String> dependencies) {
            if (end < start) {
                throw new IllegalArgumentException("end must be greater than or equal to start");
            }

            final int rangeSize = end - start + 1;
            if (dependencies.size() != rangeSize) {
                throw new IllegalArgumentException(
                        String.format(
                                "dependencies size (%d) does not equal range size (%d)",
                                dependencies.size(),
                                rangeSize)
                );
            }

            this.start = start;
            this.end = end;
            this.dependencies = dependencies;
        }
    }

    private static void assertBuildOrder(final List<ExpectedDependencyOrder> expected, final List<String> actual) {
        for (ExpectedDependencyOrder e : expected) {
            for (int i = e.start; i <= e.end; i++) {
                assertTrue(e.dependencies.contains(actual.get(i)));
            }
        }
    }
}