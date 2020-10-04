package step;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FormPage;

public class CreateAccountSteps {

    private static final String BASE_URL = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";

    private FormPage formPage;
    private ChromeDriver driver;

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Given("I open form page in browser")
    public void openFormPageInBrowser() {
        driver.navigate().to(BASE_URL);
        formPage = new FormPage(driver);
    }

    @When("I fill names {string} and {string}")
    public void fillNames(String firstName, String lastName) {
        formPage.fillNames(firstName, lastName);
    }

    @When("I fill username {string}")
    public void fillUsername(String username) {
        formPage.fillUsername(username);
    }

    @When("I fill password {string}")
    public void fillPassword(String password) {
        formPage.fillPassword(password);

    }

    @When("I fill confirm password {string}")
    public void fillConfirmPassword(String password) {
        formPage.fillConfirmPasswd(password);
    }

    @When("I click next")
    public void clickNext() {
        formPage.clickNext();
    }

    @Then("I should be shown the second step")
    public void getSecondStepMsg() {
        assertTrue(formPage.isSecondStepMsg());
    }

    @Then("I should be shown the error msg {string}")
    public void getErrorMsg(String msg) {
        assertThat(formPage.getErrorMsg(), is(msg));
    }

}
