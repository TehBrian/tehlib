plugins {
    `java-library`
    id("org.checkerframework")
    id("net.kyori.indra")
    id("net.kyori.indra.checkstyle")
    id("net.kyori.indra.publishing")
}

group = "dev.tehbrian"
version = "0.1.0-SNAPSHOT"
description = "Some small, helpful utilities."

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.0-alpha1")
}

indra {
    javaVersions {
        target(16)
    }

    mitLicense()

    configurePublications{
        pom {
            url.set("https://github.com/TehBrian/tehlib")

            developers {
                developer {
                    name.set("TehBrian")
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
