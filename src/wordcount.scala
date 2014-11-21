import scala.annotation.tailrec

object wordcount extends App {
  val lines = List(
    "apple banana",
    "orange apple mango",
    "kiwi papaya orange",
    "mango orange muscat apple"
  )

  val fruitsCounts = countFruitsFromLines(lines)

  if (fruitsCounts == Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)) {
    println("正解")
  } else {
    println("不正解")
  }

  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    lines.flatMap(_.split(" ")).groupBy(identity).map(e => (e._1 -> e._2.size))
  }

  // def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
  //   var map = Map[String, Int]()
  //   for (line <- lines)
  //     for (word <- line.split(" ")) {
  //       // val hoge: (String, Int) = (word -> (map.getOrElse(word, 0) + 1))
  //       map += (word -> (map.getOrElse(word, 0) + 1))
  //     }
  //   map
  //   }

  println(fib(0))
  println(fib(1))
  println(fib(2))
  println(fib(3))
  println(fib(4))
  println(fib(5))
  println(fib(6))
  println(fib(7))
  println(fib(8))
  println(fib(9))
  println(fib(10))
  //println(fib(100))

  // fib(n) = fib(n - 2) + fib(n - 2 +1)
  def fib(n: Long): Long = {
    //    @tailrec
    //    def calc(n: Long, total: Long): Long = {
    //      if (n == 0) return 0
    //      if (total <= 2) return 1
    //
    //      calc(n - 2, total) + calc(n - 2 + 1, total)
    //    }
    //    calc(n, n)

    //    if (n < 2) return n
    //    fib(n - 2) + fib(n - 2 + 1)

    //   n match {
    //     case 0 | 1 => n
    //     case _ => fib(n - 2) + fib(n - 2 + 1)
    //    }
    //    calc(n, n)
    @tailrec
    def calc(l1: Long,l2: Long, cnt: Long): Long = {
      if (cnt < 2) return cnt

      calc(l1 + l2, l1, cnt - 1)
    }

    calc(n, 0, 0)
  }


  println(fact(0))
  println(fact(1))
  println(fact(2))
  println(fact(3))
  println(fact(4))
  println(fact(5))
  // println(fact(1000))

  def fact(n: Int): Long = {
    @tailrec
    def calc(n: Int, total: Long): Long = {
      if (n < 2) return total

      calc(n + 1, n * total)
    }

    calc(n, n)
  }


  println(getSum((1 to 100).toList))
  println(getSum((1 to 1000000).toList))

  def getSum(numbers: List[Int]): Long = {
    //    @tailrec
    //    def calc(n: Int, total: Long): Long = {
    //       calc(n, n + total)
    //    }

    //    var sum = 0
    //    for (n <- numbers)
    //     sum += n
    //
    //    return sum

    numbers.reduceLeft(_+_)
  }
}



