package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneAwayTest {

    @Test
    public void isStringOneEditAwayDetectsIf2StringsAreOneEditAway() {
        assertTrue( OneAway.isStringOneEditAway("asdf", "asdfe") );
        assertTrue( OneAway.isStringOneEditAway("asdf", "asdq") );
        assertTrue( OneAway.isStringOneEditAway("asdf", "asd") );

        assertFalse( OneAway.isStringOneEditAway("asdf", "asdfff") );
        assertFalse( OneAway.isStringOneEditAway("asdf", "q") );
        assertFalse( OneAway.isStringOneEditAway("asdf", "blueberries") );
    }
}