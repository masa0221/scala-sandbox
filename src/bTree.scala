object bTree extends App {
  println("hello world")

  println(BTree(Leaf(1)))
  println(Branch(Leaf(1), 2, Leaf(3)))

  // val branch = Branch(Branch(Leaf(1), 2, Leaf(3)), 3, Leaf(5))
  val branch = Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))

  println("----------------------")
  println(branch.size)
  println(branch.sum)
  println(branch.avg)
  println(branch.max)
  println(branch.min)
  println(branch.min)

  println(branch.find(1))
  println(branch.find(2))
  println(branch.find(4))
  println(branch.find(7))
  //
  // println(node)val node: Node = BTree.find(1)
  // println(test)
  // val test: Boolean = 1 == 1

  // def div(n: Int, m: Int) = {
  //   if (m != 0) Some(n / m) else None
  // }
  // println(div(1, 2))
  // println(div(1, 0))
  //  println(div(1, 2).isEmpty)
}
trait Node {
  val value: Int
  val size: Int
  val sum: Int
  val avg: Int
  val max: Int
  val min: Int
  def find(key: Int): Option[Node]
  // Option["String"]
  // 入っているときはSame
  // None は入っていない時
  // get() o
  // getOrElse("hoge")
}

case class Branch(left: Node, value: Int, right: Node) extends Node {
  val size = left.size + right.size + 1
  val sum = left.sum + right.sum + value
  val avg = sum / size
  val max = right.max
  val min = left.min
  //def find(key: Int): Option[Node] = {
  //  if (value == key) {
  //    Some(this)
  //  }else if (left.find(key).isDefined) {
  //    Some(left)
  //  } else if (right.find(key).isDefined) {
  //    Some(right)
  //  } else {
  //    None
  //  }
  //  }
  def find(key: Int): Option[Node] = {
    if (value == key) {
      Some(this)
    }else if (value > key) {
      left.find(key)
    } else {
      right.find(key)
    }
  }
}

case class Leaf(value: Int) extends Node {
  val size = 1
  val sum = value
  val avg = sum
  val max = value
  val min = value
  def find(key: Int): Option[Node] = if (this.value == key) Some(this) else None
}

case class BTree(node: Node) {
}

