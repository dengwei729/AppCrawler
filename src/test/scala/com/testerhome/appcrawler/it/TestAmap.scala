package com.testerhome.appcrawler.it

import java.net.URL

import com.testerhome.appcrawler.AppCrawler
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.openqa.selenium.remote.DesiredCapabilities
import org.scalatest.FunSuite

class TestAmap extends FunSuite{
  val capability=new DesiredCapabilities()
  capability.setCapability("app", "")
  capability.setCapability("appPackage", "com.autonavi.minimap")
  capability.setCapability("appActivity", "com.autonavi.map.activity.SplashActivity")
  capability.setCapability("waitAppActivity", ".UserGuideActivity")
  capability.setCapability("deviceName", "48f8f7fe")
  capability.setCapability("fastReset", "false")
  capability.setCapability("fullReset", "false")
  capability.setCapability("noReset", "true")
  capability.setCapability("unicodeKeyboard", "true")
  capability.setCapability("resetKeyboard", "true")
  capability.setCapability("automationName", "appium")

  test("all app "){
    capability.setCapability("app", "")
    capability.setCapability("appPackage", "com.xueqiu.android")
    capability.setCapability("appActivity", ".view.WelcomeActivityAlias")
    val driver=new AndroidDriver[AndroidElement](new URL("http://127.0.0.1:4723/wd/hub"), capability)

  }

  test("appcrawler-android"){
    AppCrawler.main(Array("-c", "src/test/scala/com/testerhome/appcrawler/it/testamap_android.yml",
      "-o", s"/Users/dengwei/Documents/amap-client/crawler/AppCrawler/amap_report")
    )
  }

  test("appcrawler-ios"){
    AppCrawler.main(Array("-c", "src/test/scala/com/testerhome/appcrawler/it/testamap_ios.yml",
      "-o", s"/Users/dengwei/Documents/amap-client/crawler/AppCrawler/amap_report")
    )
  }

}
