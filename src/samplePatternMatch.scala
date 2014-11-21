object samplePatternMatch extends App {
  seqMatch(Seq(1, 2))

  def seqMatch(seq: Seq[Int]):Unit = {
    seq match {
      case Seq(1) =>
        println("Seq(1)")
      case Seq(_, _) =>
        println("seq.size == 2")
      case Seq(a, b, c) =>
        println("seq.size == 3 a,b,cに値がバインドされる")
        println(a)
      case Seq(1, 2, 3, 4, _*) =>
        println("Seq(1, 2, 3, 4, .....)")
      case _ =>
        println("ふいっち")
    }
  }

  //  caseClassMatch(User(2L,UserName("john", "test")))
  //  caseClassMatch(User(3L,UserName("john", "test")))
  //  caseClassMatch(User(4L,UserName("John", "test")))
  //  caseClassMatch(User(4L,UserName("john", "test")))
  //   case class UserName(firstName: String, lastName: String)
  //
  //   case class User(id: Long, name: UserName)

  val username = new UserName("john", "test")
  caseClassMatch(new User(2L, username))
  // caseClassMatch(User(3L,UserName(Some("john", "test")))
  // caseClassMatch(User(4L,UserName(Some("John", "test")))
  // caseClassMatch(User(4L,UserName(Some("john", "test")))
  class UserName(val firstName: String, val lastName: String)
  object UserName {
    def unapply(userName: UserName): Option[(String, String)] = Some(userName.firstName, userName.lastName)
  }

  class User(val id: Long, val name: UserName)
  object User {
    def unapply(user: User): Option[(Long, UserName)] = Some(user.id, user.name)
  }
  def caseClassMatch(user: User):Unit = {
    user match {
      case User(2L, _) =>
        println("専務")
      case User(3L, name) =>
        println("変数にバインド")
        println(name.firstName)
      case User(id, UserName("John", _)) =>
        println("ネストさせた firstname が john のだけひっと")
      case _ =>
        println("ふいっち")
    }
  }
}

