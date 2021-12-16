plugins {
    id("tehlib.java-conventions")
}

repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
}

dependencies {
    api("cloud.commandframework", "cloud-core", "1.6.0")
    api("org.spongepowered:configurate-core:4.1.2")
}
