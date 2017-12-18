package it.scp.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromeChecker {

    private String stringa;

    PalindromeChecker(String stringa) {
        this.stringa = stringa;
    }

    public boolean isPalindrome() {
        boolean result = true;
        for (int i = 0; i < this.stringa.length() / 2; i++) {
            char c1 = this.stringa.charAt(i);
            char c2 = this.stringa.charAt(this.stringa.length() - 1 - i);
            System.out.println("Confronto " + c1 + " con " + c2);
            if (c1 != c2) {
                result = false;
                break;
            }
        }

        return result;
    }

    public void foo(String s) { System.out.println("String");
    }
    public void foo(StringBuffer sb){ System.out.println("StringBuffer");
    }

}
