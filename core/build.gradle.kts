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
    api("net.kyori:adventure-text-minimessage:4.2.0-SNAPSHOT")
}
