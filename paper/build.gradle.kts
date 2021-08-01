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

    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")

    implementation("cloud.commandframework", "cloud-paper", "1.5.0")
}
