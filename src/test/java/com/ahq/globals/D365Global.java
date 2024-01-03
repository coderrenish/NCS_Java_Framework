package com.ahq.globals;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
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
    @QAFTestStep(description = "MsDynamicsGlobal: Input Text:{0} Field:{1} Page:{2}")
    public static void inputText(String text,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(text,loc.get(page,"input",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Input Date:{0} Field:{1} Page:{2}")
    public static void inputDate(String date,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_double_click_wait);
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_fill_wait);
        BrowserGlobal.iInputInTo(date,loc.get(page,"input",field));
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void inputLookUp(String text, String field, String page) throws Exception {
        if (!field.contains(", Lookup")) {
            field = field +", Lookup";
        }
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
            BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }


    /**
     * Clearing Existing value by name in Lookup ad then enter
     * Note: Should know existing value
     * @param text [text to be entered in lookup]
     * @param clear_value [Existing Value to clear in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Input-Lookup Text:{0} By-Clearing-Value:{1} Field:{2} Page:{3}")
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
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
            BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }

    /**
     * @param keyword [Keyword to fill]
     * @param instance [Instance of Keyword field]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Input-Filter-Keyword Text:{0} Instance:{1}")
    public static void inputFilterKeyword(String keyword, String instance) throws Exception {
        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
        BrowserGlobal.iWaitUntilElementPresent(loc);
        BrowserGlobal.iScrollToAnElement(loc);
        BrowserGlobal.iClickOn(loc);
        BrowserGlobal.iInputInTo(keyword,loc);
        BrowserGlobal.iPressReturnOrEnterKey();
    }


    /**
     * @param menu_text [Menu Text to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Menu Text:{0}")
    public static void clickMenuWithText(String menu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","link",menu_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","link",menu_text));
        BrowserGlobal.iClickOn(loc.get("menu","link",menu_text));
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Menu-Button Text:{0}")
    public static void clickMenuButtonWithText(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",button_text));
        BrowserGlobal.iClickOn(loc.get("menu","button",button_text));
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Popup-Button Text:{0}")
    public static void clickPopupButton(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",button_text));
        BrowserGlobal.iClickOn(loc.get("menu","button",button_text));
    }

    /**
     * @param tab_text [Tab text/name to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Tab Text:{0}")
    public static void clickTabWithText(String tab_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","tab",tab_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","tab",tab_text));
        BrowserGlobal.iClickOn(loc.get("menu","tab",tab_text));
    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Link Text:{0}")
    public static void clickLinkWithText(String link_text) throws Exception {
        String loc = "xpath=//a[@aria-label='"+link_text+"']";
        BrowserGlobal.iWaitUntilElementPresent(loc);
        BrowserGlobal.iScrollToAnElement(loc);
        BrowserGlobal.iClickOn(loc);
    }
    /**
     * @param mainMenu_text [Main Menu Text/name to be clicked]
     * @param subMenu_text [Sub Menu Text/name to be clicked]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Main-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickMainAndSubMenu(String mainMenu_text,String subMenu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","link",mainMenu_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","link",mainMenu_text));
        BrowserGlobal.iClickOn(loc.get("menu","link",mainMenu_text));
        BrowserGlobal.iWaitForSeconds("1");
        BrowserGlobal.iClickOn(loc.get("menu","link",subMenu_text));
    }

    /**
     * @param main_button_text [Main Button Text/Name]
     * @param sub_button_text [Sub Button Text/Name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Main-Menu-Button Text:{0} Then-Sub-Menu-Button Text:{1}")
    public static void clickMainAndSubMenuButton(String main_button_text,String sub_button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_text));
        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_text));
        BrowserGlobal.iWaitForSeconds("1");
        BrowserGlobal.iClickOn(loc.get("menu","link",sub_button_text));
    }

    /**
     * @param main_button_name [Main Menu name]
     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
     * @param sub_button_name [Sub Menu name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Click-Main-Menu-Button Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
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
    @QAFTestStep(description = "MsDynamicsGlobal: Select Text:{0} Field:{1} Page:{2}")
    public static void selectByText(String dropdown_Text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iSelectDropdownWithText(loc.get(page,"select",field),dropdown_Text);
    }

    /**
     * @param dropdown_Text_Index [Index of the Text to be selected in dropdown starting with 0]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Select Index:{0} Field:{1} Page:{2}")
    public static void selectByIndex(String dropdown_Text_Index, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iSelectDropdownWithIndex(loc.get(page,"select",field),dropdown_Text_Index);
    }

    /**
     * @param multiple_dropdown_Text [Multiple value separated by comma]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Select-Multiple Text:{0} Field:{1} Page:{2}")
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

    /**
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Wait-And-Verify-Page-Header Text:{0} Page:{1}")
    public static void waitAndVerifyPageHeader(String header_text,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"text",header_text));
//        BrowserGlobal.iAssertElementText("xpath=//span[@class='ms-Button-label label-359']", header_text);
        BrowserGlobal.iAssertElementPresent(loc.get(page,"text",header_text));
        BrowserGlobal.iAssertTitlePartialText(header_text);
    }


    /**
     * @param scroll_value [Scroll Value from the Visible Field]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MsDynamicsGlobal: Scroll Value:{0} From-Visible Field:{1} Page:{2}")
    public static void scrollFromVisibleField(String scroll_value, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"general",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"general",field));
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        QAFWebElement point = new QAFExtendedWebElement(loc.get(page,"general",field));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(point);
        new Actions(driver).scrollFromOrigin(scrollOrigin,0 , Integer.parseInt(scroll_value)).perform();
    }
}
