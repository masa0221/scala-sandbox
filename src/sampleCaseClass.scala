object sampleCaseClass extends App {
  val u = new Book(12345L, "john")
  println(u)
  println(Book(22222L, "hoge"))
  println(Book.testmethod())
  println(Book.unapply(Book(22222L, "hoge")))

  println(User("john", "user@example.com"))
  println(User("john", "user@example.com"))
}

class Book (val id: Long, val name: String)

object Book {
  def apply(id: Long, name: String): Book = new Book(id, name)
  def testmethod(): Book = new Book(33333L, "test")
  def unapply(book: Book): Option[(Long, String)] =
    Some(book.id, book.name)
}

case class User (name: String, email: String)
// class User (val name: String,val email: String)

// caseクラスを使う場合はこれ使えない？
// object User {
//   // def apply(name: String, email: String): Book = new Book(33333L, "test")
//   def apply(name: String, email: String): User = new User(name, email)
// }
