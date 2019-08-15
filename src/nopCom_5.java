import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class nopCom_5 {

    /*5.	ww.demo.nopcommerce.com, registering on this website. Once registered it then Logout and
 Login again with registered email address checking account holder's detail is correct?
a.	To verify is a message displayed "your registration completed" on registration completion?*/

        public static void main(String[] args) {

            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", "src\\Resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            //click for register
            driver.findElement(By.className("ico-register")).click();

            //click for male
            driver.findElement(By.id("gender-male")).click();
            //for first name
            driver.findElement(By.id("FirstName")).clear();
            driver.findElement(By.id("FirstName")).sendKeys("Dev");
            //for last name
            driver.findElement(By.id("LastName")).clear();
            driver.findElement(By.id("LastName")).sendKeys("patel");

            //for date of birth by select index
            Select BirthDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
            BirthDate.selectByIndex(15);

            //for month select by value
            Select Month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            Month.selectByValue("5");

            //for year select by visible text
            Select Year = new Select(driver.findElement(By.name("DateOfBirthYear")));
            Year.selectByVisibleText("1984");

            //for email
            driver.findElement(By.id("Email")).clear();
            driver.findElement(By.id("Email")).click();
            // creating unique number to get unique email
            String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
            driver.findElement(By.id("Email")).sendKeys("abcd" + userName + "@yahoo.com");

            //for company name
            driver.findElement(By.id("Company")).clear();
            driver.findElement(By.id("Company")).sendKeys("abcd");
            //for password
            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys("abcde@");
            //for confirm password
            driver.findElement(By.id("ConfirmPassword")).sendKeys("abcde@");
            driver.findElement(By.id("register-button")).click();

            //assert for massage" Your registration completed"
            String expectedResult = "Your registration completed";
            String actualResult = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
            Assert.assertEquals(expectedResult, actualResult);

            //click on logout
            driver.findElement(By.className("ico-logout")).click();
            //click on log in again
            driver.findElement(By.className("ico-login")).click();

            //for email
            driver.findElement(By.id("Email")).click();
            // String name = "" + (int) (Math.random() * Integer.MAX_VALUE);
            driver.findElement(By.id("Email")).sendKeys("abcd" + userName + "@yahoo.com");

            //for password
            driver.findElement(By.id("Password")).click();
            driver.findElement(By.id("Password")).sendKeys("abcde@");

            //for long in
            driver.findElement(By.xpath("//div[@class='buttons']/input[@class='button-1 login-button']")).click();
            //click on My account
            driver.findElement(By.className("ico-account")).click();

            driver.close();
        }

        }
