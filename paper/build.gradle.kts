plugins {
  id("tehlib.java-conventions")
}

repositories {
  mavenCentral()
  maven("https://papermc.io/repo/repository/maven-public/") {
    name = "papermc"
  }
}

dependencies {
  api(project(":tehlib-user"))
  api(project(":tehlib-cloud"))
  api(project(":tehlib-configurate"))

  api("cloud.commandframework", "cloud-paper", "1.7.0")
  compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
}
