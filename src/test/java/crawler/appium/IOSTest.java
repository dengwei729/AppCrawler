package crawler.appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;


/**
 * Created by dengwei on 18/10/2017.
 */
public class IOSTest {

    private WebDriver driver;
    private static AppiumDriverLocalService service;

    @Before
    public void setUp() throws Exception {

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
        capabilities.setCapability(MobileCapabilityType.UDID, "00e630def672da63ed0bae762c3d78aebb67ea8d");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.APP, "com.autonavi.amaptestmonkey");
        capabilities.setCapability("bundleId", "com.autonavi.amaptestmonkey");
        capabilities.setCapability("showXcodeLog", true);

        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println(driver.getPageSource());
    }


    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }

    @Test
    public void findByElementsTest() throws Exception {
//        Assert.assertNotEquals(0, uiTestApp.uiButtons.size());
        Thread.sleep(8000);
        WebElement element = driver.findElement(By.xpath("//*[contains(name(), 'Text') and string-length(@value)>0 and string-length(@value)<20 and @visible=\"true\"][1]" +
                ""));
        System.out.println("text: " + element.getText());
        System.out.println("tag name: " + element.getTagName());
        System.out.println("isVisible: " + element.isDisplayed());
        System.out.println("isEnabled: " + element.isEnabled());


        System.out.println("\n");
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(name(), 'Image') and " +
                "@visible=\"true\"]"));
        for (int i=0; i<elements.size(); i++) {
            System.out.println("******  获取可见的Image " + i);
            System.out.println("text: " + elements.get(i).getText());
            System.out.println("tag name: " + elements.get(i).getTagName());
            System.out.println("isVisible: " + elements.get(i).isDisplayed());
            System.out.println("isEnabled: " + elements.get(i).isEnabled());
        }

//
//        System.out.println("\n");
//        elements = driver.findElements(By.xpath("//*[contains(name(), 'Button') and " +
//                "@visible=\"true\"]"));
//        for (int i=0; i<elements.size(); i++) {
//            System.out.println("******  获取可见的Button " + i);
//            System.out.println("text: " + elements.get(i).getText());
//            System.out.println("tag name: " + elements.get(i).getTagName());
//            System.out.println("isVisible: " + elements.get(i).isDisplayed());
//            System.out.println("isEnabled: " + elements.get(i).isEnabled());
//        }


        System.out.println("\n");
        elements = driver.findElements(By.xpath("//*[contains(name(), 'Text') and string-length(@value)>0 and string-length(@value)<20 and @visible=\"true\"][1]"));
        for (int i=0; i<elements.size(); i++) {

            System.out.println("******  获取可见的Text" + i);
            System.out.println("text: " + elements.get(i).getText());
            System.out.println("tag name: " + elements.get(i).getTagName());
            System.out.println("isVisible: " + elements.get(i).isDisplayed());
            System.out.println("isEnabled: " + elements.get(i).isEnabled());
        }
    }

}
