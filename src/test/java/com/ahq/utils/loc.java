package com.ahq.utils;

import org.apache.commons.text.CaseUtils;


public class loc {
    /**
     * @param page      [Locator page]
     * @param fieldType [Locator Type]
     * @param fieldName [Locator Name]
     * @return
     * @throws Exception
     */
    public static String get(String page, String fieldType, String fieldName) {
        return "loc." + CaseUtils.toCamelCase(page.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(fieldType.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(fieldName.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
    }
}
