plugins {
    id("com.gyoge.apcs.plugins.apcs-project")
}

sourceSets {
    create("finch") {
    }
    val main by getting {
        compileClasspath += sourceSets["finch"].output
        runtimeClasspath += sourceSets["finch"].output
    }
}