plugins {
  id("tehlib.java-conventions")
}

repositories {
  mavenCentral()
  maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
  api(project(":tehlib-configurate"))
  compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}
