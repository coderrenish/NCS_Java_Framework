package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.addons.loc;
import com.ahq.globals.PowerApps;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.globals.*;


public class athenaHomePage {

    @QAFTestStep(description="Home-Page: I verify I am in Athena homepage")
    public void homePageIVerifyIAmInAthenaHomepage() throws Exception{
        BrowserGlobal.iWaitForSeconds("5");
        BrowserGlobal.iWaitUntilElementPresent(loc.get("Home","link","field.homePage.person"));
        BrowserGlobal.iAssertTextPresentInPage("Dashboard Notification");
//        BrowserGlobal.iSelectDropdownWithIndex();
//        D365CRM.verifyTableCellValue("Form B or MOU Submission","1","1","NOI");
//        D365CRM.getTableCellValue("1","1","var.noi.sdasdasddas","NOI");
////        BrowserGlobal.iGetText();
//        BrowserGlobal.iInputInTo(get);
//        D365CRM.inputText(Utils.nric_singapore_generate("a","56"),"NRIC/FIN","New Membership Application");
    }


}

