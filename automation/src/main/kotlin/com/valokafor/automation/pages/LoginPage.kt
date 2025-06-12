package com.valokafor.automation.pages

import com.valokafor.testtag.LoginScreenTags
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

class LoginPage(private val driver: AndroidDriver) {
    
    // Page Elements
    private val rootView: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.ROOT_VIEW))
    
    private val emailField: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.EMAIL_FIELD))
    
    private val passwordField: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.PASSWORD_FIELD))
    
    private val passwordVisibilityToggle: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.PASSWORD_VISIBILITY_TOGGLE))
    
    private val forgotPasswordButton: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.FORGOT_PASSWORD_BUTTON))
    
    private val signInButton: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.SIGN_IN_BUTTON))
    
    private val signUpButton: WebElement
        get() = driver.findElement(AppiumBy.accessibilityId(LoginScreenTags.SIGN_UP_BUTTON))
    
    // Page Actions
    fun isPageDisplayed(): Boolean {
        return rootView.isDisplayed
    }
    
    fun enterEmail(email: String): LoginPage {
        emailField.click()
        emailField.clear()
        emailField.sendKeys(email)
        return this
    }
    
    fun enterPassword(password: String): LoginPage {
        passwordField.click()
        passwordField.clear()
        passwordField.sendKeys(password)
        return this
    }
    
    fun getEmailText(): String {
        return emailField.getText()
    }
    
    fun getPasswordText(): String {
        return passwordField.getText()
    }
    
    fun clearEmail(): LoginPage {
        emailField.clear()
        return this
    }
    
    fun clearPassword(): LoginPage {
        passwordField.clear()
        return this
    }
    
    fun togglePasswordVisibility(): LoginPage {
        passwordVisibilityToggle.click()
        return this
    }
    
    fun clickSignIn(): LoginPage {
        signInButton.click()
        return this
    }
    
    fun clickSignUp(): LoginPage {
        signUpButton.click()
        return this
    }
    
    fun clickForgotPassword(): LoginPage {
        forgotPasswordButton.click()
        return this
    }
    
    // Verification Methods
    fun isEmailFieldVisible(): Boolean = emailField.isDisplayed
    fun isEmailFieldEnabled(): Boolean = emailField.isEnabled
    
    fun isPasswordFieldVisible(): Boolean = passwordField.isDisplayed
    fun isPasswordFieldEnabled(): Boolean = passwordField.isEnabled
    
    fun isPasswordToggleVisible(): Boolean = passwordVisibilityToggle.isDisplayed
    fun isPasswordToggleEnabled(): Boolean = passwordVisibilityToggle.isEnabled
    
    fun isForgotPasswordButtonVisible(): Boolean = forgotPasswordButton.isDisplayed
    fun isForgotPasswordButtonEnabled(): Boolean = forgotPasswordButton.isEnabled
    
    fun isSignInButtonVisible(): Boolean = signInButton.isDisplayed
    fun isSignInButtonEnabled(): Boolean = signInButton.isEnabled
    
    fun isSignUpButtonVisible(): Boolean = signUpButton.isDisplayed
    fun isSignUpButtonEnabled(): Boolean = signUpButton.isEnabled
    
    // Utility Methods
    fun login(email: String, password: String): LoginPage {
        return enterEmail(email)
            .enterPassword(password)
            .clickSignIn()
    }
    
    fun clearForm(): LoginPage {
        return clearEmail().clearPassword()
    }
    
    fun checkToastMessage(expectedText: String): Boolean {
        return try {
            val toast = driver.findElement(AppiumBy.xpath("//*[contains(@text,'$expectedText')]"))
            toast.isDisplayed
        } catch (e: Exception) {
            false
        }
    }
}