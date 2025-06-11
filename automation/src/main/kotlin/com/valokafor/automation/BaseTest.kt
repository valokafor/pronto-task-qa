package com.valokafor.automation

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.net.URL
import java.time.Duration

abstract class BaseTest {
    protected lateinit var driver: AndroidDriver
    
    @BeforeEach
    fun setUp() {
        val options = UiAutomator2Options().apply {
            // Device configuration
            setDeviceName("Android Emulator")
            setPlatformName("Android")
            setPlatformVersion("34")
            
            // App configuration
            setAppPackage("com.valokafor.prontotask")
            setAppActivity("com.valokafor.prontotask.MainActivity")
            
            // Automation configuration
            setAutomationName("UiAutomator2")
            setNewCommandTimeout(Duration.ofSeconds(300))
            setAppWaitTimeout(Duration.ofSeconds(30))
            
            // Optional: Install app from local APK
            // setApp("/path/to/app.apk")
            
            // Don't reset app state between tests
            setNoReset(true)
            setFullReset(false)
        }
        
        driver = AndroidDriver(URL("http://localhost:4723"), options)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }
    
    @AfterEach
    fun tearDown() {
        if (::driver.isInitialized) {
            driver.quit()
        }
    }
}