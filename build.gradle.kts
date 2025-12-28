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
    // Добавление зависимости JUnit Jupiter API для написания тестов
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    // Добавление движка JUnit Jupiter для запуска тестов
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    implementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}