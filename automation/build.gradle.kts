plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":testtag"))
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.appium.java.client)
    testImplementation(libs.selenium.java)
}

tasks.test {
    useJUnitPlatform()
}