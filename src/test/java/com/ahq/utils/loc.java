package com.ahq.utils;

import com.ahq.globals.BrowserGlobal;
import org.apache.commons.text.CaseUtils;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class loc {
    /**
     * @param page      [Page of the locator]
     * @param fieldType [“input”, “link”, “text”, “radioButton”, “checkbox”, “select”, “button”, "tab"]
     * @param fieldName [Field Name: Eg: First Name]
     * @return
     * @throws Exception
     */
    public static String get(String page, String fieldType, String fieldName) throws Exception{
        String locator;
        String locVal;
//        System.out.println("== fieldName ==> " + fieldName);
        if (fieldName.contains(":")) {
            String[] fieldSplit = fieldName.split(":");

            locator = "loc." + CaseUtils.toCamelCase(page.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(fieldType.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(fieldSplit[0].replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
            locVal = getBundle().getPropertyValue(locator);
            if (locator.equals(locVal) || locVal.length() < 5) {
                if (fieldSplit.length == 3) {
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[2].trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                    System.out.println("==== AUTO GENERATED LOCATOR [1] ====> " + locator + "=" + getBundle().getPropertyValue(locator));
                } else {
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[0].trim()+"']\",\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[0].trim().toLowerCase()+"']\"],\"desc\":\""+fieldName+" field\"}");
                    System.out.println("==== AUTO GENERATED LOCATOR [2] ====> " + locator + "=" + getBundle().getPropertyValue(locator));
                }
            }
        } else {
            locator = "loc." + CaseUtils.toCamelCase(page.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(fieldType.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(fieldName.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
            locVal = getBundle().getPropertyValue(locator);
            if (locator.equals(locVal) || locVal.length() < 5) {
                getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@aria-label='"+fieldName.trim()+"']\",\"xpath=//*[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//*[@title='"+fieldName.trim()+"']\",\"xpath=//*[@placeholder='"+fieldName.trim()+"']\",\"xpath=//*[@value='"+fieldName.trim()+"']\",\"id="+fieldName.replaceAll("\\s+","").toLowerCase()+"\",\"name="+fieldName.replaceAll("\\s+","").toLowerCase()+"\"],\"desc\":\""+fieldName+" field\"}");
                System.out.println("==== AUTO GENERATED LOCATOR [3]====> " + locator + "=" + getBundle().getPropertyValue(locator));
            }
        }
        return locator;
    }
}