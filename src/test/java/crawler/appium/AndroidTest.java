package crawler.appium;

/**
 * Created by dengwei on 18/10/2017.
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;


public class AndroidTest {

    public AppiumDriver<WebElement> driver;
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
        capabilities.setCapability("deviceName","48f8f7fe");
//        capabilities.setCapability("app", "/Users/dengwei/Documents/amap-client/crawler/amap_8.2.0.1051_internal_Autonavi_signed_201710161350_ae4ab27f424c8eafb94b8877dd75e97af3e7775f_master.apk");
        capabilities.setCapability("appPackage", "com.autonavi.minimap");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appActivity", "com.autonavi.map.activity.SplashActivity");
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver<>(service.getUrl(), capabilities);
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
    public void apiDemo() throws Exception {

        Thread.sleep(5000);


        System.out.println(driver.getPageSource());
        List<WebElement> elements = driver.findElementsByXPath("//android.widget.TextView[string-length(@text)>0 and " +
                "string-length(@text)<20]");

        for (int i=0; i < elements.size(); i ++) {
            System.out.println("text: " + elements.get(i).getText());
            System.out.println("tag name: " + elements.get(i).getTagName());
            System.out.println("isVisible: " + elements.get(i).isDisplayed());
            System.out.println("isEnabled: " + elements.get(i).isEnabled());
            System.out.println("isSelected: " + elements.get(i).isSelected());
        }
    }
}
