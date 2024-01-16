package com.ahq.globals;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;


import java.time.Duration;
import java.util.Objects;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class D365Global {
    static String d365Global_input_text_select_all_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.text.select_all.wait"),"d365Global.input.text.select_all.wait") && !getBundle().getPropertyValue("d365Global.input.text.select_all.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.text.select_all.wait") : "2000";
    static String d365Global_input_date_double_click_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.double_click.wait"),"d365Global.input.date.double_click.wait") && !getBundle().getPropertyValue("d365Global.input.date.double_click.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.double_click.wait") : "2000";
    static String d365Global_input_date_select_all_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.select_all.wait"),"d365Global.input.date.select_all.wait") && !getBundle().getPropertyValue("d365Global.input.date.select_all.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.select_all.wait") : "2000";
    static String d365Global_input_date_fill_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.fill.wait"),"d365Global.input.date.fill.wait") && !getBundle().getPropertyValue("d365Global.input.date.fill.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.fill.wait") : "2000";
    static String d365Global_input_lookup_select_type = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type"),"d365Global.input.lookup.select.type") && !getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().isEmpty() && (Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase(),"click") || Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase(),"keys")))? getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase() : "click";
    static String d365Global_input_lookup_load_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.load.wait"),"d365Global.input.lookup.load.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.load.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.load.wait") : "2000";
    static String d365Global_input_lookup_select_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.wait"),"d365Global.input.lookup.select.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.select.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.select.wait") : "2000";
    static String d365Global_input_lookup_clear_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.clear.wait"),"d365Global.input.lookup.clear.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.clear.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.clear.wait") : "2000";

    /**
     * @param text [text to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input Text:{0} Field:{1} Page:{2}")
    public static void inputText(String text,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_input",field));
        BrowserGlobal.iClickOn(loc.get(page,"d365_input",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(text,loc.get(page,"d365_input",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Date Text:{0} Field:{1} Page:{2}")
    public static void inputDate(String date,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_date",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_date",field));
        BrowserGlobal.iClickOn(loc.get(page,"d365_date",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_double_click_wait);
        BrowserGlobal.iClickOn(loc.get(page,"d365_date",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_fill_wait);
        BrowserGlobal.iInputInTo(date,loc.get(page,"d365_date",field));
    }

    /**
     * @param time [time to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Time Text:{0} Field:{1} Page:{2}")
    public static void inputTime(String time,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_time",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_time",field));
        BrowserGlobal.iClickOn(loc.get(page,"d365_time",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(time,loc.get(page,"d365_time",field));
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void inputLookUp(String text, String field, String page) throws Exception {
//        if (!field.contains(", Lookup")) {
//            field = field +", Lookup";
//        }
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_lookup",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_lookup",field));
        BrowserGlobal.iClickOn(loc.get(page,"d365_lookup",field));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, loc.get(page,"d365_lookup",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_link",text));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(loc.get(page,"text",text));
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }
//    /**
//     * Clearing Existing value by name in Lookup ad then enter
//     * Note: Should know existing value
//     * @param text [text to be entered in lookup]
//     * @param clear_value [Existing Value to clear in lookup]
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Input-Lookup Text:{0} By-Clearing-Value:{1} Field:{2} Page:{3}")
//    public static void inputLookUpByClearingValue(String text, String clear_value, String field, String page) throws Exception {
////        String splitFields[];
////        String delField = field.replace(", Lookup","");
////        if (field.contains(":")) {
////            splitFields = field.split(":");
////            delField = clear_value.replace(", Lookup","");
////        }
////        clear_value = clear_value.replace(", Lookup","");
//        if (!field.contains(", Lookup")) { field = field +", Lookup"; }
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"lookup",field));
//        BrowserGlobal.iClickOn("xpath=(//*[@title='"+clear_value+"'])[2]");
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_clear_wait);
//        BrowserGlobal.iClickOn(loc.get(page,"d365_lookup","Delete"));
//        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iPressControlOrCommandAByOs();
//        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iInputInTo(text, loc.get(page,"d365_lookup",field));
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_link",text));
//        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
//            BrowserGlobal.iClickOn(loc.get(page,"text",text));
//        } else {
//            BrowserGlobal.iPressKey("ARROW_DOWN");
//            BrowserGlobal.iWaitForMilliseconds("1000");
//            BrowserGlobal.iPressReturnOrEnterKey();
//        }
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
//    }

    /**
     * Clearing Existing value by name in Lookup ad then enter
     * Note: Should know existing value
     * @param text [text to be entered in lookup]
     * @param clear_value [Existing Value to clear in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Lookup Text:{0} By-Clearing-Value:{1} Field:{2} Page:{3}")
    public static void inputLookUpByClearingValue(String text, String clear_value, String field, String page) throws Exception {
        String splitFields[];
        String delField = field.replace(", Lookup","");
        if (field.contains(":")) {
            splitFields = field.split(":");
            delField = splitFields[0].replace(", Lookup","");
        }
        if (!field.contains(", Lookup")) { field = field +", Lookup"; }
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn("xpath=(//*[@title='"+delField+"'])[2]");
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_clear_wait);
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete"));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_link",text));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }

//    /**
//     * @param keyword [Keyword to fill]
//     * @param instance [Instance of Keyword field]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Input-Filter-Keyword Text:{0} Instance:{1}")
//    public static void inputFilterKeyword(String keyword, String instance) throws Exception {
//        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
//
//        BrowserGlobal.iWaitUntilElementPresent(loc.get());
//        BrowserGlobal.iScrollToAnElement(loc);
//        BrowserGlobal.iClickOn(loc);
//        BrowserGlobal.iInputInTo(keyword,loc);
//        BrowserGlobal.iPressReturnOrEnterKey();
//    }


    /**
     * @param menu_text [Menu Text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Menu Text:{0}")
    public static void clickMenuWithText(String menu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_link",menu_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","d365_link",menu_text));
        BrowserGlobal.iClickOn(loc.get("menu","d365_link",menu_text));
    }


    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Menu-Button Text:{0}")
    public static void clickMenuButtonWithText(String button_text) throws Exception {
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_button",button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","d365_button",button_text));
        BrowserGlobal.iWaitUntilElementEnabled(loc.get("menu","d365_button",button_text));
        try {
            BrowserGlobal.iClickOn(loc.get("menu","d365_button",button_text));
        } catch (Exception e) {
            BrowserGlobal.iWaitForMilliseconds("5000");
            BrowserGlobal.iClickOn(loc.get("menu","d365_button",button_text));
        }
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Popup-Button Text:{0}")
    public static void clickPopupButton(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("popup","d365_button_popup",button_text));
        BrowserGlobal.iClickOn(loc.get("popup","d365_button_popup",button_text));
    }

    /**
     * @param tab_text [Tab text/name to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Tab Text:{0}")
    public static void clickTabWithText(String tab_text) throws Exception {
        try{
            BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_tab",tab_text));
            BrowserGlobal.iScrollToAnElement(loc.get("menu","tab",tab_text));
            BrowserGlobal.iClickOn(loc.get("menu","tab",tab_text));
        } catch(Exception e) {
            BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_tab","More Tabs"));
            BrowserGlobal.iClickOn(loc.get("menu","d365_tab","More Tabs"));
            BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_tab",tab_text));
            BrowserGlobal.iScrollToAnElement(loc.get("menu","tab",tab_text));
            BrowserGlobal.iClickOn(loc.get("menu","tab",tab_text));
        }
    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Link Text:{0}")
    public static void clickLinkWithText(String link_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("general","d365_link",link_text));
        BrowserGlobal.iScrollToAnElement(loc.get("general","d365_link",link_text));
        BrowserGlobal.iClickOn(loc.get("general","d365_link",link_text));
    }
    /**
     * @param mainMenu_text [Main Menu Text/name to be clicked]
     * @param subMenu_text [Sub Menu Text/name to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Main-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickMainAndSubMenu(String mainMenu_text,String subMenu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_link",mainMenu_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","d365_link",mainMenu_text));
        BrowserGlobal.iClickOn(loc.get("menu","d365_link",mainMenu_text));
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_link",subMenu_text));
        BrowserGlobal.iClickOn(loc.get("menu","d365_link",subMenu_text));
    }

    /**
     * @param main_button_text [Main Button Text/Name]
     * @param sub_button_text [Sub Button Text/Name]
     */
    @QAFTestStep(description = "D365Global: Click-Main-Menu-Button Text:{0} Then-Sub-Menu-Button Text:{1}")
    public static void clickMainAndSubMenuButton(String main_button_text,String sub_button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_button",main_button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","d365_button",main_button_text));
        BrowserGlobal.iClickOn(loc.get("menu","d365_button",main_button_text));
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","d365_button",sub_button_text));
        BrowserGlobal.iClickOn(loc.get("menu","d365_button",sub_button_text));
    }

    /**
     * @param main_button_name [Main Menu name]
     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
     * @param sub_button_name [Sub Menu name]
     */
    @QAFTestStep(description = "D365Global: Click-Main-Menu-Button Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
    public static void clickMainAndSubMenuButtonWithWaitInSecs(String main_button_name,String wait_in_secs, String sub_button_name) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_name));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_name));
        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_name));
        BrowserGlobal.iWaitForSeconds(wait_in_secs);
        BrowserGlobal.iClickOn(loc.get("menu","button",sub_button_name));
    }

    /**
     * @param dropdown_Text [Text to be selected in dropdown]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Select Text:{0} Field:{1} Page:{2}")
    public static void selectByText(String dropdown_Text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
        BrowserGlobal.iSelectDropdownWithText(loc.get(page,"d365_select",field),dropdown_Text);
    }

    /**
     * @param dropdown_Text_Index [Index of the Text to be selected in dropdown starting with 0]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Select Index:{0} Field:{1} Page:{2}")
    public static void selectByIndex(String dropdown_Text_Index, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
        BrowserGlobal.iSelectDropdownWithIndex(loc.get(page,"d365_select",field),dropdown_Text_Index);
    }

    /**
     * @param multiple_dropdown_Text [Multiple value separated by comma]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Select-Multiple Text:{0} Field:{1} Page:{2}")
    public static void selectMultipleByText(String multiple_dropdown_Text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iClickOn(loc.get(page,"select",field));
        BrowserGlobal.iWaitForMilliseconds("1000");
        BrowserGlobal.iClickOn("xpath=//button[@aria-label='Toggle menu']");
        BrowserGlobal.iWaitForMilliseconds("1000");
        String[] dropdownText = multiple_dropdown_Text.split(",");
        for (String selected_text : dropdownText) {
            BrowserGlobal.iClickOn("xpath=//label[@title='"+selected_text+"']");
            BrowserGlobal.iWaitForMilliseconds("500");
        }
        BrowserGlobal.iClickOn("xpath=//button[@aria-label='Toggle menu']");
    }

    // ============= TABLE / GRID ==============
    /**
     * @param text [Keyword / Search text to fill]
     */
    @QAFTestStep(description = "D365Global: Table-Input-Filter Text:{0} Page:{1}")
    public static void tableInputFilter(String text, String page) throws Exception {
//        String loc = "xpath=(//input[@placeholder='Filter by keyword'])[1]";
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_filter","1"));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_filter","1"));
        BrowserGlobal.iClickOn(loc.get(page,"d365_filter","1"));
        BrowserGlobal.iInputInTo(text,loc.get(page,"d365_filter","1"));
        BrowserGlobal.iPressReturnOrEnterKey();
    }

    /**
     * Note: To be used if multiple Tables are in single page
     * @param text [Keyword / Search text to fill]
     * @param instance [Instance of Keyword field]
     */
    @QAFTestStep(description = "D365Global: Table-Input-Filter Text:{0} By-Instance:{1} Page:{2}")
    public static void tableInputFilterByInstance(String text, String instance, String page) throws Exception {
//        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_filter",instance));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_filter",instance));
        BrowserGlobal.iClickOn(loc.get(page,"d365_filter",instance));
        BrowserGlobal.iInputInTo(text,loc.get(page,"d365_filter",instance));
        BrowserGlobal.iPressReturnOrEnterKey();
    }
    /**
     * Note: To be used if multiple Tables are in single page.
     * This will select particular table to do other operations
     * @param instance [Instance of Table to be selected]
     */
    @QAFTestStep(description = "D365Global: Table-Select By-Instance:{0}")
    public static void tableSelectByInstance(String instance) throws Exception {
        String locator_1 = "xpath=(//button[@aria-label='More commands for Task'])["+instance+"]";
        String locator_2 = "xpath=//button[@aria-label='See all records']";
        BrowserGlobal.iWaitUntilElementPresent(locator_1);
        BrowserGlobal.iScrollToAnElement(locator_1);
        BrowserGlobal.iClickOn(locator_1);
        BrowserGlobal.iWaitUntilElementPresent(locator_2);
        BrowserGlobal.iClickOn(locator_2);
    }

    //    /**
