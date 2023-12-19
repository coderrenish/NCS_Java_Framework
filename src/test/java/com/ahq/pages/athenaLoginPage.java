package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.D365Global;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class athenaLoginPage {
    @QAFTestStep(description="Login-Page: I login to Athena as {0} with following details {1}, {2} and {3}")
    public void loginPageILoginToAthenaAsWithFollowingDetailsAnd(String userType, String urlToOpen, String username, String password) throws Exception{
        BrowserGlobal.iOpenWebBrowser(urlToOpen);
        BrowserGlobal.iInputInTo(username, loc.get("Login","input","Enter your email address, phone number or Skype."));
        BrowserGlobal.iClickOn(loc.get("Login","button","Next"));
        BrowserGlobal.iInputInTo(password, loc.get("Login","input","Password"));
        BrowserGlobal.iClickOn(loc.get("Login","button","Sign in"));
        BrowserGlobal.iClickOn(loc.get("Login","button","No"));
//        BrowserGlobal.iWaitUntilElementPresent(loc.get("Login","button","Sign in:"));
        BrowserGlobal.iWaitForSeconds("3");
        BrowserGlobal.iPressTabKeytimes("1");
        BrowserGlobal.iPressKey("ENTER");
        BrowserGlobal.iWaitForSeconds("3");
//        BrowserGlobal.iClickOn(loc.get("Login","button","Sign in:id:okButtonText_1"));
    }

}

