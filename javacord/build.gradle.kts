plugins {
    id("tehlib.java-conventions")
}

dependencies {
    api(project(":tehlib-core"))

    api("cloud.commandframework", "cloud-javacord", "1.6.1")
    api("org.javacord:javacord:3.4.0")
}
