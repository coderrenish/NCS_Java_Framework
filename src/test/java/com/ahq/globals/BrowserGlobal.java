package com.ahq.globals;

import com.ahq.utils.loc;
import com.ahq.utils.pwd;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.NotImplementedException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;


public class BrowserGlobal {
    
    /**
     * Opening the Web Browser with given URL
     * : I open {url}
     *
     * @param url [URL of the web portal/application]
     */
    @QAFTestStep(description = "I open the web browser with {url}")
    public static void iOpenWebBrowser(String url) {
        iSwitchToWebBrowser();
        new WebDriverTestBase().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(getBundle().getPropertyValue("custom.page.timeout"))));
        get(url);
    }
    
    /**
     * Open Web Browser with given URL and maximise window
     * : I open web browser with {url} and maximise window
     *
     * @param url [URL of the web portal/application]
     */
    @QAFTestStep(description = "I open the web browser with {url} and maximise window")
    public static void iOpenWebBrowserAndMaximize(String url) {
        iSwitchToWebBrowser();
        WebDriver driver = new WebDriverTestBase().getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(getBundle().getPropertyValue("custom.page.timeout"))));
        driver.manage().window().maximize();
        get(url);
    }
    
    /**
     * Open Web Browser with given URL and screenshot
     * : I open web browser with {url} and maximise window
     *
     * @param url [URL of the web portal/application]
     */
    // {open}{browser}{url}{screenshot}
    @QAFTestStep(description = "I open the web browser with {url} and screenshot")
    public static void iOpenWebBrowserAndScreenshot(String url) {
        iSwitchToWebBrowser();
        new WebDriverTestBase().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(getBundle().getPropertyValue("custom.page.timeout"))));
        get(url);
        Reporter.logWithScreenShot("Screenshot");
    }
    
    /**
     * Open Web Browser with given URL, maximise window and screenshot
     * : I open web browser with {url} maximise window and screenshot
     *
     * @param url [URL of the web portal/application]
     */
    // {open}{browser}{url}{maximise}{screenshot}
    @QAFTestStep(description = "I open the web browser with {url} maximise window and screenshot")
    public static void iOpenWebBrowserMaximiseAndScreenshot(String url) {
        iSwitchToWebBrowser();
        WebDriver driver = new WebDriverTestBase().getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(getBundle().getPropertyValue("custom.page.timeout"))));
        driver.manage().window().maximize();
        get(url);
        Reporter.logWithScreenShot("Screenshot");
    }
    
    /**
     * Open Web Browser with given URL, and resize window size
     * : I open web browser with {url} maximise window and screenshot
     *
     * @param url    [URL of the web portal/application]
     * @param width  [Width of the browser]
     * @param height [Height of the browser]
     */
    // {open}{browser}{url}{width}{width_value}{height}{height_value}
    @QAFTestStep(description = "I open the web browser with {url} and window size {width} x {height}")
    public static void iOpenWebBrowserWindowSize(String url, String width, String height) {
        iSwitchToWebBrowser();
        WebDriver driver = new WebDriverTestBase().getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(getBundle().getPropertyValue("custom.page.timeout"))));
        driver.manage().window().setSize(new Dimension(Integer.parseInt(width.trim()), Integer.parseInt(height.trim())));
        get(url);
    }

    /**
     * Zooming browser window to X percentage
     * I zoom browser window to {zoom} Percentage
     * @throws Exception
     */
    @QAFTestStep(description = "I zoom browser window to {percentage} Percentage")
    public static void iZoomBrowserToPercentage(String zoom) throws Exception {
        WebDriver driver = new WebDriverTestBase().getDriver();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.body.style.zoom='"+zoom+"'");
    }
    /**
     * Pressing on the RETURN or ENTER key in a field
     * : I press RETURN or ENTER key in {loc}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    //{press}{key}{return}
    //{press}{key}{enter}
    @QAFTestStep(description = "I press RETURN or ENTER key in {loc}")
    public static void iPressReturnOrEnterKeyIn(String locator) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        element.sendKeys(Keys.RETURN);
    }
    
    /**
     * Pressing on the RETURN or ENTER key in the current location
     * : I press RETURN or ENTER key
     *
     * @throws Exception
     */
    //{press}{key}{return}
    //{press}{key}{enter}
    @QAFTestStep(description = "I press RETURN or ENTER key")
    public static void iPressReturnOrEnterKey() throws Exception {
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        builder.sendKeys(Keys.RETURN);
        builder.build().perform();
    }
    
    /**
     * Pressing the given key
     * : I press key {key}
     *
     * @param key [Key to press]
     * @throws Exception
     */
    @QAFTestStep(description = "I press key {key}")
    public static void iPressKey(String key) throws Exception {
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        builder.sendKeys(Keys.valueOf(key.toUpperCase()));
        builder.build().perform();
    }

    /**
     * Pressing the TAB key n times
     * : I press Tab {n} times
     *
     * @param times [Press TAB n times]
     */
    @QAFTestStep(description = "I press Tab {times} times")
    public static void iPressTabKeyTimes(String times) throws Exception {
        for (int i = 0; i < Integer.parseInt(times); i++) {
            BrowserGlobal.iPressKey("TAB");
            BrowserGlobal.iWaitForMilliseconds("1000");
        }
    }
