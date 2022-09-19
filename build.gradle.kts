plugins {
  id("net.kyori.indra.publishing.sonatype") version "2.2.0"
}

group = "dev.tehbrian"
version = "0.4.0"
description = "Some small, helpful utilities."

indraSonatype {
  useAlternateSonatypeOSSHost("s01")
}
