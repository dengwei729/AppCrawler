package crawler.macaca;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import macaca.client.MacacaClient;
import macaca.client.commands.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dengwei on 18/10/2017.
 */
public class AndroidSampleTest {
    MacacaClient driver = new MacacaClient();

    @Before
    public void setUp() throws Exception {

        /*
           Desired Capabilities are used to configure webdriver when initiating the session.
           Document URL: https://macacajs.github.io/desired-caps.html
         */
        JSONObject porps = new JSONObject();
        porps.put("platformName", "Android");
//        porps.put("app", "/Users/dengwei/Documents/amap-client/crawler/apk/amap_8.2.0.1051_internal_Autonavi_signed_201710161350_ae4ab27f424c8eafb94b8877dd75e97af3e7775f_master.apk");
        porps.put("reuse", 3);
        porps.put("udid", "5LM7N16112003808");
        porps.put("package", "com.autonavi.minimap");
        porps.put("activity", "com.autonavi.map.activity.SplashActivity");
        // device id
//        porps.put("udid","0715f7ea12391134");
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
    }

    // switch to the context of the last pushed webview
    public MacacaClient switchToWebView(MacacaClient driver) throws Exception {
        JSONArray contexts = driver.contexts();
        return driver.context(contexts.get(contexts.size() - 1).toString());
    }

    // switch to the context of native
    public MacacaClient switchToNative(MacacaClient driver) throws Exception {
        JSONArray contexts = driver.contexts();
        return driver.context(contexts.get(0).toString());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
