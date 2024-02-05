package com.ahq.globals;

import com.ahq.addons.d365Loc;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.addons.loc;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;


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

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputText(page,"MAIN",field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputText(page,"main",field));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.inputText(page,"main",field));
        BrowserGlobal.iClickOn(d365Loc.inputText(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(text,d365Loc.inputText(page,"main",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Date Text:{0} Field:{1} Page:{2}")
    public static void inputDate(String date,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputDate(page,"main",field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputDate(page,"main",field));
        BrowserGlobal.iClickOn(d365Loc.inputDate(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_double_click_wait);
        BrowserGlobal.iClickOn(d365Loc.inputDate(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_fill_wait);
        BrowserGlobal.iInputInTo(date,d365Loc.inputDate(page,"main",field));
    }

    /**
     * @param time [time to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Time Text:{0} Field:{1} Page:{2}")
    public static void inputTime(String time,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputTime(page,"main",field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputTime(page,"main",field));
        BrowserGlobal.iClickOn(d365Loc.inputTime(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(time,d365Loc.inputTime(page,"main",field));
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void inputLookUp(String text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iClickOn(d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(page,"dropdown_list",text));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(d365Loc.link(page,"dropdown_list",text));
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
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iClickOn("xpath=(//*[@title='"+delField+"'])[2]");
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_clear_wait);
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete"));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(page,"main",field));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(d365Loc.inputLookup(page,"main",field));
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


//    /**
//     * @param menu_text [Menu Text to be clicked]
//     */
//    @QAFTestStep(description = "D365Global: Click-Menu Text:{0}")
//    public static void clickMenuWithText(String menu_text) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc("menu","link",menu_text));
//        BrowserGlobal.iScrollToAnElement(d365Loc.loc("menu","link",menu_text));
//        BrowserGlobal.iClickOn(d365Loc.loc("menu","link",menu_text));
//    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Popup-Button Text:{0}")
    public static void clickPopupButton(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc("popup","BUTTON_POPUP",button_text));
        BrowserGlobal.iClickOn(d365Loc.loc("popup","BUTTON_POPUP",button_text));
    }

    /**
     * @param tab_text [Tab text/name to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Tab Text:{0} Page:{1}")
    public static void clickTabWithText(String tab_text, String page) throws Exception {
        try{
            BrowserGlobal.iWaitUntilElementPresentWithTimeout(d365Loc.link(page,"tab_list",tab_text),"3");
            BrowserGlobal.iScrollToAnElement(d365Loc.link(page,"tab_list",tab_text));
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.link(page,"tab_list",tab_text),"3");
            BrowserGlobal.iClickOn(d365Loc.link(page,"tab_list",tab_text));
        } catch(Exception e) {
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(page,"tab_list","More Tabs"));
            BrowserGlobal.iClickOn(d365Loc.link(page,"tab_list","More Tabs"));
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.link(page,"tab_dropdown",tab_text),"5");
//            BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc(page,"TAB",tab_text));
            BrowserGlobal.iScrollToAnElement(d365Loc.link(page,"tab_dropdown",tab_text));
            BrowserGlobal.iClickOn(d365Loc.link(page,"tab_dropdown",tab_text));
        }
    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Link Text:{0} Page:{1}")
    public static void clickLinkWithText(String link_text,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(page,"main",link_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link(page,"main",link_text));
        BrowserGlobal.iClickOn(d365Loc.link(page,"main",link_text));
    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Left-Menu Text:{0}")
    public static void clickLeftMenu(String link_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link("menu","NAV_LEFT",link_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link("menu","NAV_LEFT",link_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","NAV_LEFT",link_text));
    }

    /**
     * @param mainMenu_text [Main Menu Text/name to be clicked]
     * @param subMenu_text [Sub Menu Text/name to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Left-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickLeftMenuAndSubMenu(String mainMenu_text,String subMenu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.link("menu","nav_left",subMenu_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","nav_left",subMenu_text));
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Top-Menu-Button Text:{0} Page:{1}")
    public static void clickTopMenuButton(String button_text, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"menu_top",button_text));
//        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button(page,"menu_top",button_text));
        try {
            BrowserGlobal.iClickOn(d365Loc.button(page,"menu_top",button_text));
        } catch (Exception e) {
            BrowserGlobal.iWaitForMilliseconds("5000");
            BrowserGlobal.iClickOn(d365Loc.button(page,"menu_top",button_text));
        }
    }

    /**
     * @param main_button_text [Main Button Text/Name]
     * @param sub_button_text [Sub Button Text/Name]
     */
    @QAFTestStep(description = "D365Global: Click-Top-Menu-Button Text:{0} Then-Sub-Menu-Button Text:{1} Page:{2}")
    public static void clickTopMenuButtonAndSubMenuButton(String main_button_text,String sub_button_text, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"menu_top",main_button_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"menu_top",main_button_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"menu_top",main_button_text));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"menu_dropdown",sub_button_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"menu_dropdown",sub_button_text));
    }

//    /**
//     * @param main_button_name [Main Menu name]
//     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
//     * @param sub_button_name [Sub Menu name]
//     */
//    @QAFTestStep(description = "D365Global: Click-Main-Menu-Button Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
//    public static void clickMainAndSubMenuButtonWithWaitInSecs(String main_button_name,String wait_in_secs, String sub_button_name) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iWaitForSeconds(wait_in_secs);
//        BrowserGlobal.iClickOn(loc.get("menu","button",sub_button_name));
//    }

    /**
     * @param mainView_text [Main System View Text/name to be clicked]
     * @param subView_text [Sub System View Text/name to be clicked]
     */
    @QAFTestStep(description = "D365Global: Click-Main-System-View Text:{0} Then-Sub-System-View Text:{1} Page:{2}")
    public static void clickMainAndSubSystemView(String mainView_text,String subView_text,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc(page,"SYSTEM_VIEW_LIST",subView_text));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"SYSTEM_VIEW_LIST",subView_text));
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
        String[] tempFieldVal = fieldValueCheck(text);
        text = tempFieldVal[0];
        String instance = (tempFieldVal[1].isEmpty()) ? "::1" : tempFieldVal[1];

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputText(page,"MAIN","Filter by keyword"+instance));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputText(page,"MAIN","Filter by keyword"+instance));
        BrowserGlobal.iClickOn(d365Loc.inputText(page,"MAIN","Filter by keyword"+instance));
        BrowserGlobal.iInputInTo(text,d365Loc.inputText(page,"MAIN","Filter by keyword"+instance));
        BrowserGlobal.iPressReturnOrEnterKey();
        BrowserGlobal.iWaitForMilliseconds("1000");
        BrowserGlobal.iWaitForPageToLoad();
    }

