package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void groupAnagramsSuccessfullyGroupsAnagramsTogether() {
        String[] array = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List list = GroupAnagrams.groupAnagrams(array);

        assertEquals(3, list.size());

        List list0 = (List)list.get(0);
        List list1 = (List)list.get(1);
        List list2 = (List)list.get(2);

        for ( int i = 0; i < list.size(); i++ ) {
            List l = (List) list.get(i);

            boolean assertion = ( l.contains("bat") && l.size() == 1 )
                    || ( l.contains("tan") && l.contains("nat") && l.size() == 2 )
                    || ( l.contains("eat") && l.contains("tea") && l.contains("ate") && l.size() == 3 );

            assertTrue(assertion);
        }
    }
}