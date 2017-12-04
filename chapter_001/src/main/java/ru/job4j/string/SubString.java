package ru.job4j.string;

public class SubString {
    boolean contains(String origin, String sub) {
        boolean result = false;
        for (int i = 0; i <= origin.length() - sub.length(); i++) {
            int k = i;
            boolean containsSubstring = true;
            for (int j = 0; j < sub.length(); j++) {
                if (sub.charAt(j) != origin.charAt(k)) containsSubstring = false;
                k++;
            }
            if (containsSubstring) result = containsSubstring;
        }
        return result;
    }
}
