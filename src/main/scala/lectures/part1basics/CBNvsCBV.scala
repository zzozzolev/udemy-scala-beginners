package lectures.part1basics

object CBNvsCBV extends App {
  /*
  [Call by value]
  - value is computed before call.
  - same value used everywhere.

  [Call by name]
  - expression is passed literally.
  - expression is evaluated at every use within.
  */
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34) error
  printFirst(34, infinite()) // Never evaluated.
}
