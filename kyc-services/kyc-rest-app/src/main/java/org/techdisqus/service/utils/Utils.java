package org.techdisqus.service.utils;

import java.util.Map;

public class Utils {

    public static boolean doFuzzyMatch(String currentName, String actualName, Map<String, String> reqInfo) {
        currentName = currentName.replace(" ", "").toLowerCase();
        actualName = actualName.replace(" ","").toLowerCase();

        return true;
    }
}
