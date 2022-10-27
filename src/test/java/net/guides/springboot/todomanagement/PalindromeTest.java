package net.guides.springboot.todomanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import net.guides.springboot.todomanagement.utility.Palindrome;

public class PalindromeTest {

    @Test
    public void whenEmptyString_thenAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome(""));
    }
}