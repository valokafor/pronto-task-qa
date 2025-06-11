package com.valokafor.automation

import com.valokafor.testtag.LoginScreenTags

/**
 * Sample test runner class that demonstrates usage of test tags from the testtag module.
 */
class TestRunner {
    fun printLoginScreenTags() {
        println("Login Screen Test Tags:")
        println("- Email Field: ${LoginScreenTags.EMAIL_FIELD}")
        println("- Password Field: ${LoginScreenTags.PASSWORD_FIELD}")
        println("- Password Visibility Toggle: ${LoginScreenTags.PASSWORD_VISIBILITY_TOGGLE}")
        println("- Forgot Password Button: ${LoginScreenTags.FORGOT_PASSWORD_BUTTON}")
        println("- Sign In Button: ${LoginScreenTags.SIGN_IN_BUTTON}")
        println("- Sign Up Button: ${LoginScreenTags.SIGN_UP_BUTTON}")
    }
}