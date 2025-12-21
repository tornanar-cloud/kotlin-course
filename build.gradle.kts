plugins {
    kotlin("jvm") version "2.2.0"
}

group = "ru.stimmax"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.13.2") // Убедитесь, что версия актуальная
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}