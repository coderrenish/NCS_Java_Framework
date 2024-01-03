package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.D365Global;
import com.ahq.globals.Utils;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class athenaHomePage {

    @QAFTestStep(description="Home-Page: I verify I am in Athena homepage")
    public void homePageIVerifyIAmInAthenaHomepage() throws Exception{
        BrowserGlobal.iWaitForSeconds("5");
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Home","link","Home:data-id:sdasdashdghasgdjgashdg"));
        BrowserGlobal.iAssertTextPresentInPage("Dashboard Notification");
    }


}

