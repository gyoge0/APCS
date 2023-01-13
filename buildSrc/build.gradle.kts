fun property(key: String) = project.findProperty(key).toString()

@Suppress("SpellCheckingInspection")
plugins {
    `kotlin-dsl`
    id("com.diffplug.spotless") version "6.9.1"
}

dependencies {
    @Suppress("SpellCheckingInspection")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.9.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
}

group = "com.gyoge.apcs"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(property("jvmTarget")))
    }
}

tasks {
    withType<com.diffplug.gradle.spotless.SpotlessCheck> {
        dependsOn("spotlessApply")
    }
}

spotless {
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint()
    }
}
