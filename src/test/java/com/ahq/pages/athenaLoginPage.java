package com.ahq.pages;

import com.ahq.globals.*;
import com.ahq.addons.*;
import com.qmetry.qaf.automation.step.QAFTestStep;



public class athenaLoginPage {
    @QAFTestStep(description="Login-Page: I login to Athena as {0} with following details {1}, {2} and {3}")
    public void loginPageILoginToAthenaAsWithFollowingDetailsAnd(String userType, String urlToOpen, String username, String password) throws Exception{

        BrowserGlobal.iOpenWebBrowser(urlToOpen);
        BrowserGlobal.iInputInTo(username, loc.get("Login","input","Enter your email address, phone number or Skype."));
        BrowserGlobal.iClickOn(loc.get("Login","button","Next"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iInputInTo(password, loc.get("Login","input","Password"));
        BrowserGlobal.iClickOn(loc.get("Login","button","Sign in"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iClickOn(loc.get("Login","button","Yes"));
        BrowserGlobal.iWaitForSeconds("5");
        BrowserGlobal.iWaitForPageToLoad();


        int signinCount = 0;
        for (int i = 0; i < 10; i++) {
            signinCount = signinCount + 1;
            try {
                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get("ReLogin","button","Sign In"),"5");
                BrowserGlobal.iClickOn(loc.get("ReLogin","button","Sign In"));
                BrowserGlobal.iWaitForPageToLoad();
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("==signinCount=> "+signinCount);
        if (signinCount > 2) {
            int count = signinCount;
            for (int j = 0; j < signinCount; j++) {
                try {
                    count = count - 1;
                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout("xpath=(//button[@aria-label='Sign in'])["+count+"]","3");
                    BrowserGlobal.iClickOn("xpath=(//button[@aria-label='Sign in'])["+count+"]");
                    BrowserGlobal.iWaitForPageToLoad();
                } catch (Exception e) {
                }
            }
        }

    }


//    /**
//     * @param header_text [Header text to be verified]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "CRM-Wait-And-Verify-Page-Header Text-{0} Page-{1}")
//    public static void crmWaitAndVerifyPageHeader(String header_text,String page) throws Exception {
//        BrowserGlobal.iWaitForPageToLoad();
//        BrowserGlobal.iWaitUntilElementVisible(d365Loc.systemViewOrHeaderTitle(page,"main", header_text));
//        BrowserGlobal.iAssertElementPresent(d365Loc.systemViewOrHeaderTitle(page,"main", header_text));
////        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"HEADER",header_text));
////        BrowserGlobal.iAssertElementPresent(d365Loc.loc(page,"HEADER",header_text));
//        BrowserGlobal.iAssertTitlePartialText(header_text);
//    }
}
