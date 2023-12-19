package com.ahq.globals;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.globals.BrowserGlobal;

import static com.qmetry.qaf.automation.step.CommonStep.click;

public class D365Global {
    @QAFTestStep(description = "D365: Input {0} into {1}")
    public void inputInTo(String date,String locator) throws Exception {
        BrowserGlobal.iDoubleClickAndFillInTo(date,locator);
    }

    @QAFTestStep(description = "D365: Input Date {0} into {1}")
    public void inputDateInTo(String date,String locator) throws Exception {
        BrowserGlobal.iDoubleClickAndFillInTo(date,locator);
    }
    @QAFTestStep(description = "D365: Input lookup {0} into {1}")
    public void inputLookUpInTo(String value,String locator) throws Exception {
        BrowserGlobal.iClickOn(locator);
        BrowserGlobal.iClearAndFillInTo(value, locator);
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iPressKey("ARROW_DOWN");
        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iPressReturnOrEnterKey();
    }

    @QAFTestStep(description = "D365: Input lookup {0} into {1} with wait of {2} secs")
    public void inputLookUpWithWaitInSecs(String value,String locator, String wait) throws Exception {
        BrowserGlobal.iClickOn(locator);
        BrowserGlobal.iClearAndFillInTo(value, locator);
        BrowserGlobal.iWaitForSeconds(wait);
        BrowserGlobal.iPressKey("ARROW_DOWN");
        BrowserGlobal.iWaitForSeconds(wait);
        BrowserGlobal.iPressReturnOrEnterKey();
    }

//    @QAFTestStep(description = "D365: Input lookup {0} into {1} with heading {2}")
//    public void inputLookUpWithHeading(String value,String locator, String heading) throws Exception {
//        BrowserGlobal.iClickOn(locator);
//        BrowserGlobal.iClearAndFillInTo(value, locator);
//        BrowserGlobal.iWaitForMilliseconds("2000");
//        BrowserGlobal.iPressKey("ARROW_DOWN");
//        BrowserGlobal.iWaitForMilliseconds("2000");
//        BrowserGlobal.iPressReturnOrEnterKey();
//    }
}
