plugins {
    id("net.kyori.indra.publishing.sonatype") version "2.0.1"
}

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
}
