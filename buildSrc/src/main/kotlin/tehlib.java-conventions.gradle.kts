plugins {
	`java-library`
	id("net.kyori.indra")
	id("net.kyori.indra.checkstyle")
	id("net.kyori.indra.publishing")
}

group = rootProject.group
version = rootProject.version
description = rootProject.description

dependencies {
	implementation("org.jspecify:jspecify:1.0.0")
}

indra {
	javaVersions {
		target(21)
	}

	github("TehBrian", "tehlib")

	mitLicense()

	publishReleasesTo("thbn", "https://repo.thbn.me/releases")
	publishSnapshotsTo("thbn", "https://repo.thbn.me/snapshots")

	configurePublications {
		pom {
			url.set("github.com/TehBrian/tehlib")

			developers {
				developer {
					id.set("TehBrian")
					url.set("https://tehbrian.xyz")
					email.set("tehbrian@proton.me")
				}
			}

			scm {
				connection.set("scm:git:git://github.com/TehBrian/tehlib.git")
				developerConnection.set("scm:git:ssh://github.com/TehBrian/tehlib.git")
				url.set("github.com/TehBrian/tehlib.git")
			}
		}
	}
}
