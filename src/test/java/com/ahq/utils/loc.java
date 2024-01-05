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

            locator = "loc." + CaseUtils.toCamelCase(page.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(fieldType.replaceAll("d365_", "").replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(fieldSplit[0].replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
            locVal = getBundle().getPropertyValue(locator);
            if (locator.equals(locVal) || locVal.length() < 5) {
                if (fieldSplit.length == 3) {
                    locator = "auto."+ locator;
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[2].trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                    System.out.println("==== AUTO GENERATED LOCATOR [1] ====> " + locator + "=" + getBundle().getPropertyValue(locator));
                } else {
                    locator = "auto."+ locator;
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[0].trim()+"']\",\"xpath=//*[@"+fieldSplit[1].trim()+"='"+fieldSplit[0].trim().toLowerCase()+"']\"],\"desc\":\""+fieldName+" field\"}");
                    System.out.println("==== AUTO GENERATED LOCATOR [2] ====> " + locator + "=" + getBundle().getPropertyValue(locator));
                }
            }
        } else {
            locator = "loc." + CaseUtils.toCamelCase(page.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(fieldType.replaceAll("d365_", "").replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(fieldName.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
            locVal = getBundle().getPropertyValue(locator);
            if (locator.equals(locVal) || locVal.length() < 5) {
                locator = "auto."+ locator;
                if (fieldType.trim().equalsIgnoreCase("d365_link") || fieldType.trim().equalsIgnoreCase("d365_tab")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//a[@aria-label='"+fieldName.trim()+"']\",\"xpath=//a[@title='"+fieldName.trim()+"']\",\"xpath=//li[@aria-label='"+fieldName.trim()+"']\",\"xpath=//li[@title='"+fieldName.trim()+"']\",\"xpath=//a[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//a[contains(@title,'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_header")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//h1[@title='"+fieldName.trim()+"']\",\"xpath=//div[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_date")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='Date of "+fieldName.trim()+"']\",\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_input")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_lookup")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='"+fieldName.trim()+", Lookup']\",\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_lookup_ext_value")){
                    String[] lookupfieldSplit = fieldName.split(":");
                    String[] lookupfieldNameSplit = lookupfieldSplit[0].split(" ");
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//div[contains(@data-id\\,'fieldControl-LookupResultsDropdown')][@title='"+lookupfieldSplit[1].trim()+"'][contains(@id\\,'"+lookupfieldNameSplit[0].trim().toLowerCase()+"')]\"],\"desc\":\""+lookupfieldSplit[0]+" field\"}");
                }else if (fieldType.trim().equalsIgnoreCase("d365_filter")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=(//input[@placeholder='Filter by keyword'])["+fieldName.trim()+"]\",\"xpath=(//*[contains(@data-id,'quickFind_text')])["+fieldName.trim()+"]\"],\"desc\":\""+fieldName+" field\"}");
                }else if (fieldType.trim().equalsIgnoreCase("d365_button")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//button[@aria-label='"+fieldName.trim()+"']\",\"xpath=//button[@title='"+fieldName.trim()+"']\",\"xpath=//button[contains(@title,'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                }else{
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@aria-label='"+fieldName.trim()+"']\",\"xpath=//*[@title='"+fieldName.trim()+"']\",\"xpath=//*[@placeholder='"+fieldName.trim()+"']\",\"xpath=//*[@value='"+fieldName.trim()+"']\",\"id="+fieldName.replaceAll("\\s+","").toLowerCase()+"\",\"name="+fieldName.replaceAll("\\s+","").toLowerCase()+"\",\"xpath=//*[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(@title,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(@value,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(text(),'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                }


                System.out.println("==== AUTO GENERATED LOCATOR [3]====> " + locator + "=" + getBundle().getPropertyValue(locator));
            }
        }
        return locator;
    }
}