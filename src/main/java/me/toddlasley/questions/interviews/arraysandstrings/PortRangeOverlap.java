package me.toddlasley.questions.interviews.arraysandstrings;

import java.util.Arrays;
import java.util.Comparator;

public class PortRangeOverlap {
    public static class PortRange {
        public int begin;
        public int end;

        public PortRange(final int begin, final int end) {
            if (begin > end) {
                throw new IllegalArgumentException("begin must be less than or equal to end");
            }

            this.begin = begin;
            this.end = end;
        }
    }

    public static class PortRangeComparator implements Comparator<PortRange> {
        public int compare(final PortRange a, final PortRange b) {
            if (a != null && b != null) {
                return a.begin - b.begin;
            } else if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static boolean hasOverlap(final PortRange[] portRanges) {
        Arrays.sort(portRanges, new PortRangeComparator());

        for (int i = 1; i < portRanges.length; i++) {
            final PortRange x = portRanges[i - 1];
            final PortRange y = portRanges[i];

            if (x != null && y != null && y.begin <= x.end) {
                return true;
            }
        }

        return false;
    }
}
