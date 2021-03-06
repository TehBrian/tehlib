plugins {
    `java-library`
    id("net.kyori.indra")
    id("net.kyori.indra.checkstyle")
    id("net.kyori.indra.publishing")
}

group = rootProject.group
version = rootProject.version
description = rootProject.description

indra {
    javaVersions {
        target(17)
    }

    mitLicense()

    publishReleasesTo("thbn", "https://repo.thbn.me/releases")
    publishSnapshotsTo("thbn", "https://repo.thbn.me/snapshots")

    configurePublications {
        pom {
            url.set("https://github.com/TehBrian/tehlib")

            developers {
                developer {
                    id.set("TehBrian")
                    url.set("https://tehbrian.xyz")
                    email.set("tehbrian@protonmail.com")
                }
            }

            scm {
                connection.set("scm:git:git://https://github.com/TehBrian/tehlib.git")
                developerConnection.set("scm:git:ssh://https://github.com/TehBrian/tehlib.git")
                url.set("https://github.com/TehBrian/tehlib.git")
            }
        }
    }
}
