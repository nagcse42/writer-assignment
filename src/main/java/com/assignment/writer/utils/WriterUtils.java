package com.assignment.writer.utils;

import com.assignment.writer.common.WriterCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterUtils {
    static String STUPID_REPLACER = "s!!!!!";
    static String STUPID_STR = "stupid";

    private static String toLowerCase(String inputString) {
        return inputString.toLowerCase();
    }

    private static String toUpperCase(String inputString) {
        return inputString.toUpperCase();
    }

    private static String removeString(String inputString) {
        return inputString.replaceAll(STUPID_STR, STUPID_REPLACER);
    }

    private static String removeConsecutiveDuplicate(String inputString) {
        Pattern p = Pattern.compile("(?i)(\\b\\w+\\b)(.*?) \\b\\1\\b");
        Matcher m = p.matcher(inputString);
        while (m.find()) {
            inputString = m.replaceAll("$1$2");
            m = p.matcher(inputString);
        }

        return inputString;
    }

    public static String processesInput(String inputString,
                                        WriterCase stringCase, boolean replaceStupid,
                                        boolean removeConsecutiveDuplicate) {
        if(removeConsecutiveDuplicate) {
            inputString = removeConsecutiveDuplicate(inputString);
        }

        if(replaceStupid) {
            inputString = removeString(inputString);
        }

        if(WriterCase.CASE_LOWER == stringCase) {
            inputString = toLowerCase(inputString);
        } else if(WriterCase.CASE_UPPER == stringCase){
            inputString = toUpperCase(inputString);
        }

        return inputString;
    }
}