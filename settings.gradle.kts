rootProject.name = "tehlib"

projects(
    "user",
    "cloud",
    "configurate",
    "paper",
    "javacord"
)

fun projects(vararg names: String) {
  include(*names)

  names.forEach {
    project(":$it").name = "tehlib-$it"
  }
}
