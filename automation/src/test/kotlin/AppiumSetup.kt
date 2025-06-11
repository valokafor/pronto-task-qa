import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.UUID

open class AppiumSetup {
    companion object {
        private const val activityName = "com.valokafor.MainActivity"
        private const val packageName = "com.valokafor.prontotask"
        private const val platformName = "Android"
        private const val automationName = "UiAutomator2"
        private const val serverUrl = "http://127.0.0.1:4723/wd/hub"
        private val uuid = UUID.randomUUID().toString()

        lateinit var driver: AndroidDriver
        private val capabilities = DesiredCapabilities()

        @JvmStatic
        @BeforeAll
        fun setup() {
            val options = UiAutomator2Options(capabilities)
                .setAppPackage(packageName)
                .setAppActivity(activityName)
                .setUdid(uuid)
                .setNoReset(false)
                .autoGrantPermissions()
            driver = AndroidDriver((URL(serverUrl)), options)
            driver.setSetting("disableIdLocatorAutocompletion", true)
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            driver.quit()
        }
    }
}