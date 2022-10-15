plugins {
  id("net.kyori.indra.publishing.sonatype") version "3.0.1"
}

group = "dev.tehbrian"
version = "0.4.0"
description = "Some small, helpful utilities."

indraSonatype {
  useAlternateSonatypeOSSHost("s01")
}
