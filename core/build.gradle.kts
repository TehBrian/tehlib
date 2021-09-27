plugins {
    id("tehlib.java-conventions")
}

repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
}

dependencies {
    api("cloud.commandframework", "cloud-core", "1.5.0")
    api("org.spongepowered:configurate-core:4.0.0")
}
