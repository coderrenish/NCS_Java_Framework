package com.ahq.pages;

import com.ahq.globals.*;
import com.ahq.utils.loc;
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
        BrowserGlobal.iClickOn(loc.get("Login","button","No"));
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Login","text","Please sign in again"));
        BrowserGlobal.iClickOn(loc.get("ReLogin","button","Sign In"));

//        D365Global.inputText(Utils.nric_singapore_generate(),"NRIC","");


    }

}

