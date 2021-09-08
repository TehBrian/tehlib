plugins {
    id("tehlib.java-conventions")
}

repositories {
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
}

dependencies {
    api("org.spongepowered:configurate-core:4.0.0")
    api("cloud.commandframework", "cloud-core", "1.5.0")
}
