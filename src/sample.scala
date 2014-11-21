import scala.util.Try
object sample extends App {
  val name: Option[String] = Some("Bob")
  // 中身が無い場合
  val age: Option[Int] = None

  println(name.get)
  println(age.getOrElse(3))


  val optOptNumber: Option[Option[Int]] = Some(Some(10))
  // ng
  // optOptNumber.get.get

  println(optOptNumber.flatten.map(_ * 2))
  println(optOptNumber flatMap { x => x })

  println(auth(Some("aaa"), Some("bbb")))
  println(auth(Some("John"), Some("password")))
  def auth(name: Option[String], password: Option[String]): Boolean = {
    (for {
      n <- name
      p <- password
    } yield n == "John" && p == "password"
    ).getOrElse(false)

    // Try[Int]
    // Either[Int]
    // result.getOrElse(false)
  }

  def uniq(list: List[Int]): List[Int] = {
    // Set: 重複を許さない型
    def loop(result: Set[Int], list: List[Int]): List[Int] = {
      list match {
        case x :: xs if result.contains(x) =>
          loop(result, xs)
        case x :: xs =>
          x :: loop(result + x, xs)
        case Nil => Nil
      }
    }

    loop(Set(), list)
  }

  println(uniq(List(1, 2, 3, 4, 5, 5)))


  case class UserName(firstName: String, lastName: String)

  case class User(id: Int, name: UserName)

  def userMatch(user: User): Unit = {
    user match {
      case User(id, UserName(firstname, lastname)) =>
        println(s"$firstname$lastname")
      case User(2, _) =>
        println("User(2, _)")
      case _ =>
        println("not found!")
    }
  }

  userMatch(User(2, UserName("test", "taro")))
}