//     * @param main_button_name [Main Menu name]
//     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
//     * @param sub_button_name [Sub Menu name]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Click-Table-Row Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
//    public static void clickMainAndSubMenuButtonWithWaitInSecs(String main_button_name,String wait_in_secs, String sub_button_name) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iWaitForSeconds(wait_in_secs);
//        BrowserGlobal.iClickOn(loc.get("menu","button",sub_button_name));
//    }

    // ============= VERIFY ==============
    /**
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "D365Global: Wait-And-Verify-Page-Header Text:{0} Page:{1}")
    public static void waitAndVerifyPageHeader(String header_text,String page) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_header",header_text));
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_header",header_text));
        BrowserGlobal.iAssertTitlePartialText(header_text);
    }

    /**
     * @param text [text to verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Value Text:{0} Field:{1} Page:{2}")
    public static void verifyInputValue(String text,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_input",field));
        BrowserGlobal.iAssertElementValue(loc.get(page,"d365_input",field),text);
    }
    /**
     * @param date [Date to Verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Date Text:{0} Field:{1} Page:{2}")
    public static void verifyInputDate(String date,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_date",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_date",field));
        BrowserGlobal.iAssertElementValue(loc.get(page,"d365_date",field),date);
    }

    /**
     * @param lookup_text [Lookup text to be verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void verifyInputLookUp(String lookup_text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_lookup_ext_value",field+":"+lookup_text));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_lookup_ext_value",field+":"+lookup_text));
        BrowserGlobal.iAssertElementText(loc.get(page,"d365_lookup_ext_value",field+":"+lookup_text),lookup_text);
    }

    /**
     * @param dropdown_Text [Text to be Verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Select Text:{0} Field:{1} Page:{2}")
    public static void verifySelectText(String dropdown_Text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
        BrowserGlobal.iAssertElementPresent("xpath=//select[@aria-label='"+field+"'][@title='"+dropdown_Text+"']");
    }

    /**
     * @param error_Text [error_Text to be Verified]
     */
    @QAFTestStep(description = "D365Global: Verify-Error Text:{0} Page:{1}")
    public static void verifyErrorText(String error_Text, String page) throws Exception {
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_error_text",error_Text));
//        BrowserGlobal.iAssertElementPresent("xpath=//span[contains(@id,'error-message')][contains(text(),'"+error_Text.trim()+"']");
    }
    /**
     * @param header_control_list_text [Header Control List Test (Top Right) to be Verified]
     */
    @QAFTestStep(description = "D365Global: Verify-Header-Control-List Text:{0} Page:{1}")
    public static void verifyHeaderControlList(String header_control_list_text, String page) throws Exception {
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_header_control_list",header_control_list_text));
    }

    /**
     * @param header_text [Header text to be Verified]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Header Text:{0} Column:{1} Page:{2}")
    public static void verifyTableHeaderText(String header_text, String column_number, String page) throws Exception, InterruptedException{
        int colNum = Integer.parseInt(column_number) + 1;
        for (int i = 0; i < 25; i++) {
            try {
                BrowserGlobal.iWaitUntilElementPresentWithTimeout(loc.get(page,"d365_table_header",header_text+":"+colNum),"2");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
            }
        }
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header",header_text+":"+colNum));
    }

    /**
     * @param header_text_all [Header text delimited by comma to be Verified Eg. "Id,Status,Address"]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Header-All Text:{0} Page:{1}")
    public static void verifyTableHeaderAll(String header_text_all, String page) throws Exception {
        String[] splitHeaderNames = header_text_all.split(",");
        int colNum = 1;
        for ( String tableHeaderName : splitHeaderNames )
        {
            colNum = colNum + 1;
            for (int i = 0; i < 3; i++) {
                try {
                    BrowserGlobal.iWaitUntilElementPresentWithTimeout(loc.get(page,"d365_table_header",tableHeaderName+":"+colNum),"2");
                    break;
                } catch (Exception e) {
                    BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
                }
            }
            BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header",tableHeaderName+":"+colNum));
        }
    }

    /**
     * @param header_text [Header text to be Verified]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Header-By-Edit-Column Text:{0} Column:{1} Page:{2}")
    public static void verifyTableHeaderByEditColumn(String header_text, String column_number, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_button","Add columns"));
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",header_text+":"+column_number));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Close"));
    }

    /**
     * @param header_text_all [Header text delimited by comma to be Verified Eg. "Id,Status,Address"]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Header-All-By-Edit-Column Text:{0} Page:{1}")
    public static void verifyTableHeaderAllByEditColumn(String header_text_all, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_button","Add columns"));

        String[] splitHeaderNames = header_text_all.split(",");
        int colNum = 0;
        for ( String tableHeaderName : splitHeaderNames )
        {
            colNum = colNum + 1;
            BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",tableHeaderName+":"+colNum));
        }
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Close"));
    }

    /**
     * @param cell_value [cell value to be Verified]
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Cell-Value Text:{0} Row:{1} Column:{2} Page:{3}")
    public static void verifyTableCellValue(String cell_value, String row_number, String column_number, String page) throws Exception {
//        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_header_control_list",header_control_list_text));
    }


    /**
     * @param scroll_value [Scroll Value from the Visible Field]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Scroll Value:{0} From-Visible Field:{1} Page:{2}")
    public static void scrollFromVisibleField(String scroll_value, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"general",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"general",field));
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        QAFWebElement point = new QAFExtendedWebElement(loc.get(page,"general",field));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(point);
        new Actions(driver).scrollFromOrigin(scrollOrigin,0 , Integer.parseInt(scroll_value)).perform();
    }
}
