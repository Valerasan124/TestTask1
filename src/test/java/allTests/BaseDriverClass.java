package allTests;

import lombok.Data;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Data
public class BaseDriverClass {

    protected WebDriver driver;

    @Rule
    public TestWatcher watcher;


    {
        watcher = new TestWatcher() {


            @Override
            protected void starting(Description description) {

                ChromeOptions cr = new ChromeOptions();

                URL hub = null;
                try {
                    hub = new URL("http://localhost:9515/");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(hub, cr);
            }


            @Override
            protected void succeeded(Description description) {

            }

            @Override
            protected void failed(Throwable e, Description description) {

            }


            @Override
            protected void finished(Description description) {

//                driver.quit();
//                if (driver != null) {
//                    driver.quit();
//                }


            }
        };
    }
}
