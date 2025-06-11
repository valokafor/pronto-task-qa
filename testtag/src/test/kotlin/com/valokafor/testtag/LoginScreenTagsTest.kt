package com.valokafor.testtag

import kotlin.test.Test
import kotlin.test.assertEquals

class LoginScreenTagsTest {
    @Test
    fun `verify login screen tags are correctly defined`() {
        assertEquals("emailField", LoginScreenTags.EMAIL_FIELD)
        assertEquals("passwordField", LoginScreenTags.PASSWORD_FIELD)
        assertEquals("passwordVisibilityToggle", LoginScreenTags.PASSWORD_VISIBILITY_TOGGLE)
        assertEquals("forgotPasswordButton", LoginScreenTags.FORGOT_PASSWORD_BUTTON)
        assertEquals("signInButton", LoginScreenTags.SIGN_IN_BUTTON)
        assertEquals("signUpButton", LoginScreenTags.SIGN_UP_BUTTON)
    }
}