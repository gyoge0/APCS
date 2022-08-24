fun properties(key: String) = project.findProperty(key).toString()

@Suppress("SpellCheckingInspection")
plugins {
    `kotlin-dsl`
    id("com.diffplug.spotless") version "6.9.1"
}

dependencies {
    @Suppress("SpellCheckingInspection")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.9.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
}

group = "com.gyoge.apcs"

repositories {
    mavenCentral()
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.languageVersion = properties("jvmTarget").toString()
    }
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
