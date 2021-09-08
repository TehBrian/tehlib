plugins {
    id("tehlib.java-conventions")
}

repositories {
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    api(project(":tehlib-core"))

    api("cloud.commandframework", "cloud-paper", "1.5.0")
    api("net.kyori:adventure-text-minimessage:4.2.0-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}
