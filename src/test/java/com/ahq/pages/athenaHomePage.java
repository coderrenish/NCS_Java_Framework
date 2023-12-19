package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class athenaHomePage {

    @QAFTestStep(description="Home-Page: I verify I am in Athena homepage")
    public void homePageIVerifyIAmInAthenaHomepage() throws Exception{
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Home","link","Home"));
        BrowserGlobal.iAssertTextPresentInPage("Dashboard Notification");
    }


}

