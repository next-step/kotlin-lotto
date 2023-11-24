plugins {
    id("effectivekotlin.kotlin.library")
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "org.bmsk.presenter"
version = "1.0-SNAPSHOT"

tasks {
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}

dependencies {
    implementation(projects.domain)
}
