package com.automation.qa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class StringUtils {

    public static String getTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toCamelCaseIdentifier(String formStr) {
        StringBuffer res = new StringBuffer();

        formStr = formStr.replaceAll("\\{(\\d)*(\\s)*\\}", "");
        String[] strArr = formStr.split("\\W");
        int i = 0;
        for (String str : strArr) {
            if (str.trim().length() > 0) {
                char[] stringArray = str.trim().toCharArray();
                if (i == 0)
                    stringArray[0] = Character.toLowerCase(stringArray[0]);
                else stringArray[0] = Character.toUpperCase(stringArray[0]);
                str = new String(stringArray);

                res.append(str);
            }
            i++;
        }
        return res.toString().trim();
    }

    public static String getRandomString(String format) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < format.length(); i++) {
            char c = format.charAt(i);
            char a = Character.isDigit(c) ? RandomStringUtils.randomNumeric(1).charAt(0)
                    : Character.isLetter(c) ? RandomStringUtils.randomAlphabetic(c).charAt(0) : c;
            sb.append(a);
        }
        return sb.toString();
    }

}
