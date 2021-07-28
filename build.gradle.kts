plugins {
    id("net.kyori.indra.publishing.sonatype") version "2.0.1"
}

group = "dev.tehbrian"
version = "0.1.0"
description = "Some small, helpful utilites."

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
}
