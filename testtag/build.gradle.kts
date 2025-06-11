plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "com.valokafor"
version = "1.0.0"

dependencies {
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}