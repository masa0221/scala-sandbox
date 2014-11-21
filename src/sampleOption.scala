object sampleOption extends App {
  println(loginWithPIN(Some("john"), Some("secret"), Some("4623")))
  println(loginWithPIN(Some("xxx"), Some("secret"), Some("4623")))
  println(loginWithPIN(None, Some("secret"), Some("4623")))

  def loginWithPIN(name: Option[String], password: Option[String], pin: Option[String]): Boolean = {
    (for(n <- name; p <- password; pi <- pin) yield (n == "john" && p == "secret" && pi == "4623")).getOrElse(false)
  }
}
