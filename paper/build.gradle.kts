plugins {
    id("tehlib.java-conventions")
}

repositories {
    maven("https://papermc.io/repo/repository/maven-public/") {
        name = "papermc"
    }
}

dependencies {
    api(project(":tehlib-core"))

    api("cloud.commandframework", "cloud-paper", "1.6.0")
    api("net.kyori:adventure-text-minimessage:4.2.0-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}
