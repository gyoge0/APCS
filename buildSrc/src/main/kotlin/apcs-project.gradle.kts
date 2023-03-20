package com.gyoge.apcs.plugins

fun property(key: String) = project.findProperty(key).toString()

@Suppress("SpellCheckingInspection")
plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.gyoge.apcs:common")
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
    withType<JavaExec>().configureEach {
        if (name.endsWith("main()")) {
            notCompatibleWithConfigurationCache("JavaExec created by IntelliJ")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(property("jvmTarget")))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(property("jvmTarget")))
    }
}

spotless {
    java {
        importOrder("com.gyoge.apcs", "com.gyoge", "java", "javax", "")
        removeUnusedImports()
        toggleOffOn()

        licenseHeader("// Yogesh Thambidurai APCS 2022-23")
    }
    kotlin {
        ktlint()
        licenseHeader("// Yogesh Thambidurai APCS 2022-23")
        toggleOffOn()
    }
}
