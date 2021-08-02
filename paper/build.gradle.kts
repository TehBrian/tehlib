plugins {
    id("tehlib.java-conventions")
}

repositories {
    // for corn itembuilder, remove once its released
    mavenLocal()

    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    api(project(":tehlib-core"))
    api("broccolai.corn:corn-minecraft-paper:3.0.0-SNAPSHOT")
    api("cloud.commandframework", "cloud-paper", "1.5.0")

    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}
