plugins {
    id("tehlib.java-conventions")
}

dependencies {
    api(project(":tehlib-core"))

    api("cloud.commandframework", "cloud-javacord", "1.5.0")
    api("org.javacord:javacord:3.3.2")
}