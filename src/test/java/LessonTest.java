import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//TC_1_1  - Тест кейс:
//1. Открыть страницу https://openweathermap.org/
//2. Набрать в строке поиска город Paris
//3. Нажать пункт меню Search
//4. Из выпадающего списка выбрать Paris, FR
//5. Подтвердить, что заголовок изменился на "Paris, FR"
public class LessonTest {

    @Test
    public void testH2Text_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//input[@placeholder = 'Search city']" )
        );
        Thread.sleep(5000);

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(5000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();
        Thread.sleep(5000);

        WebElement h2CityContryHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );

        Thread.sleep(5000);

        String actualResult = h2CityContryHeader.getText();
        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();
      //  driver.close();
    }




//    @Test
//    public void testName(){
//        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
//        WebDriver driver = new ChromeDriver();


//        driver.quit();
//        driver.close();
//    }




}
