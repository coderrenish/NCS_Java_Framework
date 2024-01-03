package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.utils.*;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class lhubFundingPage {
    @QAFTestStep(description="Funding-Page: I verify I'm in funding home page")
    public void fundingPageIVerifyIMInFundingHomePage() throws Exception{
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Funding","text","Funding"));
    }

}

