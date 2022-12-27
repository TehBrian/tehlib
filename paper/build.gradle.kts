plugins {
  id("tehlib.java-conventions")
}

repositories {
  mavenCentral()
  maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
  api(project(":tehlib-user"))
  api(project(":tehlib-cloud"))
  api(project(":tehlib-configurate"))

  api("cloud.commandframework:cloud-paper:1.8.0")
  compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}