//    /**
//     * Note: To be used if multiple Tables are in single page
//     * @param text [Keyword / Search text to fill]
//     * @param instance [Instance of Keyword field]
//     */
//    @QAFTestStep(description = "D365Global: Table-Input-Filter Text:{0} By-Instance:{1} Page:{2}")
//    public static void tableInputFilterByInstance(String text, String instance, String page) throws Exception {
////        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iClickOn(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iInputInTo(text,loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iPressReturnOrEnterKey();
//    }

    /**
     * Note: To be used if multiple Tables are in single page
     * @param filters [Following parameters: ['<Field>','<Opertor>','<Value/s>'] Eg: ['Allow ECard','Equals','No,Yes'],['Year','Contains data','']"
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Table-Edit-Filter-Delete-All-And-Input-New filters:{0} Page:{1}")
    public static void tableEditFilterDeleteAllAndInputNew(String filters, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"BUTTON","Edit filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"BUTTON","Edit filters"));
//        BrowserGlobal.iWaitUntilElementVisible(d365Loc.tableEditFilterPanelButton(page,"Delete all filters"));
//        BrowserGlobal.iClickOn(d365Loc.tableEditFilterPanelButton(page,"Delete all filters"));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Delete all filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Delete all filters"));
        String[] filterArray = filters.split("],\\[");
        int filterCount = 0;
        for ( String filter : filterArray )
        {
            filterCount = filterCount + 1;
            BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Add new level 1 expression"));
            BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_MENU_LIST","Add row"));
            BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_MENU_LIST","Add row"));

            System.out.println("=========> " + filter.replace("[","").replace("]",""));
            int counter = 0;
            String[] rowFilter = filter.replace("[","").replace("]","").split("','");
            for (String singleFilter : rowFilter)
            {
                counter = counter + 1;
                singleFilter = singleFilter.replace("'","").trim();
                System.out.println("======> " + singleFilter);
                if (counter == 1) {
                    BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_INPUT_INSTANCE","field selector:"+filterCount));
                    BrowserGlobal.iInputInTo(singleFilter,d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_INPUT_INSTANCE","field selector:"+filterCount));
                } else if (counter == 2) {
                    if (singleFilter != null && !singleFilter.equals("")) {
                        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON_INSTANCE","Operator:"+filterCount));
                        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON_INSTANCE","Operator:"+filterCount));
                        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_MENU_LIST",singleFilter));
                        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_MENU_LIST",singleFilter));
                    }
                } else if (counter == 3) {
                    if (singleFilter != null && !singleFilter.equals("")) {
                        String[] valueFilters = singleFilter.replace("'","").split(",");
                        for (String valFilter : valueFilters)
                        {
                            System.out.println("=> " + valFilter);
                            BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_INPUT_INSTANCE","Value:"+filterCount));
                            BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_INPUT_INSTANCE","Value:"+filterCount));
                            BrowserGlobal.iInputInTo(valFilter,d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_INPUT_INSTANCE","Value:"+filterCount));
                            BrowserGlobal.iWaitForSeconds("1");
                            BrowserGlobal.iPressTabKeyTimes("1");
                        }
                    }
                }
            }
        }
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
    }

    /**
     * To reset Table Filters
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Table-Edit-Filter-Reset-To-Default Page:{0}")
    public static void tableEditFilterResetToDefault(String page) throws Exception {
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"BUTTON","Edit filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"BUTTON","Edit filters"));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Clear filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Clear filters"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
    }

    /**
     * Note: To be used if multiple Tables are in single page.
     * This will select particular table to do other operations
     * @param instance [Instance of Table to be selected]
     */
    @QAFTestStep(description = "D365Global: Table-Select By-Instance:{0} Page:{1}")
    public static void tableSelectByInstance(String instance, String page) throws Exception {
        try {
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.button(page,"main","More commands for::"+instance),"3");
//            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE",instance),"3");
        } catch (Exception e) {
            int scrollLength = 250;
            for (int i = 0; i < 10; i++) {
                BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField(Integer.toString(scrollLength), d365Loc.button(page,"main","More commands for::1"));
//                BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField(Integer.toString(scrollLength), d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE","1"));
                BrowserGlobal.iWaitForSeconds("1");
                try {
                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.button(page,"main","More commands for::"+instance),"2");
//                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE",instance),"2");
                    break;
                } catch(Exception e2) { scrollLength = scrollLength + 250; }

            }
        }
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iClickOn(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"menu_dropdown","See all records"));
        BrowserGlobal.iClickOn(d365Loc.button(page,"menu_dropdown","See all records"));
    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param dropdown_text [dropdown /button text  to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365Global: Table-Click-Header Text:{0} Column:{1} Then-Click-Dropdown-Button Text:{2} Page:{3}")
    public static void tableClickHeaderColumnThenClickDropdownButton(String header_column_text,String header_column_number,String dropdown_text, String page) throws Exception {
        int colNum = Integer.parseInt(header_column_number) + 1;
        String tempLoc = d365Loc.scrollHorizontal(page);
        for (int i = 0; i < 10; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableHeader(page,"other",header_column_text+":: ::"+colNum),"2");
//                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"2");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
//                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
            }
        }
        BrowserGlobal.iClickOn(d365Loc.tableHeader(page,"main",header_column_text+":: ::"+colNum));
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"dropdown_table_column",dropdown_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"dropdown_table_column",dropdown_text));
    }

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Double-Click-Table-Cell Row:{0} Column:{1} Page:{2}")
    public static void doubleClickTableCell(String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;
        for (int i = 0; i < 10; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"2");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iMouseoverOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum));
        BrowserGlobal.iDoubleClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum));
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
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Wait-And-Verify-Page-Header Text:{0} Page:{1}")
    public static void waitAndVerifyPageHeader(String header_text,String page) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.systemViewHeader(page,"main", header_text));
        BrowserGlobal.iAssertElementPresent(d365Loc.systemViewHeader(page,"main", header_text));
