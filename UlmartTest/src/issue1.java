import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class issue1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.ulmart.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIssue1() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertTrue(isElementPresent(By.id("searchField")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id=\"b-dropdown-catalog-menu\"]/span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//span[text()=\"Спорт и Туризм\"]")).click();
    try {
      assertEquals("https://www.ulmart.ru/catalog/tourism_goods", driver.getCurrentUrl());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Спорт и Туризм", driver.findElement(By.xpath("//h1[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[1]/div/div/div/div[2]/div/div/section[1]/div/div[1]/ul/li[7]/a")).click();
    try {
      assertTrue(driver.getCurrentUrl().matches("^https://www\\.ulmart\\.ru/catalog/[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Тренажеры", driver.findElement(By.xpath("//h1[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Велотренажеры", driver.findElement(By.xpath("//span[text()=\"Велотренажеры\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Портативные", driver.findElement(By.xpath("//span[text()=\"Портативные\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Вертикальные", driver.findElement(By.xpath("//span[text()=\"Вертикальные\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Горизонтальные", driver.findElement(By.xpath("//span[text()=\"Горизонтальные\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//span[text()=\"Вертикальные\"]")).click();
    try {
      assertEquals("Вертикальные", driver.findElement(By.xpath("//h1[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.id("catalogGoodsBlock")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String Name = driver.findElement(By.xpath("//div[@id=\"catalogGoodsBlock\"]/section[1]/div/div/div[@class=\"b-product__title\"]/span/a")).getText();
    String Article = driver.findElement(By.xpath("//div[@id=\"catalogGoodsBlock\"]/section[1]/div/div/div/div[@class=\"b-product__art\"]/span")).getText();
    try {
      assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Купить')])[17]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id=\"catalogGoodsBlock\"]/section[1]/div/div/div/a[text()=\"Купить\"]")).click();
    try {
      assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/addedToCart[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Товар добавлен в корзину!", driver.findElement(By.xpath("//h1[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Перейти в корзину", driver.findElement(By.xpath("//span[text()=\"Перейти в корзину\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("click", driver.findElement(By.xpath("//span[text()=\"Перейти в корзину\"]/parent::a")).getAttribute("data-gtm-eventaction"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//span[text()=\"Перейти в корзину\"]/parent::a")).click();
    try {
      assertEquals("https://www.ulmart.ru/cart", driver.getCurrentUrl());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Ваша корзина", driver.findElement(By.xpath("//h1[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1 шт.", driver.findElement(By.xpath("//div[@class=\"count goodsabbr\"][text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(Name, driver.findElement(By.xpath("//div[@class=\"icol n title\"]/a[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Артикул " + Article, driver.findElement(By.xpath("//div[@class=\"icol n title\"]/span[text()]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("(//button[contains(text(),\"Очистить корзину\")])")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("(//button[contains(text(),\"Очистить корзину\")])")).click();
    try {
      assertTrue(isElementPresent(By.xpath("//p[contains(text(),\"Ваша корзина пуста.\")]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
