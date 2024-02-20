// Curly braces can be used in programming to provide scope-limit. Write a function to print all valid( properly opened and closed) combinations of n-pairs of curly braces.
// Example:
// input: 1 output: {}
// input: 2 output: {}{}, {{}}
// input: 3 output: {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}

package me.toddlasley.questions.interviews.arraysandstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CurlyBraceCombinations {


    public static void main(String[] args) {
        System.out.println(solution(3).size());
//        System.out.println(solution(3).get(0));
//        System.out.println(solution(3).get(1));
    }

    public static Set<String> solution(int n) {
        //    final List<String> result = new ArrayList<>();
        //    final StringBuilder sb = new StringBuilder();
        //    for (int i = 0; i < n; i++) {
        //        sb.append("{}");

        //    }

        //    result.add(sb.toString());

        //    String outward = "";

        //    for (int i = 0; i < n; i++) {
        //        outward = "{" + outward + "}";
        //    }

        //    result.add(outward);

        //    return result;

        final Set<String> result = new HashSet<>();
        result.add("{}");

        for (int i = 0; i < n; i++) {
            solutionHelper(result);
        }

        return result;
    }

    private static void solutionHelper(final Set<String> result) {

        List<String> temp = new ArrayList<>();

        for(String x : result) {
            String sequence = x + "{}";

            String outward = "{" + x + "}";

            String ahead = "{}" + x;

            String behind = x + "{}";

            temp.add(sequence);
            temp.add(outward);
            temp.add(ahead);
            temp.add(behind);
        }

        result.clear();

        result.addAll(temp);
    }

//    private static void solutionHelper(int n, final List<String> result) {
//        if (n == 0) {
//            return;
//        }

//        List<String> temp = new ArrayList<>();

//        for (int i = 0; i < result.size(); i++) {
//            String x = result.get(i);

//            String sequence = x + "{}";

//            String outward = "{" + x + "}";

//            String ahead = "{}" + x;

//            String behind = x + "{}";

//            temp.add(sequence);
//            temp.add(outward);
//            temp.add(ahead);
//            temp.add(behind);
//        }

//        result.clear();

//        result.addAll(temp);

//        solutionHelper(n--, result);
//    }
}