//        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"HEADER",header_text));
//        BrowserGlobal.iAssertElementPresent(d365Loc.loc(page,"HEADER",header_text));
        BrowserGlobal.iAssertTitlePartialText(header_text);
    }

    /**
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-field-locked Field:{0} Page:{1}")
    public static void verifyFieldLocked(String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.fieldLock(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.fieldLock(page,fieldLoc,field));
        BrowserGlobal.iAssertElementVisible(d365Loc.fieldLock(page,fieldLoc,field));
    }

    /**
     * @param text [text to verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Value Text:{0} Field:{1} Page:{2}")
    public static void verifyInputValue(String text,String field,String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputText(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputText(page,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputText(page,fieldLoc,field),text);

    }
//
//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365Global: Verify-Input-Disabled Field:{0} Page:{1}")
//    public static void verifyInputDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_input",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_input",field));
//        BrowserGlobal.iMouseoverOn(loc.get(page,"d365_input",field));
//        BrowserGlobal.iWaitForSeconds("1");
//        BrowserGlobal.iClickOn(loc.get(page,"d365_input",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_input",field),"readonly");
//    }

    /**
     * @param date [Date to Verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Date Text:{0} Field:{1} Page:{2}")
    public static void verifyInputDate(String date,String field,String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputDate(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputDate(page,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputDate(page,fieldLoc,field),date);
    }

//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365Global: Verify-Input-Date-Disabled Field:{0} Page:{1}")
//    public static void verifyInputDateDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_date",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_date",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_date",field),"disabled");
//    }

    /**
     * @param time [Time to Verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Time Text:{0} Field:{1} Page:{2}")
    public static void verifyInputTime(String time,String field,String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputTime(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputTime(page,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputTime(page,fieldLoc,field),time);
    }

//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365Global: Verify-Input-Time-Disabled Text:{0} Field:{1} Page:{2}")
//    public static void verifyInputTimeDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_time",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_time",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_time",field),"disabled");
//    }

    /**
     * @param lookup_text [Lookup text to be verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void verifyInputLookUp(String lookup_text, String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        String fieldDetails = field.contains("::") ? field.trim() + "::"+ lookup_text : field.trim() + ":: ::"+ lookup_text;
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails));
        BrowserGlobal.iAssertElementText(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails),lookup_text);
    }

    /**
     * @param dropdown_Text [Text to be Verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Select Text:{0} Field:{1} Page:{2}")
    public static void verifySelectText(String dropdown_Text, String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"MAIN");
        String fieldDetails = fieldInstanceCheckAndAddVal_1(field,dropdown_Text);

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.select(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.select(page,fieldLoc,field));
        BrowserGlobal.iAssertElementPresent(d365Loc.selectValue(page,fieldLoc,fieldDetails));

    }

//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365Global: Verify-Select-Disabled Field:{0} Page:{1}")
//    public static void verifySelectDisabled(String field, String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_select",field),"disabled");
//    }

    /**
     * @param error_Text [error_Text to be Verified]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365Global: Verify-Error Text:{0} Page:{1}")
    public static void verifyErrorText(String error_Text, String page) throws Exception {
        BrowserGlobal.iAssertElementPresent(d365Loc.text(page,"MAIN",error_Text));
//        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_error_text",error_Text));
//        BrowserGlobal.iAssertElementPresent("xpath=//span[contains(@id,'error-message')][contains(text(),'"+error_Text.trim()+"']");
    }

//    /**
//     * @param error_Text [error_Text to be Verified]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365Global: Verify-Error-Text-Under-Input-Field Error-Text:{0} Field:{1} Page:{2}")
//    public static void verifyErrorTextUnderInputField(String error_Text, String field, String page) throws Exception {
//        BrowserGlobal.iAssertElementPresent("xpath=//input[@aria-label='"+field.trim()+"']/../../../descendant::span[text()='"+error_Text.trim()+"']");
//        // [For Quick Create] //div[contains(@aria-label,'Quick Create:')]/descendant::input[@aria-label='Account Name']/../../../descendant::span[text()='Account Name: Required fields must be filled in.']
//    }



    /**
     * @param header_control_list_text [Header Control List Test (Top Right) to be Verified]
     */
    @QAFTestStep(description = "D365Global: Verify-Header-Control-List Text:{0} Page:{1}")
    public static void verifyHeaderControlList(String header_control_list_text, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(d365Loc.text(page,"header_control_list",header_control_list_text));
        BrowserGlobal.iAssertElementPresent(d365Loc.text(page,"header_control_list",header_control_list_text));
//        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_header_control_list",header_control_list_text));
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
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableHeader(page,"NONE",header_text+"::none::"+colNum),"2");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iAssertElementPresent(d365Loc.tableHeader(page,"NONE",header_text+"::none::"+colNum));
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
                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableHeader(page,"NONE",tableHeaderName+":: ::"+colNum),"5");
                    break;
                } catch (Exception e) {
                    BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
                }
            }
            BrowserGlobal.iAssertElementPresent(d365Loc.tableHeader(page,"NONE",tableHeaderName+":: ::"+colNum));
        }
    }

