package com.valokafor.automation

import com.valokafor.testtag.LoginScreenTags
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestRunnerTest {
    @Test
    fun `verify test runner can access test tags`() {
        val runner = TestRunner()
        assertNotNull(runner)
        
        // Verify we can access tags from testtag module
        assertNotNull(LoginScreenTags.EMAIL_FIELD)
        assertNotNull(LoginScreenTags.PASSWORD_FIELD)
    }
    
    @Test
    fun `test runner prints tags without error`() {
        val runner = TestRunner()
        // This should not throw any exception
        runner.printLoginScreenTags()
    }
}