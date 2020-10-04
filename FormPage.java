package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNames(final String firstName, final String lastName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void fillUsername(final String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void fillPassword(final String password) {
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
    }

    public void fillConfirmPasswd(final String confirmPasswd) {
        driver.findElement(By.xpath("//input[@aria-label='Confirm']")).sendKeys(confirmPasswd);
    }

    public void clickNext() {
        driver.findElement(By.id("accountDetailsNext")).click();
    }

    public boolean isSecondStepMsg() {
        return driver.findElement(By.xpath("//span[text()='Verify your phone number']")).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(By.xpath("//div[@aria-live='assertive']//div")).getText();
    }

}
