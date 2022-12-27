plugins {
  id("net.kyori.indra.publishing.sonatype") version "3.0.1"
  id("com.github.ben-manes.versions") version "0.44.0"
}

group = "dev.tehbrian"
version = "0.4.0"
description = "Some small, helpful utilities."

indraSonatype {
  useAlternateSonatypeOSSHost("s01")
}
