package com.ahq.pages;

import com.ahq.globals.*;
//import com.ahq.BrowserGlobal.utils.*;
import com.ahq.utils.*;
//import com.ahq.utils.nics_singapore;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class demoLoginPage {
    @QAFTestStep(description = "Login: I login to SauseDemo using {0}, {1} and {2}")
    public void loginILoginToSauseDemoUsingAnd(String url, String username, String password) throws Exception {


        BrowserGlobal.iOpenWebBrowser(url);

        BrowserGlobal.iFillInTo(username,"loc.login.input.username");
        BrowserGlobal.iFillInTo(password,loc.get("Login","input","Password"));
        BrowserGlobal.iClickOn(loc.get("Login","button","Login"));
        BrowserGlobal.iComment("NRIC :::: " + Utils.nric_singapore_generate("S",40));
    }
}
