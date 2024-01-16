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
        if (fieldName.contains(":") && !fieldType.contains("d365_")) {
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
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//a[@aria-label='"+fieldName.trim()+"']\",\"xpath=//a[@title='"+fieldName.trim()+"']\",\"xpath=//li[@aria-label='"+fieldName.trim()+"']\",\"xpath=//li[@title='"+fieldName.trim()+"']\",\"xpath=//a[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//a[contains(@title,'"+fieldName.trim()+"')]\",\"xpath=//li[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//li[contains(@title,'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_header")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//h1[@title='"+fieldName.trim()+"']\",\"xpath=//div[@aria-label='"+fieldName.trim()+"']\",\"xpath=//h1[contains(@title,'"+fieldName.trim()+"')]\",\"xpath=//div[contains(@aria-label,'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_date")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='Date of "+fieldName.trim()+"']\",\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_time")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='Time of "+fieldName.trim()+"']\",\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                }else if (fieldType.trim().equalsIgnoreCase("d365_input")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_lookup")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//input[@aria-label='"+fieldName.trim()+", Lookup']\",\"xpath=//input[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_lookup_ext_value")){
                    String[] lookupfieldSplit = fieldName.trim().split(":");
                    String[] lookupfieldNameSplit = lookupfieldSplit[0].trim().replaceAll(" ","_").split("_");
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//div[contains(@data-id,'fieldControl-LookupResultsDropdown')][@title='"+lookupfieldSplit[1].trim()+"'][contains(@id,'"+lookupfieldNameSplit[0].trim().toLowerCase()+"')]\"],\"desc\":\""+lookupfieldSplit[0]+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_filter")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=(//input[@placeholder='Filter by keyword'])["+fieldName.trim()+"]\",\"xpath=(//*[contains(@data-id,'quickFind_text')])["+fieldName.trim()+"]\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_button")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//button[@aria-label='"+fieldName.trim()+"']\",\"xpath=//button[@title='"+fieldName.trim()+"']\",\"xpath=//button[contains(@title,'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_button_popup")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//div[contains(@id,'dialogView')]/descendant::button[@aria-label='"+fieldName.trim()+"']\",\"xpath=//div[contains(@id,'dialogView')]/descendant::span[text()='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" : Popup button field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_select")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//select[@aria-label='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+" select field\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_header_control_list")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//div[contains(@id ,'headerControlsList')]//descendant::div[text()='"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+": Header Control List Text\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_error_text")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//span[contains(@id,'error-message')][contains(text(),'"+fieldName.trim()+"']\"],\"desc\":\""+fieldName+": Error Message Text\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_show_hide_button")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//i[@title='Show/Hide "+fieldName.trim()+"']\",\"xpath=//i[contains(@title='Show/Hide "+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+": Show Hide Button\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_table_header")){
                    String[] headerElementSplit = fieldName.trim().split(":");
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=((//div[@class='ag-header-container'])[1]/descendant::div[@aria-colindex='"+headerElementSplit[1]+"']/descendant::div[text()='"+headerElementSplit[0]+"'])[1]\"],\"desc\":\""+headerElementSplit[0]+" Table Header\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_table_header_edit_column")){
                    String[] headerElementSplit = fieldName.trim().split(":");
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=(//div[@role='listitem'])["+headerElementSplit[1]+"][@aria-label='"+headerElementSplit[0]+"']/descendant::span[text()='"+headerElementSplit[0]+"']\"],\"desc\":\""+headerElementSplit[0]+" Table Header\"}");
                } else if (fieldType.trim().equalsIgnoreCase("d365_table_horizontal_scroll")){
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=(//div[@class='ag-body-horizontal-scroll-viewport'])[1]\"],\"desc\":\""+fieldName+": Show Hide Button\"}");
                } else{
                    getBundle().setProperty(locator,"{\"locator\":[\"xpath=//*[@aria-label='"+fieldName.trim()+"']\",\"xpath=//*[@title='"+fieldName.trim()+"']\",\"xpath=//*[@placeholder='"+fieldName.trim()+"']\",\"xpath=//*[@value='"+fieldName.trim()+"']\",\"id="+fieldName+"\",\"id="+fieldName.replaceAll("\\s+","").toLowerCase()+"\",\"name="+fieldName.replaceAll("\\s+","").toLowerCase()+"\",\"xpath=//*[contains(@aria-label,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(@title,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(@value,'"+fieldName.trim()+"')]\",\"xpath=//*[contains(text(),'"+fieldName.trim()+"')]\"],\"desc\":\""+fieldName+" field\"}");
                }
                System.out.println("==== AUTO GENERATED LOCATOR [3]====> " + locator + "=" + getBundle().getPropertyValue(locator));
            }
        }
        return locator;
    }
}