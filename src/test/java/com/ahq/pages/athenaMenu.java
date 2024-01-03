package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.*;
import com.ahq.utils.loc;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class athenaMenu {
    @QAFTestStep(description="Menu: I navigate to {0} } {1}")
    public void menuINavigateTo(String menu1,String menu2) throws Exception{
      BrowserGlobal.iClickOn(loc.get("Menu","link",menu1));
      BrowserGlobal.iWaitForSeconds("1");
      BrowserGlobal.iClickOn(loc.get("Menu","link",menu2));
      D365Global.clickMenuButtonWithText("Save");
    }

}
