package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class lhubLoginPage {
    @QAFTestStep(description="Login-Page: I login to LHUB with following details {0}")
    public void loginPageILoginToLHUBWithFollowingDetails(String url) throws Exception{
        BrowserGlobal.iOpenWebBrowser(url);

    }

}

