plugins {
    id("effectivekotlin.kotlin.library")
}

group = "org.bmsk.core"
version = "1.0-SNAPSHOT"

tasks.test {
    useJUnitPlatform()
}