//    /**
//     * Pressing the BACKSPACE key n times
//     * : I press Tab {n} times
//     *
//     * @param times [Press TAB n times]
//     */
//    @QAFTestStep(description = "I press Backspace {times} times")
//    public static void iPressBackspaceKeyTimes(String times) throws Exception {
//        for (int i = 0; i < Integer.parseInt(times); i++) {
//            BrowserGlobal.iPressKey("DELETE");
//            BrowserGlobal.iWaitForMilliseconds("100");
//        }
//    }

    /**
     * Pressing a special key (E.g. Shift, Control, Option) and then fill value or character
     * : I press key {key} and fill {value}
     *
     * @param key   [Key to press]
     * @param value [Value to fill in the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I press a key {key} and fill {value}")
    public static void iPressKeyAndFill(String key, String value) throws Exception {
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        builder.keyDown(Keys.valueOf(key.toUpperCase()));
        builder.sendKeys(value);
        builder.keyUp(Keys.valueOf(key.toUpperCase()));
        builder.build().perform();
    }

    /**
     * Select All by pressing Control or Command "a" Key
     * : I Press Control or Command A by OS
     * @throws Exception
     */
    @QAFTestStep(description = "I Press Control or Command A by OS")
    public static void iPressControlOrCommandAByOs() throws Exception {
        String keyType;
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            keyType = "COMMAND";
        } else {
            keyType = "CONTROL";
        }
        iHoldKeyAndPressAKey(keyType,"a");
    }

    /**
     * Pressing a special key (E.g. Shift, Control, Option) and then press another special key
     * : I hold down a key {holdKey} and press a key {pressKey}
     *
     * @param holdKey  [Key to hold]
     * @param pressKey [Key to press]
     * @throws Exception
     */
    @QAFTestStep(description = "I hold down a key {holdKey} and press a key {pressKey}")
    public static void iHoldKeyAndPressAKey(String holdKey, String pressKey) throws Exception {
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        builder.keyDown(Keys.valueOf(holdKey.toUpperCase()));
        builder.sendKeys(pressKey);
        builder.keyUp(Keys.valueOf(holdKey.toUpperCase()));
        builder.build().perform();
    }
    
    /**
     * Pressing two special keys (E.g. Shift, Control, Option) and then fill value or character
     * : I press key {key} and fill {value}
     *
     * @param key_1 [First Key to press]
     * @param key_2 [Second Key to press]
     * @param value [Value to fill in the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I press two keys {key_1} {key_2} and fill {value}")
    public static void iPressTwoKeysAndFill(String key_1, String key_2, String value) throws Exception {
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        builder.keyDown(Keys.valueOf(key_1.toUpperCase()));
        builder.keyDown(Keys.valueOf(key_2.toUpperCase()));
        builder.sendKeys(value);
        builder.keyUp(Keys.valueOf(key_1.toUpperCase()));
        builder.keyUp(Keys.valueOf(key_2.toUpperCase()));
        builder.build().perform();
    }
    // Navigate Methods
    
    /**
     * Click to Go back in Web browser
     * : I go page back in the web browser history
     */
    // In {browser} go {page} {back}
    @QAFTestStep(description = "I go page back in the web browser history")
    public static void iGoPageBackInBrowser() {
        new WebDriverTestBase().getDriver().navigate().back();
    }
    
    /**
     * Click to Go Forward in Web browser
     * : I go page forward in the web browser history
     */
    // In {browser} go {page} {forward}
    @QAFTestStep(description = "I go page forward in the web browser history")
    public static void iGoPageForwardInBrowser() {
        new WebDriverTestBase().getDriver().navigate().forward();
    }
    
    /**
     * Switching between browser tab with index
     * : I switch browser tab to {index}
     *
     * @param index [Number][Browser Tab index Eg. 3]
     */
    // In {browser} {switch} {tab} by {index} {2}
    @QAFTestStep(description = "I switch browser tab to {index}")
    public static void iSwitchBrowsertabToIndex(String index) {
        WebDriver driver = new WebDriverTestBase().getDriver();
        ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());// switch to new tab
        driver.switchTo().window(newTb.get(Integer.parseInt(index) - 1));
    }
    // Clicking Methods
    
    /**
     * Clicking on a field/location/link
     * : I click on {locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click on {locator}")
    public static void iClickOn(String locator) throws Exception {
        click(locator);
    }


    /**
     * Clicking on a field/location/link
     * : I click on {locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I double click on {locator}")
    public static void iDoubleClickOn(String locator) throws Exception {
        WebElement elementLocator = new WebDriverTestBase().getDriver().findElement(locator);
        Actions actions = new Actions(new WebDriverTestBase().getDriver());
        actions.doubleClick(elementLocator).perform();
    }

    @QAFTestStep(description = "I click on {locator} if not selected")
    public static void iClickOnElementIfNotSelected(String locator) throws Exception {
        if (!new WebDriverTestBase().getDriver().findElement(locator).isSelected()) click(locator);
    }
    
    @QAFTestStep(description = "I click on {locator} if selected")
    public static void iClickOnElementIfSelected(String locator) throws Exception {
        if (new WebDriverTestBase().getDriver().findElement(locator).isSelected()) click(locator);
    }
    
    /**
     * Clicking on multiple field/location/link
     * : I click on multiple elements {locator}
     *
     * @param locators [String[] type - Locators of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click on multiple elements {locator}")
    public static void iClickOnMultipleElements(String[] locators) throws Exception {
        for (String loc : locators) {
            click(loc);
        }
    }
    
    /**
     * Clicking on a field/location/link if present
     * : I click on {locator} if present
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click on {locator} if present")
    public static void iClickOnLocIfPresent(String locator) throws Exception {
        if (!new WebDriverTestBase().getDriver().findElements(locator).isEmpty()) {
            click(locator);
        }
    }
    
    /**
     * Clicking on a field/location/link once enabled
     * : I click on {locator} once enabled
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click on {locator} once enabled")
    public static void iClickOnLocOnceEnabled(String locator) throws Exception {
        waitForEnabled(locator);
        // iWaitUntilElementEnabled(locator);
        click(locator);
    }
    
    /**
     * Mouseover on a field/location/link
     * : I mouseover on {locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I mouseover on {locator}")
    public static void iMouseoverOn(String locator) throws Exception {
        WebElement element = new WebDriverTestBase().getDriver().findElement(locator);
        Actions builder = new Actions(new WebDriverTestBase().getDriver());
        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();
    }
    
    /**
     * Drag and drop that performs click-and-hold at the
     * location of the source element, moves to the location of the target
     * element, then releases the mouse.
     * : I drag source {source} and drop on target {target}
     *
     * @param source [Locator of the source]
     * @param target [Locator of the target]
     */
    @QAFTestStep(description = "I drag source {source_locator} and drop on target {target_locator}")
    public static void iDragAndDropOn(String source, String target) {
        dragAndDrop(source, target);
    }
    
    /**
     * Fill text/value to a given field
     * : I fill {value} into {locator}
     *
     * @param value   [Value to enter/fill in a field]
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I fill {value} into {locator}")
    public static void iFillInTo(String value, String locator) throws Exception {
        sendKeys(pwd.check(value), locator);
    }


    /**
     * Input text/value to a given field
     * : I input {value} into {locator}
     *
     * @param value   [Value to enter/input in a field]
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I input {value} into {locator}")
    public static void iInputInTo(String value, String locator) throws Exception {
        sendKeys(pwd.check(value), locator);
    }
    
    /**
     * Click and Fill text/value to a given lookup field with a delay
     * : I click and fill {value} into {locator} lookup field {delay}
     *
     * @param value   [Value to enter/fill in a field]
     * @param locator [Locator of the field]
     * @param delay   [wait time necessary between entering the value and clicking down in the search]
     * @throws Exception
     */
    @QAFTestStep(description = "I click and fill {value} into {locator} lookup field {delay}")
    public static void iClickAndFillInToLookupField(String value, String locator, String delay) throws Exception {
        click(locator);
        BrowserGlobal.iClearAndFillInTo(value, locator);
        BrowserGlobal.iWaitForMilliseconds(delay);
        iPressKey("ARROW_DOWN");
        BrowserGlobal.iWaitForMilliseconds(delay);
        iPressReturnOrEnterKey();
    }
    
    /**
     * Click and Fill text/value to a given field
     * : I click and fill {value} into {locator}
     *
     * @param value   [Value to enter/fill in a field]
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click and fill {value} into {locator}")
    public static void iClickAndFillInTo(String value, String locator) throws Exception {
        click(locator);
        sendKeys(value, locator);
    }
    
    /**
     * Double click and Fill text/value to a given field
     * : I double-click and fill {value} into {locator}
     *
     * @param value   [Value to enter/fill in a field]
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I double click and fill {value} into {locator}")
    public static void iDoubleClickAndFillInTo(String value, String locator) throws Exception {
        click(locator);
        click(locator);
        sendKeys(value, locator);
    }



    /**
     * Double click and Fill text/value to a given field
     * : I double-click and fill {value} into {locator}
     *
     * @param value    [Value to enter/fill in a field]
     * @param locator  [Locator of the field]
     * @param waitTime [milliseconds to wait before entering value]
     * @throws Exception
     */
    @QAFTestStep(description = "I double click, wait and fill {value} into {locator}")
    public static void iDoubleClickWaitAndFillInTo(String value, String locator, String waitTime) throws Exception {
        click(locator);
        click(locator);
        iWaitForMilliseconds(waitTime);
        sendKeys(value, locator);
    }
    
    /**
     * Click into the locator and press the shift tab key and then ENTER key
     * : I click and shift tab then ENTER key
     *
     * @param locator [locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I click and shift tab then ENTER key")
    public static void iClickAndTabInToThenEnter(String locator) throws Exception {
        click(locator);
        iHoldKeyAndPressAKey("SHIFT", "TAB");
        iPressReturnOrEnterKey();
    }

    
    /**
     * Clear the specified element value and Fill text/value
     * : I clear and fill {value} into {locator}
     *
     * @param value   [Value to enter/fill in a field]
     * @param locator [Locator of the field to clear and fill]
     * @throws Exception
     */
    @QAFTestStep(description = "I clear and fill {value} into {locator}")
    public static void iClearAndFillInTo(String value, String locator) throws Exception {
        clear(locator);
        sendKeys(value, locator);
    }
    
    /**
     * Set a Field attribute value
     * : I set field {locator} attribute {attr-name} value as {value}
     *
     * @param locator   [Locator of the field]
     * @param attr_name [Attribute Name of the field]
     * @param value     [Value to set in the attribute]
     * @throws Exception
     */
    @QAFTestStep(description = "I set field {locator} attribute {attr_name} value as {value}")
    public static void iSetFieldAttributeValue(String locator, String attr_name, String value) {
        setAttribute(locator, attr_name, value);
    }
    
    /**
     * Clear the specified element value from the field
     * Ex. Clearing text from textbox
     * : I clear text from field{locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I clear text from {locator}")
    public static void iClearTextFrom(String locator) throws Exception {
        clear(locator);
    }
    
    /**
     * Commenting inside test/scenario
     * : I comment {value}
     *
     * @param value [Value to set in the comment]
     */
    @QAFTestStep(description = "I comment {value}")
    public static void iComment(Object value) {
        System.out.printf("COMMENT: %s \n", value);
    }
    
    /**
     * Get the text from an element or field
     * : I get text from {locator}
     *
     * @param locator [Locator of the field]
     * @return The text specified in the locator/field
     * @throws Exception
     */
    @QAFTestStep(description = "I get text from {locator}")
    public static String iGetText(String locator) throws Exception {
        return getText(locator);
    }
    
    /**
     * Submit the specified page. This is particularly useful for page without submit buttons, e.g. single-input "Search" page.
     * : I submit {locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I submit {locator}")
    public static void iSubmit(String locator) throws Exception {
        submit(locator);
    }
    // Screenshots methods
    
    /**
     * Taking current screenshot of the page
     * : I take screenshot
     */
    @QAFTestStep(description = "I take screenshot")
    public static void iTakeScreenshot() {
        Reporter.logWithScreenShot("");
    }
    
    /**
     * Taking current screenshot of the page with comment
     * : I take screenshot with comment {comment}
     *
     * @param comment [Comment for the screenshot]
     */
    @QAFTestStep(description = "I take screenshot with comment {comment}")
    public static void iTakeScreenshotWithComment(String comment) {
        Reporter.logWithScreenShot(comment);
    }
    // Dropdown Selection methods
    
    /**
     * Selecting a value in the Dropdown/Select field
     * : I select dropdown {locator} with value {value}
     *
     * @param locator [Locator of the field]
     * @param value   [Value in the Dropdown/select field]
     * @throws Exception
     */
    @QAFTestStep(description = "I select dropdown {locator} with value {value}")
    public static void iSelectDropdownWithValue(String locator, String value) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.selectByValue(value);
    }
    
    /**
     * Selecting a value index in the Dropdown/Select field
     * : I select dropdown {locator} with index {number}
     *
     * @param locator [Locator of the field]
     * @param index   [Index of the text/value in Dropdown/select field starting with 1]
     * @throws Exception
     */
    @QAFTestStep(description = "I select dropdown {locator} with index {index}")
    public static void iSelectDropdownWithIndex(String locator, String index) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.selectByIndex(Integer.parseInt(index));
    }
    
    /**
     * Selecting a text in the Dropdown/Select field
     * : I select dropdown {locator} with text {text}
     *
     * @param locator [Locator of the field]
     * @param text    [Text in the Dropdown/select field]
     * @throws Exception
     */
    @QAFTestStep(description = "I select dropdown {locator} with text {text}")
    public static void iSelectDropdownWithText(String locator, String text) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }
    
    /**
     * Deselecting using value in the Dropdown/Select field
     * : I deselect dropdown {locator} with value {value}
     *
     * @param locator [Locator of the field]
     * @param value   [Value in the Dropdown/select field]
     * @throws Exception
     */
    @QAFTestStep(description = "I deselect dropdown {locator} with value {value}")
    public static void iDeselectDropdownWithValue(String locator, String value) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.deselectByValue(value);
    }
    
    /**
     * Deselecting using value index in the Dropdown/Select field
     * : I select dropdown {locator} with index {number}
     *
     * @param locator [Locator of the field]
     * @param index   [Index of the text/value in Dropdown/select field starting with 0]
     * @throws Exception
     */
    @QAFTestStep(description = "I deselect dropdown {locator} with index {index}")
    public static void iDeselectDropdownWithIndex(String locator, String index) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.deselectByIndex(Integer.parseInt(index));
    }
    
    /**
     * Deselecting using text in the Dropdown/Select field
     * : I deselect dropdown {locator} with text {text}
     *
     * @param locator [Locator of the field]
     * @param text    [Text in the Dropdown/select field]
     * @throws Exception
     */
    @QAFTestStep(description = "I deselect dropdown {locator} with text {text}")
    public static void iDeselectDropdownWithText(String locator, String text) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.deselectByVisibleText(text);
    }
    
    /**
     * Deselecting all values/text in Dropdown/Select field (inc. multi select dropdown)
     * : I deselect all in dropdown {locator}
     *
     * @param locator [Locator of the field]
     * @throws Exception
     */
    @QAFTestStep(description = "I deselect all in dropdown {locator}")
    public static void iDeselectAllInDropdown(String locator) throws Exception {
        QAFWebElement element = new QAFExtendedWebElement(locator);
        Select s = new Select(element);
        s.deselectAll();
    }
    // Storage Methods
    
    /**
     * Store last step result with the given name. In bdd if step returns value,
     * and you want to store the return value with name for further use you can
     * call this step. Stored value in the variable can be
     * retrieved in other steps as ${varname}
     * : I store last step result into variable {var}
     *
     * @param var [Variable to store the value]
     */
    @QAFTestStep(description = "I store last step result into variable {var}")
    public static void iStoreLastStepResultIntoVariable(String var) {
        storeLastStepResultInto(var);
    }
    
    /**
     * Store a value in variable to use later on. Stored value in the variable can be
     * retrieved in other steps as ${varname}
     * : I store value {val} into variable {var}
     *
     * @param value    [Value to be stored]
     * @param variable [Variable to store the value]
     */
    @QAFTestStep(description = "I store value {value} into variable {variable}")
    public static void iStoreValueIntoVariable(String value, String variable) {
        store(value, variable);
    }
    // Window methods
    
    /**
     * Switch to new window by name Example:<br/>
     * switchToWindow 'Forgot Password Popup'<br/>
     * : I switch window by name {name}
     *
     * @param name [Name of the window E.g. 'Forgot Password Popup']
     */
    @QAFTestStep(description = "I switch window by name {name}")
    public static void iSwitchWindowByName(String name) {
        switchToWindow(name);
    }
    
    /**
     * Switch to new window by Index<br/>
     * Example switchToWindow '3'<br/>
     * : I switch window by name {name}
     *
     * @param index [Index of the window E.g. '2']
     */
    @QAFTestStep(description = "I switch window by index {index}")
    public static void iSwitchWindowByIndex(String index) {
        switchToWindow(index);
    }
    
    /**
     * Switches the webdriver context to the parent frame
     * : I switch to parent window
     *
     * @return
     */
    @QAFTestStep(description = "I switch to parent window or frame")
    public static Object iSwitchToParentWindowFrame() {
        return switchToParentFrame();
    }
    
    /**
     * Switches the webdriver context to the default frame
     * : I switch to default window or frame
     *
     * @return
     */
    @QAFTestStep(description = "I switch to default window or frame")
    public static Object iSwitchToDefaultWindow() {
        return switchToDefaultWindow();
    }
    
    /**
     * Closes all active browser through automation
     * : I close web browser
     */
    @QAFTestStep(description = "I close web browser")
    public static void iCloseWebBrowser() {
        tearDownDriver();
    }
    
    @QAFTestStep(description = "I close current window or tab")
    public static void iCloseCurrentWindowOrTab() {
        new WebDriverTestBase().getDriver().close();
    }
    // Cookie Methods
    
    /**
     * Adding a new cookie with value
     * : I add cookie with name {name} and value {value}
     *
     * @param name  [Name of the new cookie]
     * @param value [Assigning value to the cookie]
     */
    @QAFTestStep(description = "I add cookie with name {name} and value {value}")
    public static void iAddCookie(String name, String value) {
        addCookie(name, value);
    }
    
    /**
     * Getting the value of existing cookie by name
     * : I get cookie value with the name {name}
     *
     * @param name [Name of the existing cookie]
     *             \
     */
    @QAFTestStep(description = "I get a cookie value with the name {name}")
    public static void iGetCookieWithValue(String name) {
        getCookieValue(name);
    }
    
    /**
     * Deleting the existing cookie by name
     * : I delete cookie with name {name}
     *
     * @param name [Name of the existing cookie to be deleted]
     *             \
     */
    @QAFTestStep(description = "I delete cookie with name {name}")
    public static void iDeleteCookie(String name) {
        deleteCookie(name);
    }
    
    /**
     * Deleting all cookies
     * : I delete all cookies
     * \
     */
    @QAFTestStep(description = "I delete all cookies")
    public static void iDeleteAllCookies() {
        deleteAllCookies();
    }
    // Transaction Methods
    
    /**
     * Start time tracking which can be stopped by subsequent call to
     * {@link #iStopTransaction()}. It will group all steps and track time.
     * : I start transaction with name {name}
     *
     * @param name [Name of the transaction]
     */
    @QAFTestStep(description = "I start transaction with name {name}")
    public static void iStartTransaction(String name) {
        startTransaction(name);
    }
    
    /**
     * Start time tracking with Threshold which can be stopped by subsequent call to
     * {@link #iStopTransaction()}. It will group all steps and track time with given threshold comparison.
     * : I start transaction {name} with {second} seconds threshold
     *
     * @param name             [Name of the transaction]
     * @param secondsThreshold [Threshold of the transaction in seconds]
     */
    @QAFTestStep(description = "I start transaction {name} with {second} seconds threshold")
    public static void iStartTransactionWithThreshold(String name, String secondsThreshold) {
        startTransaction(name, Integer.parseInt(secondsThreshold));
    }
    
    /**
     * Stop or End transaction
     * {@link #iStartTransaction(String) iStartTransaction}
     * {@link #iStartTransactionWithThreshold(String, String) iStartTransactionWithThreshold}.
     */
    @QAFTestStep(description = "I stop transaction")
    public static void iStopTransaction() {
        stopTransaction();
    }
    
    /**
     * Verifying the element/field is present
     * : I verify {locator} is present
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} is present")
    public static boolean iVerifyElementPresent(String locator) throws Exception {
        return verifyPresent(locator);
    }
    
    /**
     * Verifying the element/field is not present
     * : I verify {locator} is not present
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} is not present")
    public static boolean iVerifyElementNotPresent(String locator) throws Exception {
        return verifyNotPresent(locator);
    }
    
    /**
     * Verifying the element/field is visible
     * : I verify {locator} is visible
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} is visible")
    public static boolean iVerifyElementVisible(String locator) throws Exception {
        return verifyVisible(locator);
    }
    
    /**
     * Verifying the element/field is not visible
     * : I verify {locator} is not visible
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} is not visible")
    public static boolean iVerifyElementNotVisible(String locator) throws Exception {
        return verifyNotVisible(locator);
    }
    
    /**
     * Verifying the link with text is present
     * : I verify link with text {text} is present
     *
     * @param text [Text in the link]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify link with text {text} is present")
    public static boolean iVerifyLinkWithTextPresent(String text) throws Exception {
        return verifyLinkWithTextPresent(text);
    }
    
    /**
     * Verifying the link with partial text is present
     * : I verify link with partial text {text} is present
     *
     * @param text [Partial Text of the link]
     * @return
     */
    @QAFTestStep(description = "I verify link with partial text {text} is present")
    public static boolean iVerifyLinkWithPartialTextPresent(String text) {
        return verifyLinkWithPartialTextPresent(text);
    }
    
    /**
     * Verifying the element/field text is text.
     * : I verify {locator} text is {text}
     *
     * @param text [Partial Text in the link]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} text is {text}")
    public static boolean iVerifyElementText(String locator, String text) throws Exception {
        return verifyText(locator, text);
    }
    
    /**
     * Verifying the element/field text is not text.
     * : I verify {locator} text is not {text}
     *
     * @param text [Partial Text in the link]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify {locator} text is not {text}")
    public static boolean iVerifyElementTextNot(String locator, String text) throws Exception {
        return verifyNotText(locator, text);
    }
    
    /**
     * Verifying the element/field value is the given value.
     * : I verify element/field {locator} value is {value}
     *
     * @param locator [Locator of the element/field]
     * @param value   [Value which needs to be compared]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify element/field {locator} value is {value}")
    public static boolean iVerifyElementValue(String locator, String value) throws Exception {
        return verifyValue(locator, value);
    }
    
    /**
     * Verifying the element/field value is not the given value.
     * : I verify element/field {locator} value is not {value}
     *
     * @param locator [Locator of the element/field]
     * @param value   [Value which needs to be compared]
     * @return
     * @throws Exception
     */
    @QAFTestStep(description = "I verify element/field {locator} value is not {value}")
    public static boolean iVerifyElementValueNot(String locator, String value) throws Exception {
        return verifyNotValue(locator, value);
    }
    
    /**
     * Verifying the element/field value is selected in the page.
     * : I verify element/field {locator} is selected
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    // {verify}{checkbox/radio/select}{<name>}{selected}
    @QAFTestStep(description = "I verify element/field {locator} is selected")
    public static boolean iVerifyElementSelected(String locator) throws Exception {
        return verifySelected(locator);
    }
    
    /**
     * Verifying the element/field value is not selected in the page.
     * : I verify element/field {locator} is not selected
     *
     * @param locator [Locator of the element/field]
     * @return
     * @throws Exception
     */
    // {verify}{checkbox/radio/select}{<name>}{not-selected}
    @QAFTestStep(description = "I verify element/field {locator} is not selected")
    public static boolean iVerifyElementNotSelected(String locator) throws Exception {
        return verifyNotSelected(locator);
    }
    
    /**
     * Verifying the element/field's attribute value is the given value.
     * : I verify element/field {locator} with attribute {attr_name} value is {value}
     *
     * @param locator   [Locator of the element/field]
     * @param attr_name [Attribute Name of the element/field]
     * @param value     [Attribute Value of the element/field to be compared]
     * @return
     * @throws Exception
     */
    // {verify}{input/checkbox/radio/select/link/td/etc.}{<name>}{attribute-name}{<attribute-name>}{value-is}{<value>}
    @QAFTestStep(description = "I verify element/field {locator} with attribute {attr_name} value is {value}")
    public static boolean iVerifyElementAttributeValue(String locator, String attr_name, String value) throws Exception {
        return verifyAttribute(locator, attr_name, value);
    }


    
    /**
     * Verifying the element/field's attribute value is not the given value.
     * : I verify element/field {locator} with attribute {attr-name} value is not {value}
     *
     * @param locator [Locator of the element/field]
     * @param attr    [Attribute Name of the element/field]
     * @param value   [Attribute Value of the element/field to be compared]
     * @return
     * @throws Exception
     */
    // {verify}{input/checkbox/radio/select/link/td/etc.}{<element-name>}{attribute}{<attribute-name>}{value-is-not}{<value>}
    @QAFTestStep(description = "I verify element/field {locator} with attribute {attr-name} value is not {value}")
    public static boolean iVerifyElementAttributeValueNot(String locator, String attr, String value) throws Exception {
        return verifyNotAttribute(locator, attr, value);
    }
    
    /**
     * Verifying the element/field's value/text is partially present.
     * : I verify element/field {locator} with partial text {text} is present
     *
     * @param locator [Locator of the element/field]
     * @param text    [Partial value/text of the element/field to be compared]
     * @return
     * @throws Exception
     */
    // {verify}{link/label/text/etc.}{<element-name>}{partial-text}{<partial-text>}{is-present}
    @QAFTestStep(description = "I verify element/field {locator} with partial text {text} is present")
    public static boolean iVerifyLocatorPartialText(String locator, String text) throws Exception {
        String locatorText = getText(locator);
        Validator.verifyTrue(locatorText.contains(text), expectedActualString(text, locatorText), expectedActualString(text, locatorText));
        return locatorText.contains(text);
    }
    
    @QAFTestStep(description = "I verify element/field {locator} with partial text ignoring case {text} is present")
    public static boolean iVerifyLocatorWithPartialTextIgnoringCase(String locator, String text) throws Exception {
        String locatorText = getText(locator).toLowerCase();
        Validator.verifyTrue(locatorText.contains(text.toLowerCase()), expectedActualString(text.toLowerCase(), locatorText), expectedActualString(text.toLowerCase(), locatorText));
        return locatorText.contains(text.toLowerCase());
    }
    
    // {verify}{title}{text-is}{<title text>}
    @QAFTestStep(description = "I verify title text is {text}")
    public static boolean iVerifyTitleText(String titleText) throws Exception {
        String title = new WebDriverTestBase().getDriver().getTitle();
        boolean status = title.equals(titleText);
        Validator.verifyTrue(status, expectedActualString(titleText, title), expectedActualString(titleText, title));
        return status;
    }
    
    // {verify}{title}{partial-text-is}{<partial title text>}
    @QAFTestStep(description = "I verify title partial text is {text}")
    public static boolean iVerifyTitlePartialText(String titleTextPartial) throws Exception {
        String title = new WebDriverTestBase().getDriver().getTitle();
        boolean status = title.contains(titleTextPartial);
        Validator.verifyTrue(status, expectedActualString(titleTextPartial, title), expectedActualString(titleTextPartial, title));
        return status;
    }
    // Wait Methods
    
    /**
     * Wait until the element/field is visible.
     * : I wait until element/field {locator} is visible
     *
     * @param locator [Locator of the element/field]
     * @throws Exception
     */
    //{wait}{until}{input/checkbox/radio/select/link/td/etc.}{<element-name>}{is-visible}
    @QAFTestStep(description = "I wait until element/field {locator} is visible")
    public static void iWaitUntilElementVisible(String locator) throws Exception {
        waitForVisible(locator);
    }
    
    /**
     * Wait until the element/field is visible with timeout in seconds.
     * : I wait until element/field {locator} is visible with timeout {sec} in seconds
     *
     * @param locator [Locator of the element/field]
     * @param timeout [Timeout in seconds]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is visible with timeout {timeout} in seconds")
    public static void iWaitUntilElementVisibleWithTimeout(String locator, long timeout) throws Exception {
        waitForVisible(locator, timeout);
    }
    
    /**
     * Wait until the element/field is not visible.
     * : I wait until element/field {locator} is not visible
     *
     * @param locator [Locator of the element/field]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is not visible")
    public static void iWaitUntilElementNotVisible(String locator) throws Exception {
        waitForNotVisible(locator);
    }
    
    /**
     * Wait until the element/field is not visible with timeout in seconds.
     * : I wait until element/field {locator} is not visible with timeout {sec} in seconds
     *
     * @param locator     [Locator of the element/field]
     * @param timeout_sec [Timeout in seconds]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is not visible with timeout {timeout} in seconds")
    public static void iWaitUntilElementNotVisibleWithTimeout(String locator, long timeout_sec) throws Exception {
        waitForNotVisible(locator, timeout_sec);
    }
    
    /**
     * Wait until the element/field is present.
     * : I wait until element/field {locator} is present
     *
     * @param locator [Locator of the element/field]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is present")
    public static void iWaitUntilElementPresent(String locator) throws Exception {
        waitForPresent(locator);
    }
    
    /**
     * Wait until the element/field is present with timeout in seconds.
     * : I wait until element/field {locator} is present with timeout {timeout_sec} in seconds
     *
     * @param locator     [Locator of the element/field]
     * @param timeout_sec [Timeout in seconds]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is present with timeout {timeout_sec} in seconds")
    public static void iWaitUntilElementPresentWithTimeout(String locator, String timeout_sec) throws Exception {
        waitForPresent(locator, Long.parseLong(timeout_sec));
    }
    
    /**
     * Wait until the element/field is not present.
     * : I wait until element/field {locator} is not present
     *
     * @param locator [Locator of the element/field]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is not present")
    public static void iWaitUntilElementNotPresent(String locator) throws Exception {
        waitForNotPresent(locator);
    }
    
    /**
     * Wait until the element/field is not present with timeout in seconds.
     * : I wait until element/field {locator} is present with timeout {timeout_sec} in seconds
     *
     * @param locator [Locator of the element/field]
     * @param timeout [Timeout in seconds]
     * @throws Exception
     */
    @QAFTestStep(description = "I wait until element/field {locator} is not present with timeout {sec} in seconds")
    public static void iWaitUntilElementNotPresentWithTimeout(String locator, long timeout) throws Exception {
        waitForNotPresent(locator, timeout);
    }
    
    @QAFTestStep(description = "I wait until {locator} is selected")
    public static void iWaitUntilElementSelected(String locator) throws Exception {
        waitForSelected(locator);
    }
    
    @QAFTestStep(description = "I wait until {locator} is selected with timeout {sec}")
    public static void iWaitUntilElementSelectedWithTimeout(String locator, long sec) throws Exception {
        waitForSelected(locator, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} is not selected")
    public static void iWaitUntilElementNotSelected(String locator) throws Exception {
        waitForNotSelected(locator);
    }
    
    @QAFTestStep(description = "I wait until {locator} is not selected with timeout {sec}")
    public static void iWaitUntilElementNotSelectedWithTimeout(String locator, long sec) throws Exception {
        waitForNotSelected(locator, sec);
    }
    
    @QAFTestStep(description = "I wait for {locator} to be enabled")
    public static void iWaitUntilElementEnabled(String locator) throws Exception {
        waitForEnabled(locator);
    }
    
    @QAFTestStep(description = "I wait for {locator} to be enabled with timeout {sec}")
    public static void iWaitUntilElementEnabledWithTimeout(String locator, long sec) throws Exception {
        waitForEnabled(locator, sec);
    }
    
    @QAFTestStep(description = "I wait for {locator} to be disabled")
    public static void iWaitUntilElementDisabled(String locator) throws Exception {
        waitForDisabled(locator);
    }
    
    @QAFTestStep(description = "I wait for {locator} to be disabled with timeout {sec}")
    public static void iWaitUntilElementDisabledWithTimeout(String locator, long sec) throws Exception {
        waitForDisabled(locator, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} with attribute {attr-name} value is {value}")
    public static void iWaitUntilElementAttributeValue(String locator, String attr, String value) throws Exception {
        waitForAttribute(locator, attr, value);
    }
    
    @QAFTestStep(description = "I wait until {locator} with attribute {attr-name} value is not {value}")
    public static void iWaitUntilElementAttributeValueNot(String locator, String attr, String value) throws Exception {
        waitForNotAttribute(locator, attr, value);
    }
    
    @QAFTestStep(description = "I wait until {locator} with attribute {attr-name} value is {value} with timeout {sec}")
    public static void iWaitUntilElementAttributeValueWithTimeout(String locator, String attr, String value, long sec) throws Exception {
        waitForAttribute(locator, attr, value, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} attribute {attr-name} value is not {value} with timeout {sec}")
    public static void iWaitUntilElementAttributeValueNotWithTimeout(String locator, String attr, String value, long sec) throws Exception {
        waitForNotAttribute(locator, attr, value, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} css class name is {className}")
    public static void iWaitUntilElementCssClassName(String locator, String className) throws Exception {
        waitForCssClass(locator, className);
    }
    
    @QAFTestStep(description = "I wait until {locator} css class name is {className} with timeout {sec}")
    public static void iWaitUntilElementCssClassNameWithTimeout(String locator, String className, long sec) throws Exception {
        waitForCssClass(locator, className, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} css class name is not {className}")
    public static void iWaitUntilElementCssClassNameNot(String locator, String className) throws Exception {
        waitForNotCssClass(locator, className);
    }
    
    @QAFTestStep(description = "I wait until {locator} css class name is not {className} with timeout {sec}")
    public static void iWaitUntilElementCssClassNameNotWithTimeout(String locator, String className, long sec) throws Exception {
        waitForNotCssClass(locator, className, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} property {prop} value is {value}")
    public static void iWaitUntilElementPropertyValue(String locator, String prop, String value) throws Exception {
        waitForCssStyle(locator, prop, value);
    }
    
    @QAFTestStep(description = "I wait until {locator} property {prop} value is {value} with timeout {sec}")
    public static void iWaitUntilElementPropertyValueWithTimeout(String locator, String prop, String value, long sec) throws Exception {
        waitForCssStyle(locator, prop, value, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} property {prop} value is not {value}")
    public static void iWaitUntilElementPropertyValueNot(String locator, String prop, String value) throws Exception {
        waitForNotCssStyle(locator, prop, value);
    }
    
    @QAFTestStep(description = "I wait until {locator} property {prop} value is not {value} with timeout {sec}")
    public static void iWaitUntilElementPropertyValueNotWithTimeout(String locator, String prop, String value, long sec) throws Exception {
        waitForNotCssStyle(locator, prop, value, sec);
    }
    
    @QAFTestStep(description = "I wait until {locator} property color {prop} value is {value}")
    public static void iWaitUntilElementPropertyColorValue(String locator, String prop, String value) throws Exception {
        waitForCssStyleColor(locator, prop, value);
    }
    
    @QAFTestStep(description = "I wait until {locator} property color {prop} value is not {value}")
    public static void iWaitUntilElementPropertyColorValueNot(String locator, String prop, String value) throws Exception {
        waitForNotCssStyleColor(locator, prop, value);
    }
    
    @QAFTestStep(description = "I wait for {millisecs} milliseconds")
    public static void iWaitForMilliseconds(String millisecs) {
        int tmpMilliSecs = Integer.parseInt(millisecs);
        QAFTestBase.pause(tmpMilliSecs);
    }
    
    @QAFTestStep(description = "I wait for {secs} seconds")
    public static void iWaitForSeconds(String secs) {
        int tmpSecs = Integer.parseInt(secs);
        QAFTestBase.pause(tmpSecs * 1000L);
    }
    @QAFTestStep(description = "I wait for page to load")
    public static void iWaitForPageToLoad() {
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
        wait.until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    // Assert Methods
    
    @QAFTestStep(description = "I assert {locator} is present")
    public static void iAssertElementPresent(String locator) throws Exception {
        assertPresent(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} is not present")
    public static void iAssertElementNotPresent(String locator) throws Exception {
        assertNotPresent(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} is visible")
    public static void iAssertElementVisible(String locator) throws Exception {
        assertVisible(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} is not visible")
    public static void iAssertElementVisibleNot(String locator) throws Exception {
        assertNotVisible(locator);
    }
    
    @QAFTestStep(description = "I assert link with text {linkText} is present")
    public static void iAssertLinkWithTextPresent(String linkText) {
        assertLinkWithTextPresent(linkText);
    }
    
    @QAFTestStep(description = "I assert link with partial text {linkText} is present")
    public static void iAssertLinkWithPartialTextPresent(String linkText) {
        assertLinkWithPartialTextPresent(linkText);
    }
    
    @QAFTestStep(description = "I assert {locator} text is {text}")
    public static void iAssertElementText(String locator, String text) throws Exception {
        assertText(locator, text);
    }
    
    @QAFTestStep(description = "I assert {locator} text is not {text}")
    public static void iAssertElementTextNot(String locator, String text) throws Exception {
        assertNotText(locator, text);
    }
    
    @QAFTestStep(description = "I assert {locator} value is {value}")
    public static void iAssertElementValue(String locator, String value) throws Exception {
        assertValue(locator, value);
    }
    
    @QAFTestStep(description = "I assert {locator} value is not {value}")
    public static void iAssertElementValueNot(String locator, String value) throws Exception {
        assertNotValue(locator, value);
    }
    
    @QAFTestStep(description = "I assert element {locator} is selected")
    public static void iAssertElementSelected(String locator) throws Exception {
        assertSelected(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} is not selected")
    public static void iAssertElementNotSelected(String locator) throws Exception {
        assertNotSelected(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} with attribute {attr-name} value is {value}")
    public static void iAssertElementWithAttributeValue(String locator, String attr, String value) throws Exception {
        assertAttribute(locator, attr, value);
    }
    
    @QAFTestStep(description = "I assert {locator} with attribute  {attr-name} value is not {value}")
    public static void iAssertElementWithAttributeValueNot(String locator, String attr, String value) throws Exception {
        assertNotAttribute(locator, attr, value);
    }
    
    @QAFTestStep(description = "I assert {locator} css class name is {className}")
    public static void iAssertElementCssClassName(String locator, String className) throws Exception {
        assertCssClass(locator, className);
    }
    
    @QAFTestStep(description = "I assert {locator} css class name is not {className}")
    public static void iAssertElementCssClassNameNot(String locator, String className) throws Exception {
        assertNotCssClass(locator, className);
    }
    
    @QAFTestStep(description = "I assert {locator} property {prop} value is {value}")
    public static void iAssertElementPropertyValue(String locator, String prop, String value) throws Exception {
        assertCssStyle(locator, prop, value);
    }
    
    @QAFTestStep(description = "I assert {locator} property {prop} value is not {value}")
    public static void iAssertElementPropertyValueNot(String locator, String prop, String value) throws Exception {
        assertNotCssStyle(locator, prop, value);
    }
    
    @QAFTestStep(description = "I assert {locator} property {prop} color value is {value}")
    public static void iAssertElementPropertyColorValue(String locator, String prop, String value) throws Exception {
        assertCssStyleColor(locator, prop, value);
    }
    
    @QAFTestStep(description = "I assert {locator} property {prop} color value is not {value}")
    public static void iAssertElementPropertyColorValueNot(String locator, String prop, String value) throws Exception {
        assertNotCssStyleColor(locator, prop, value);
    }
    /**
     * Asserting the element/field's attribute is present.
     * : I assert element/field {locator} with attribute {attr_name} present
     *
     * @param locator   [Locator of the element/field]
     * @param attr_name [Attribute Name of the element/field]

     */
    // {verify}{input/checkbox/radio/select/link/td/etc.}{<name>}{attribute-name}{<attribute-name>}{value-is}{<value>}
    @QAFTestStep(description = "I assert element/field {locator} with attribute {attr_name} present")
    public static void iAssertElementAttributePresent(String locator, String attr_name) throws Exception {
        System.out.println("/////////// > " + $(locator).getAttribute("readonly"));
        WebElement elementToCheck = new WebDriverTestBase().getDriver().findElement(locator);
        WebDriver driver = new WebDriverTestBase().getDriver();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String elementAttributes = js.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",elementToCheck).toString();
        System.out.println("=========> " + elementAttributes);
        Validator.assertTrue(elementAttributes.contains(" " + attr_name.trim() + "="), attr_name.trim() + " - Attribute Not Present",attr_name.trim() + " - Attribute Present");
    }
    
    @QAFTestStep(description = "I assert {locator} is enabled")
    public static void iAssertElementEnabled(String locator) throws Exception {
        assertEnabled(locator);
    }
    
    @QAFTestStep(description = "I assert {locator} is disabled")
    public static void iAssertElementDisabled(String locator) throws Exception {
        assertDisabled(locator);
    }
    
    @QAFTestStep(description = "I assert locator {locator} with partial text {text} is present")
    public static void iAssertLocatorPartialText(String locator, String text) throws Exception {
        String locatorText = getText(locator);
        Validator.assertTrue(locatorText.contains(text), expectedActualString(text, locatorText), expectedActualString(text, locatorText));
    }
    
    @QAFTestStep(description = "I assert locator {locator} with partial text {text} is present ignoring case")
    public static void iAssertLocatorPartialTextIgnoringCase(String locator, String text) throws Exception {
        String locatorText = getText(locator).toLowerCase();
        Validator.assertTrue(locatorText.contains(text.toLowerCase()), expectedActualString(text.toLowerCase(), locatorText), expectedActualString(text.toLowerCase(), locatorText));
    }
    
    @QAFTestStep(description = "I assert title text is {text}")
    public static void iAssertTitleText(String titleText) throws Exception {
        String title = new WebDriverTestBase().getDriver().getTitle();
        boolean status = title.equals(titleText);
        Validator.assertTrue(status, expectedActualString(titleText, title), expectedActualString(titleText, title));
    }
    
    @QAFTestStep(description = "I assert title partial text is {text}")
    public static void iAssertTitlePartialText(String titleTextPartial) throws Exception {
        String title = new WebDriverTestBase().getDriver().getTitle();
        boolean status = title.contains(titleTextPartial);
        Validator.assertTrue(status, expectedActualString(titleTextPartial, title), expectedActualString(titleTextPartial, title));
    }
    
    @QAFTestStep(description = "I switch to iFrame by id or name {id/name}")
    public static void iSwitchToIFrameByIdOrName(String frameId) throws Exception {
        new WebDriverTestBase().getDriver().switchTo().frame(frameId);
    }
    
    @QAFTestStep(description = "I switch to iFrame by index {index}")
    public static void iSwitchToIFrameByIndex(String index) throws Exception {
        new WebDriverTestBase().getDriver().switchTo().frame(Integer.parseInt(index));
    }
    
    @QAFTestStep(description = "I scroll to an element {locator}")
    public static void iScrollToAnElement(String locator) throws Exception {
        WebElement element = new WebDriverTestBase().getDriver().findElement(locator);
        new WebDriverTestBase().getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    @QAFTestStep(description = "I scroll to an element {locator} and wait in seconds {seconds}")
    public static void iScrollToAnElementAndWaitInSeconds(String locator, String waitTimeInSeconds) throws Exception {
        WebElement element = new WebDriverTestBase().getDriver().findElement(locator);
        new WebDriverTestBase().getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
        // iWaitForSeconds(Integer.parseInt(waitTimeInSeconds));
        QAFTestBase.pause(Integer.parseInt(waitTimeInSeconds) * 1000);
    }
    
    @QAFTestStep(description = "I scroll to an element {locator} and click")
    public static void iScrollToAnElementAndClick(String locator) throws Exception {
        WebElement element = new WebDriverTestBase().getDriver().findElement(locator);
        new WebDriverTestBase().getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
        QAFTestBase.pause(500);
        click(locator);
    }
    
    @QAFTestStep(description = "I scroll to an element {locator} wait for {milliSecs} milliseconds and click")
    public static void iScrollToAnElementWaitForMilliSecondsAndClick(String locator, String mSecs) throws Exception {
        WebElement element = new WebDriverTestBase().getDriver().findElement(locator);
        new WebDriverTestBase().getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
        QAFTestBase.pause(Integer.parseInt(mSecs));
        click(locator);
    }

    /**
     * Scroll to the Bottom
     * I scroll to the Bottom {locator}
     * @throws Exception
     */
    @QAFTestStep(description = "I scroll to the bottom of the page")
    public static void iScrollToTheBottomOfThePage() throws Exception {
        WebDriver driver = new WebDriverTestBase().getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // JavascriptExecutor js=(JavascriptExecutor)driver;
        // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scroll Horizontal using scroll locator (This is useful for internal scroll)
     * I scroll horizontal (to right) using scroll locator {locator}
     */
    @QAFTestStep(description = "I scroll horizontal (to right) to end using scroll locator {0}")
    public static void iScrollHorizontalToEndUsingScrollLocator(String loc) throws Exception {
        WebElement scrollBar = new WebDriverTestBase().getDriver().findElement(loc);
        BrowserGlobal.iClickOn(loc);
        Actions move = new Actions(new WebDriverTestBase().getDriver());

        int offsetVal = 0;
        for (int i = 0; i < 1000; i++) {
            offsetVal = offsetVal + 10;
            try{
                move.moveToElement(scrollBar).clickAndHold();
                move.moveByOffset(offsetVal,0);
                move.release();
                move.perform();
            } catch (Exception e) {
                break;
            }
        }
    }

    /**
     * Scroll Horizontal using scroll locator (This is useful for internal scroll)
     * I scroll horizontal (to right) using scroll locator {locator}
     * @param scrollLength [scrollLength to the right in pixel]
     * @param loc [Scroll locator]
     */
    @QAFTestStep(description = "I scroll horizontal (to right) by {0} using scroll locator {1}")
    public static void iScrollHorizontalUsingScrollLocator(String scrollLength, String loc) throws Exception {
        WebElement scrollBar = new WebDriverTestBase().getDriver().findElement(loc);
        BrowserGlobal.iClickOn(loc);
        Actions move = new Actions(new WebDriverTestBase().getDriver());
        try{
            move.moveToElement(scrollBar).clickAndHold();
            move.moveByOffset(Integer.parseInt(scrollLength),0);
            move.release();
            move.perform();
        } catch (Exception e) {
        }

    }
    // {assert}
    @QAFTestStep(description = "I assert text present in page {text}")
    public static void iAssertTextPresentInPage(String text) throws Exception {
        List<WebElement> list = new WebDriverTestBase().getDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        boolean status = !list.isEmpty();
        Validator.assertTrue(status, "Text not found! '" + text + "'", "Text found! '" + text + "'");
        Reporter.logWithScreenShot("");
    }
    
    @QAFTestStep(description = "I verify text present in page {text}")
    public static boolean iVerifyTextPresentInPage(String text) throws Exception {
        List<WebElement> list = new WebDriverTestBase().getDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        boolean status = !list.isEmpty();
        Validator.verifyTrue(status, "Text not found! '" + text + "'", "Text found! '" + text + "'");
        Reporter.logWithScreenShot("");
        return status;
    }
    
    @QAFTestStep(description = "I assert aria-label {0} present in page {text}")
    public static void iAssertAriaLabelPresentInPage(String ariaText) throws Exception {
        List<WebElement> list = new WebDriverTestBase().getDriver().findElements(By.xpath("//*[contains(@aria-label, '" + ariaText + "')]"));
        boolean status = !list.isEmpty();
        Validator.assertTrue(status, "Aria-Label not found! '" + ariaText + "'", "Aria-Label found! '" + ariaText + "'");
    }
    
    @QAFTestStep(description = "I verify aria-label {0} present in page {text}")
    public static boolean iVerifyAriaLabelPresentInPage(String ariaText) throws Exception {
        List<WebElement> list = new WebDriverTestBase().getDriver().findElements(By.xpath("//*[contains(@aria-label, '" + ariaText + "')]"));
        boolean status = !list.isEmpty();
        Validator.verifyTrue(status, "Aria-Label not found! '" + ariaText + "'", "Aria-Label found! '" + ariaText + "'");
        return status;
    }
    
    @QAFTestStep(description = "I fail step with info {text}")
    public static void iFailStepWithInfo(String failText) throws Exception {
        // Validator.assertTrue(false,"",failText);
        Validator.assertFalse(true, failText, "");
    }
    
    /**
     * Switching driver to Web Browser
     * : I switch to web browser
     */
    @QAFTestStep(description = "I switch to the web browser")
    public static void iSwitchToWebBrowser() {
//        BrowserGlobal.iComment("I ENTERED");
//        // Run Details
//        String webRunType = getBundle().getPropertyValue("ahq.exec.web.run.type");
//        String webRunMode = getBundle().getPropertyValue("ahq.exec.web.run.mode");
//        String webRunName = getBundle().getPropertyValue("ahq.exec.web.run.name");
//        String osName = getBundle().getPropertyValue("ahq.exec.web.os.name").toLowerCase();
//        // Driver Details
//        BrowserGlobal.iComment("I ENTERED 2");
////        String webBrowserName = getBundle().getPropertyValue("ahq.exec.web.browser.name").toLowerCase();
////        String webDriverType = getBundle().getPropertyValue("ahq.exec.web.driver.type");
////        String webDriver = webBrowserName + webDriverType;
//        String webDriver = getBundle().getPropertyValue("ahq.exec.web.driver.name");
//        String webDriverFileLoc = getBundle().getPropertyValue("ahq.exec.web.driver." + webBrowserName + ".location");
//        // Manage drivers
//
        String webBrowserName = getBundle().getPropertyValue("exec.web.browser.name").toLowerCase();
        String webDriverFileLoc = getBundle().getPropertyValue("exec.web.driver." + webBrowserName + ".location");
        if (getBundle().getPropertyValue("exec.web.manage.driver.executable").equalsIgnoreCase("false")) {
            getBundle().setProperty("manage.driver.executable", "false");
            getBundle().setProperty("system.webdriver." + webBrowserName + ".driver", webDriverFileLoc);
        } else {
            getBundle().setProperty("manage.driver.executable", "true");
        }
//        BrowserGlobal.iComment("===========>" + getBundle().getPropertyValue("ahq.exec.web.driver.name"));
//        getBundle().setProperty("driver.name", getBundle().getPropertyValue("ahq.exec.web.driver.name"));
////        getBundle().setProperty("driver.version", getBundle().getPropertyValue("ahq.exec.web.browser.version"));
//        BrowserGlobal.iComment("I ENTERED ==> " + getBundle().getPropertyValue("ahq.exec.web.driver.name"));

//        String webDriver = getBundle().getPropertyValue("ahq.exec.web.driver.name");
//        getBundle().setProperty("driver.name", "chromeDriver");
        getBundle().setProperty("driver.name", getBundle().getPropertyValue("exec.web.driver.name"));
        switchDriver(getBundle().getPropertyValue("exec.web.driver.name"));
    }
    
    /**
     * Switching driver to Mobile
     * : I switch to Mobile App
     */
    @QAFTestStep(description = "I switch to the Mobile App")
    public static void iSwitchToMobileApp() {
        throw new NotImplementedException("Switch to Mobile App method not yet implemented");
    }
    
    @QAFTestStep(description = "I upload file {filePath} into file uploader {locator}")
    public static void iUploadFileOnFileUploader(String filePath, String locator) throws Exception {
        iWaitUntilElementVisible(locator);
        File file = new File(filePath);
        sendKeys(file.getAbsolutePath(), locator);
    }
    
    @QAFTestStep(description = "I switch to iFrame by title {title}")
    public static void iSwitchToIFrameByTitle(String title) throws Exception {
        WebDriver driver = new WebDriverTestBase().getDriver();
        driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='" + title + "']")));
    }
    
    @QAFTestStep(description = "I switch to iFrame by locator {locator}")
    public static void iSwitchToIFrameByLocator(String locator) throws Exception {
        WebDriver driver = new WebDriverTestBase().getDriver();
        driver.switchTo().frame($(locator));
    }
    
    @QAFTestStep(description = "I store table {locator} row {row_number} column {column_number} cell text into {var}")
    public static void iStoreTableRowColumnCellText(String locator, String rowNum, String columnNum, String storeVar) throws Exception {
        try {
            String columnData = $(locator).findElement(By.xpath("//tr[" + rowNum + "]/td[" + columnNum + "]")).getText();
            store(columnData, storeVar);
        } catch (Exception e) {
            store("NO-TABLE-CELL", storeVar);
        }
        // Note: If no row or no column then it will output as NO-TABLE-CELL
    }
    
    @QAFTestStep(description = "I verify element {locator} inner HTML contains {text}")
    public static boolean iVerifyElementInnerHtmlContains(String locator, String text) throws Exception {
        String innerHtml = $(locator).getAttribute("innerHTML");
        String cleanedString = innerHtml.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&apos;", "'").replaceAll("&nbsp;", " ");
        Validator.verifyTrue(cleanedString.contains(text), expectedActualString(text, cleanedString), expectedActualString(text, cleanedString));
        return cleanedString.contains(text);
    }

    @QAFTestStep(description = "I download file from url {url} and place it in {targetDirectory}, {targetFileName}")
    public static void iDownloadFileFromURL(String url, String tarDirectory, String tarFileName) {
        try {
            File directory = new File(tarDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File destination_file = new File(tarDirectory + tarFileName);
            FileUtils.copyURLToFile(new URL(url), destination_file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @QAFTestStep(description = "I assert a custom condition {condition} with fail message {failMessage} and success message {successMessage}")
    public static void iAssertACustomCondition(boolean condition, String failMessage, String successMessage) throws Exception {
        Validator.assertTrue(condition, failMessage, successMessage);
    }

    // Other Globals
    @QAFTestStep(description = "Utils: Encrypt password {0}")
    public static void UtilsEncryptPassword(String password) throws Exception {
        iComment("== Encyrpted Password is: " + pwd.encrypt(password));
    }

    public static boolean isElementCurrentlyVisible(String locator) {
        boolean status;
        int defaultTimeout = getBundle().getInt("selenium.wait.timeout");
        getBundle().setProperty("selenium.wait.timeout", 0L);
        try {
            status = $(locator).isDisplayed();
        } catch (TimeoutException e) {
            getBundle().setProperty("selenium.wait.timeout", defaultTimeout);
            return false;
        }
        getBundle().setProperty("selenium.wait.timeout", defaultTimeout);
        return status;
    }
    
    public static boolean isElementVisibleWithTimeout(String locator, Long msTimeout) {
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(msTimeout));
        try {
            wait.until(d -> driver.findElement(locator).isDisplayed());
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Store a list object to use later on. Stored list object can be
     * retrieved in other steps as ${varname}
     * : I store list object {listObject} into variable {var}
     *
     * @param listObject [List Object to be stored]
     * @param variable   [Variable to store the value]
     */
    @QAFTestStep(description = "I store List Object {listObject} into variable {variable}")
    public static void iStoreListObjectIntoVariable(List<Object> listObject, String variable) {
        store(listObject, variable);
    }
    
    private static String expectedActualString(String expected, String actual) {
        return "[Expected]: '" + expected + "' [Actual]: '" + actual + "'";
    }
}
