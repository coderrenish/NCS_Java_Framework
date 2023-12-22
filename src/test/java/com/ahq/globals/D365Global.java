package com.ahq.globals;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class D365Global {

    /**
     * @param text [text to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input Text:{0} Field:{1} Page:{2}")
    public static void inputText(String text,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(text,loc.get(page,"input",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input Date:{0} Field:{1} Page:{2}")
    public static void inputDate(String date,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iInputInTo(date,loc.get(page,"input",field));
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void inputLookUp(String text, String field, String page) throws Exception {
        if (!field.contains(", Lookup")) {
            field = field +", Lookup";
        }
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        BrowserGlobal.iWaitForMilliseconds("2000");
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     * @param wait_in_secs [wait in Secs for Lookup results to populate]
     */
    @QAFTestStep(description="MSDynamics: Input-Lookup Text:{0} Field:{1} Page:{2} Wait-In-Secs:{3}")
    public void inputLookUpWithWai(String text,String field,String page,String wait_in_secs) throws Exception{
        if (!field.contains(", Lookup")) {
            field = field +", Lookup";
        }
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitForSeconds(wait_in_secs);
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        BrowserGlobal.iWaitForSeconds("2000");
    }

    /**
     * Clearing Existing value in Lookup ad then enter
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input-Lookup Text:{0} By-Clearing-Existing-Value Field:{1} Page:{2}")
    public static void inputLookUpByClearingExistingValue(String text, String field, String page) throws Exception {
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
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete"));
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        BrowserGlobal.iWaitForMilliseconds("2000");
    }

    /**
     * Clearing Existing value by name in Lookup ad then enter
     * Note: Should know existing value
     * @param text [text to be entered in lookup]
     * @param clear_value [Existing Value to clear in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input-Lookup Text:{0} By-Clearing-Value:{1} field:{2} page:{3}")
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
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete "+clear_value));
        BrowserGlobal.iInputInTo(text, loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",text));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",text));
        BrowserGlobal.iWaitForMilliseconds("1000");
    }

    /**
     * @param menu_text [Menu Text to be clicked]
     */
    @QAFTestStep(description = "MSDynamics: Click-Menu Text:{0}")
    public static void clickMenuWithText(String menu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","link",menu_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","link",menu_text));
        BrowserGlobal.iClickOn(loc.get("menu","link",menu_text));
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @QAFTestStep(description = "MSDynamics: Click-Menu-Button Text:{0}")
    public static void clickMenuButtonWithText(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",button_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",button_text));
        BrowserGlobal.iClickOn(loc.get("menu","button",button_text));
    }

    /**
     * @param tab_text [Tab text/name to be clicked]
     */
    @QAFTestStep(description = "MSDynamics: Click-Tab Text:{0}")
    public static void clickTabWithText(String tab_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","tab",tab_text));
        BrowserGlobal.iScrollToAnElement(loc.get("menu","tab",tab_text));
        BrowserGlobal.iClickOn(loc.get("menu","tab",tab_text));
    }

    /**
     * @param mainMenu_text [Main Menu Text/name to be clicked]
     * @param subMenu_text [Sub Menu Text/name to be clicked]
     */
    @QAFTestStep(description = "MSDynamics: Click-Main-Menu Text:{0} Then-Sub-Menu Text:{1}")
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
    @QAFTestStep(description = "MSDynamics: Click-Main-Menu-Button Text:{0} Then-Sub-Menu-Button Text:{1}")
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
    @QAFTestStep(description = "MSDynamics: Click-Main-Menu-Button Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
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
    @QAFTestStep(description = "MSDynamics: Select Text:{0} Field:{1} Page:{2}")
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
    @QAFTestStep(description = "MSDynamics: Select Index:{0} Field:{1} Page:{2}")
    public static void selectByIndex(String dropdown_Text_Index, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iSelectDropdownWithIndex(loc.get(page,"select",field),dropdown_Text_Index);
    }

    /**
     * @param scroll_value [Scroll Value from the Visible Field]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Scroll Value:{0} From-Visible Field:{1} Page:{2}")
    public static void scrollFromVisibleField(String scroll_value, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"general",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"general",field));
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        QAFWebElement point = new QAFExtendedWebElement(loc.get(page,"general",field));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(point);
        new Actions(driver).scrollFromOrigin(scrollOrigin,0 , Integer.parseInt(scroll_value)).perform();
    }
}
