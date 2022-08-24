package com.gyoge.apcs.plugins

fun properties(key: String) = project.findProperty(key).toString()

@Suppress("SpellCheckingInspection")
plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless")
}

dependencies {
    testImplementation(kotlin("test"))
}

group = "com.gyoge.apcs"

repositories {
    mavenCentral()
}

tasks {
    test {
        useJUnitPlatform()
    }
    withType<com.diffplug.gradle.spotless.SpotlessCheck> {
        dependsOn("spotlessApply")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(properties("jvmTarget")))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(properties("jvmTarget")))
    }
}

spotless {
    java {
        importOrder("com.gyoge.apcs", "com.gyoge", "java", "javax", "")
        removeUnusedImports()

        licenseHeader("// Yogesh Thambidurai APCS 2022-23")

        googleJavaFormat().aosp()
    }
    kotlin {
        ktlint()
        licenseHeader("// Yogesh Thambidurai APCS 2022-23")
    }
}
