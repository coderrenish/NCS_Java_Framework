package com.ahq.globals;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class D365Global {

    /**
     * @param value [Value to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input:{0} field:{1} page:{2}")
    public static void input(String value,String field,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(value,loc.get(page,"input",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input-date:{0} field:{1} page:{2}")
    public static void inputDate(String date,String field,String page) throws Exception {
//        BrowserGlobal.iDoubleClickAndFillInTo(date,loc.get(page,"input",field));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iInputInTo(date,loc.get(page,"input",field));
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "MSDynamics: Input-date:{0} by-clearing field:{1} page:{2}")
    public static void inputDateByClearing(String date,String field,String page) throws Exception {

        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"input",field));
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(date,loc.get(page,"input",field));
    }

    @QAFTestStep(description = "MSDynamics: Input-lookup:{0} field:{1} page:{2}")
    public static void inputLookUp(String value, String field, String page) throws Exception {
        if (!field.contains(", Lookup")) {
            field = field +", Lookup";
        }
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iInputInTo(value, loc.get(page,"input",field));
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",value));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",value));
        BrowserGlobal.iWaitForMilliseconds("2000");
    }

    @QAFTestStep(description="MSDynamics: Input-lookup:{0} field:{1} page:{2} wait-in-secs:{3}")
    public void mSDynamicsInputLookupFieldPageWaitSecs(String value,String field,String page,String wait) throws Exception{
        if (!field.contains(", Lookup")) {
            field = field +", Lookup";
        }
        BrowserGlobal.iClickOn(loc.get(page,"input",field));
        BrowserGlobal.iInputInTo(value, loc.get(page,"input",field));
        BrowserGlobal.iWaitForSeconds(wait);
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",value));
        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",value));
        BrowserGlobal.iWaitForSeconds(wait);
    }

    @QAFTestStep(description = "MSDynamics: Input-lookup:{0} field:{1} page:{2} by-clearing")
    public static void inputLookUpByClearing(String value, String field, String page) throws Exception {
        String splitFields[];
        String delField = field;
        if (field.contains(":")) {
            splitFields = field.split(":");
            delField = splitFields[0];
        }
        BrowserGlobal.iClickOn("xpath=(//*[@title='"+delField.replace(", Lookup","")+"'])[2]");
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete"));
    }

    @QAFTestStep(description = "MSDynamics: Input-lookup:{0} field:{1} page:{2} by-clearing-value:{3}")
    public static void inputLookUpByClearingValue(String value, String field, String page, String clear_value) throws Exception {
        String splitFields[];
        String delField = field;
        if (field.contains(":")) {
            splitFields = field.split(":");
            delField = splitFields[0];
        }
        BrowserGlobal.iClickOn("xpath=(//*[@title='"+delField.replace(", Lookup","")+"'])[2]");
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iClickOn(loc.get(page,"input","Delete "+clear_value));
//        BrowserGlobal.iInputInTo(value, loc.get(page,"input",field));
//        BrowserGlobal.iWaitForMilliseconds("2000");
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup-text",value));
//        BrowserGlobal.iClickOn(loc.get(page,"lookup-text",value));
//        BrowserGlobal.iWaitForMilliseconds("2000");

    }

    /**
     * @param menu [Menu name]
     */
    @QAFTestStep(description = "MSDynamics: Click-Menu:{0}")
    public static void clickMenu(String menu) throws Exception {
        BrowserGlobal.iClickOn(loc.get("menu","link",menu));
    }

    /**
     * @param menu [Menu name]
     */
    @QAFTestStep(description = "MSDynamics: Click-Menu {0} and then Sub-Menu {1}")
    public static void clickSubMenu(String menu,String subMenu) throws Exception {
        BrowserGlobal.iClickOn(loc.get("menu","link",menu));
        BrowserGlobal.iWaitForSeconds("1");
        BrowserGlobal.iClickOn(loc.get("menu","link",subMenu));
    }
}


//     /*
//         input(value,field,page)                                   D365: Input {0} into {1} in page {2}                    // Clear and Input
//         inputDate(value,field,page)                               D365: Input date {0} into {1} in page {2}               // Double Click & Input
//         inputDateByClearing(value,field,page)                     D365: Input date {0} by clearing {1} in page {2}    // Double Click, Ctrl-A & Input
//         inputLookUp(value,field,page)                             D365: Input lookup {0} into {1} in page {2}
//         inputLookUpWithWaitInSecs(value,wait-time,field,page)     D365: Input lookup {0} into {1} in page {2} with wait {3} secs
//         clickMenu(menu)                                           D365: Click menu {0}
//         clickSubMenu(main-menu,Sub-menu)                          D365: Click menu {0} and then sub menu {1}
//         clickMenuButton(button)                                   D365: Click menu button {0}
//         clickMenuButtonDropDown(button-1,button-2)                D365: Click menu button dropdown {0} and then {1}
//         clickLink(link,page)                                      D365: Click link {0} in page {2}
//         clickTab(tab,page)                                        D365: Click tab {0} in page {2}
//         selectByText(value,field,page)                            D365: Select text {0} in {} in page {2}
//         selectByIndex(value,field,page)                           D365: Select text index {0} in {} in page {2}
//         selectByValue(value,field,page)                           D365: Select text Value {0} in {} in page {2}
//         scrollFromVisibleField(scroll-value,field,page)           D365: Scroll {0} from visible field {} in page {2}

//         D365Global.input("Renish","First Name","Recruiter") // 6.5 6.6

//      */
// //    @QAFTestStep(description = "D365: Input lookup {0} into {1} with heading {2}")
// //    public static void inputLookUpWithHeading(String value,String locator, String heading) throws Exception {
// //        BrowserGlobal.iClickOn(locator);
// //        BrowserGlobal.iClearAndFillInTo(value, locator);
// //        BrowserGlobal.iWaitForMilliseconds("2000");
// //        BrowserGlobal.iPressKey("ARROW_DOWN");
// //        BrowserGlobal.iWaitForMilliseconds("2000");
// //        BrowserGlobal.iPressReturnOrEnterKey();
// //    }
