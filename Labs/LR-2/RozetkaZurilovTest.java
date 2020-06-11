import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RozetkaZurilovTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void rozetkaZurilov() {
    driver.get("https://www.rozetka.com.ua//");
    {
      WebElement element = driver.findElement(By.cssSelector(".menu-toggler__text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".menu-toggler"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".menu-toggler__text")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".menu-categories__item_state_hovered > .menu__hidden-content"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".menu-categories__link_state_hovered"));
      assert(elements.size() > 0);
    }
  }
}
