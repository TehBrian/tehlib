plugins {
    id("net.kyori.indra.publishing.sonatype") version "2.1.1"
}

group = "dev.tehbrian"
version = "0.3.1"
description = "Some small, helpful utilities."

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
}
