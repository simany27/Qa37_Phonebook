package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password){
//        WebElement emailInput = wd.findElement(By.cssSelector("input[name='email']"));
//        WebElement passwordInput = wd.findElement(By.xpath("//input[@name='password']"));
//
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
//
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        type(By.cssSelector("input[name='email']"), email);
        type(By.xpath("//input[@name='password']"), password);
    }

    public void fillLoginRegistrationForm(User user){
        type(By.cssSelector("input[name='email']"), user.getEmail());
        type(By.xpath("//input[@name='password']"), user.getPassword());
    }

    public void submitLogin(){
        click(By.xpath("//button[@name='login']"));
    }

    public void submitRegistration(){
        click(By.cssSelector("button[name='registration']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertPresent(String message) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        if(alert != null && alert.getText().contains(message)){
            alert.accept();
//            alert.dismiss();
            return true;
        } else {
            return false;
        }
    }
}
