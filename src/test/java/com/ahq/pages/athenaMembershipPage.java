package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class athenaMembershipPage {

    @QAFTestStep(description="Membership-Page: I verify I am in Athena Membership page")
    public void membershipPageIVerifyIAmInAthenaHomepage() throws Exception{
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Membership","text","Union Memberships"));
        BrowserGlobal.iAssertTextPresentInPage("Union Memberships");
    }


}

