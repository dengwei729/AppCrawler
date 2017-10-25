package crawler.macaca;


import com.alibaba.fastjson.JSONObject;
import macaca.client.MacacaClient;
import macaca.client.commands.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dengwei on 18/10/2017.
 */
public class IOSSampleTest {

    MacacaClient driver = new MacacaClient();


    @Before
    public void setUp() throws Exception {
        // platform: android or ios
        String platform = "ios";

        /*
           Desired Capabilities are used to configure webdriver when initiating the session.
           Document URL: https://macacajs.github.io/desired-caps.html
         */
        JSONObject porps = new JSONObject();
        porps.put("platformName", "iOS");
//        porps.put("app", "https://npmcdn.com/ios-app-bootstrap@latest/build/ios-app-bootstrap.zip");
        porps.put("reuse", 3);
        porps.put("udid","00e630def672da63ed0bae762c3d78aebb67ea8d");
        porps.put("deviceName", "iPhone 6s");
        porps.put("autoAcceptAlerts", true);
        porps.put("bundleId", "com.autonavi.amaptestmonkey");

        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        driver.initDriver(desiredCapabilities);
    }

    @Test
    public void test_case_1() throws Exception {
        // set screenshot save path
        String content = driver.source();
        Element element =  driver.elementByName("路线");
        System.out.println("text: " + element.getText());
        System.out.println("isVisible: " + element.isDisplayed());
        System.out.println("isEnabled: " + element.getComputedCss("clickable"));

    }

    public void customBack() {
        // iOS通过视图的右滑完成返回操作
        try {
//            driver.drag(0, 100, 300, 100, 0.5);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
