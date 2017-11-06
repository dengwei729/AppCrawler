package com.testerhome.appcrawler.it

import java.net.URL

import com.testerhome.appcrawler.AppCrawler
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.openqa.selenium.remote.DesiredCapabilities
import org.scalatest.FunSuite

class TestAmap extends FunSuite{

  test("appcrawler-android"){
    AppCrawler.main(Array("-c", "src/test/scala/com/testerhome/appcrawler/it/testamap_android.yml")
    )
  }

  test("appcrawler-ios"){
    AppCrawler.main(Array("-c", "src/test/scala/com/testerhome/appcrawler/it/testamap_ios.yml")
    )
  }

}
