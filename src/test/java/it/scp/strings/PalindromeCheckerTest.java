package it.scp.strings;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.*;

public class PalindromeCheckerTest {

    @Test
    public void isPalindromeTest() {

        PalindromeChecker palindromeChecker = new PalindromeChecker("carlo");
        assertFalse(palindromeChecker.isPalindrome());

        PalindromeChecker palindromeChecker2 = new PalindromeChecker("anna");
        assertTrue(palindromeChecker2.isPalindrome());

        PalindromeChecker palindromeChecker3 = new PalindromeChecker("ossesso");
        assertTrue(palindromeChecker3.isPalindrome());

    }

    @Test
    public void testC() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("uno", "uno");
        map.put("due", "due");
        map.put("tre", "tre");
        map.put("quattro", "quattro");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Chiave: " + entry.getKey() + " valore: " + entry.getValue());
        }

        Map<String, String> map3 = new TreeMap<>();
        map3.put("uno", "uno");
        map3.put("due", "due");
        map3.put("tre", "tre");
        map3.put("quattro", "quattro");

        Set<Map.Entry<String, String>> entries3 = map3.entrySet();
        for (Map.Entry<String, String> entry : entries3) {
            System.out.println("Chiave3: " + entry.getKey() + " valore3: " + entry.getValue());
        }

        Map<String, String> map2 = new Hashtable<>();
        map2.put("uno", "uno");
        map2.put("due", "due");
        map2.put("tre", "tre");
        map2.put("quattro", "quattro");

        Set<String> entries2 = map2.keySet();
        for (String entry : entries2) {
            System.out.println("Chiave: " + entry);
        }

        Set<GIORNI> giorniSet = EnumSet.allOf(GIORNI.class);
        for (GIORNI giorno : giorniSet) {
            System.out.println(giorno.ordinal() + " " + giorno.name());
        }

    }

    enum GIORNI {
        LUNEDI, MERTEDI, MERCOLEDI;
    }

}
