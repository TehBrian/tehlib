plugins {
    id("tehlib.java-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":tehlib-core"))

    api("cloud.commandframework", "cloud-javacord", "1.6.2")
    api("org.javacord:javacord:3.4.0")
}