//    /**
//     *
//     * @param header_column_text [header column number of the Table to be clicked]
//     * @param header_column_number [header column number of the Table to be clicked]
//     * @param dropdown_text [dropdown /button text  to be clicked]
//     * @param page [Page name]
//     *
//     */
//    @QAFTestStep(description = "D365Global: Verify-Table-Column-Sort Header-Text:{0} Header-Column:{1} Then-Check-Sort-Dropdown-Button Text:{2} Page:{3}")
//    public static void verifyTableColumnSort(String header_column_text,String header_column_number,String dropdown_text, String page) throws Exception {
//        int colNum = Integer.parseInt(header_column_number) + 1;
//        for (int i = 0; i < 10; i++) {
//            try {
//                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"3");
//                break;
//            } catch (Exception e) {
//                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
////                BrowserGlobal.iScrollHorizontalUsingScrollLocator("25",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
//            }
//        }
//        BrowserGlobal.iClickOn(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum));
////        BrowserGlobal.iWaitUntilElementPresentWithTimeout(loc.get(page,"d365_table_header_dropdown_sort",dropdown_text),"15");
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_table_header_dropdown_sort",dropdown_text));
//
//    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Column-Sort-Up Header-Text:{0} Header-Column:{1} Page:{2}")
    public static void verifyTableColumnSortUp(String header_column_text,String header_column_number, String page) throws Exception {
        int colNum = Integer.parseInt(header_column_number) + 1;
        for (int i = 0; i < 10; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"3");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_column_sort_up",header_column_text));
    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Column-Sort-Down Header-Text:{0} Header-Column:{1} Page:{2}")
    public static void verifyTableColumnSortDown(String header_column_text,String header_column_number, String page) throws Exception {
        int colNum = Integer.parseInt(header_column_number) + 1;
        for (int i = 0; i < 10; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"3");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_column_sort_down",header_column_text));
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
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",header_text+"::"+column_number));
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
            BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",tableHeaderName+"::"+colNum));
        }
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Close"));
    }

    /**
     * @param cell_value [cell value to be Verified]
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Cell-Value-Is Text:{0} Row:{1} Column:{2} Page:{3}")
    public static void verifyTableCellValueIs(String cell_value, String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;
        for (int i = 0; i < 25; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"3");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iAssertInnerHtmlIs(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),cell_value);
    }

    /**
     * @param cell_value [cell value to be Verified]
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365Global: Verify-Table-Cell-Value Text:{0} Row:{1} Column:{2} Page:{3}")
    public static void verifyTableCellValueContains(String cell_value, String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;
        for (int i = 0; i < 25; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"3");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iAssertInnerHtmlContains(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),cell_value);

    }

    // Get Values

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     * @param to_variable [Variable Name to store the value]
     */
    @QAFTestStep(description = "D365Global: Store-Table-Cell-Value-To-Variable Row:{0} Column:{1} To-Variable:{2} Page:{3}")
    public static void storeTableCellValueToVariable(String row_number, String column_number, String to_variable, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;
        for (int i = 0; i < 25; i++) {
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"2");
                break;
            } catch (Exception e) {
                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
            }
        }
        BrowserGlobal.iStoreValueIntoVariable(BrowserGlobal.iGetTextFromInnerHtml(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum)),to_variable);

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

    private static String[] fieldValueCheck(String argFieldVal){
        String[] fVal = new String[2];
        if (argFieldVal.contains("::")) {
            String[] elementSplit = argFieldVal.trim().split("::");
            fVal[0] = elementSplit[0];
            fVal[1] = "::"+elementSplit[1];
        } else {
            fVal[0] = argFieldVal;
            fVal[1] = "";
        }
        return fVal;
    }

    private static String pageNameCheck(String argPage){
        if (argPage.contains("::")) {
            String[] pageSplit = argPage.trim().split("::");
            return pageSplit[0];
        } else {
            return argPage;
        }
    }
    private static String fieldLocCheck(String argPage, String argDefaultLoc){
        if (argPage.contains("::")) {
            String[] pageSplit = argPage.trim().split("::");
            return pageSplit[1];
        } else {
            return argDefaultLoc;
        }
    }

    private static String fieldInstanceCheckAndAddVal_1(String argFieldName, String argAdditionalVal_1){
        return argFieldName.contains("::") ? argFieldName.trim() + "::"+ argAdditionalVal_1 : argFieldName.trim() + ":: ::"+ argAdditionalVal_1;
    }

}
