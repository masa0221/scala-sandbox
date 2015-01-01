sealed trait MyOption[+A] {
//  def get: A
//  def getOrElse[B >: A](elseValue: B): B
//  def isEmpty: Boolean
}

object MyOption {
  def apply[A](x: A): MyOption[A] = MyOption[A](x)
}

case class MySome[+A](x: A) extends MyOption[A]
object MySome {
}

case object MyNone extends MyOption[Nothing] {
}

object sampleOption2 extends App {
//  def mapTest(): Unit = {
//    val f = (n: Int) => n * 2
//    assert(MySome(100).map(f).get == Some(100).map(f).get)
//  }
//  def flatMapTest(): Unit = {
//    val f = (n: Int) => n * 10
//    assert(MySome(100).flatMap(e => MySome(f(e))).get == Some(100).flatMap(e => Some(f(e))).get)
//  }
//  def forTest(): Unit = {
//    val value = Some(Some(100))
//    val myValue = MySome(MySome(100))
//    val result = for {
//      a <- value
//      b <- a
//    } yield b + 1
//    val myResult = for {
//      a <- myValue
//      b <- a
//    } yield b + 1
//    assert(result.get == myResult.get)
//  }
//  def matchTest(): Unit = {
//    val f = (n: MyOption[Int]) => n match {
//      case MySome(v) => v
//      case MyNone => -1
//    }
//    val g = (n: Option[Int]) => n match {
//      case Some(v) => v
//      case None => -1
//    }
//
//    assert(f(MyNone) == g(None))
//    assert(f(MySome(100)) == g(Some(100)))
//  }
//  mapTest()
//  flatMapTest()
//  forTest()
//  matchTest()
}

