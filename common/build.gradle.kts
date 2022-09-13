fun properties(key: String) = project.findProperty(key).toString()

@Suppress("SpellCheckingInspection")
plugins {
    kotlin("jvm") version "1.7.10"
    id("com.diffplug.spotless") version "6.9.1"
}

dependencies {
    implementation(kotlin("test"))
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

group = "com.gyoge.apcs"

repositories {
    mavenCentral()
}

tasks.withType<com.diffplug.gradle.spotless.SpotlessCheck> {
    dependsOn("spotlessApply")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(properties("jvmTarget")))
    }
}

spotless {
    kotlin {
        ktlint()
        licenseHeader("// Yogesh Thambidurai APCS 2022-23")
    }
}
