plugins {
    id("tehlib.java-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    api("cloud.commandframework", "cloud-core", "1.7.0")
    api("org.spongepowered:configurate-core:4.1.2")
}
