plugins {
    id("net.kyori.indra.publishing.sonatype") version "2.1.1"
}

group = "dev.tehbrian"
version = "0.2.0-SNAPSHOT"
description = "Some small, helpful utilities."

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
}
