package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  var aVariable = 2
  aVariable += 3

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeiredValue = (aVariable = 3) // Unit === void
  println(aWeiredValue)

  // side effects: println(), whiles, reassigning

  // Cod blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
}
