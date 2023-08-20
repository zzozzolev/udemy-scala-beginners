package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(n: Int, accumulator: BigInt): BigInt =
      if (n <= 1) accumulator
      else factHelper(n - 1, n * accumulator) // TAIL RECURSION = Use recursive call as the LAST expression.

    factHelper(n, 1)
  }
  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  // 1. Concatenate a string n times.
  def concatString(n: Int, s: String): String = {
    @tailrec
    def concatHelper(n: Int, s: String, accumulator: String): String =
      if (n <= 0) accumulator
      else concatHelper(n - 1, s, s + accumulator)

    concatHelper(n, s, "")
  }
  println(concatString(5, "s"))

  // 2. isPrime function tail recursive.
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0)

    isPrimeHelper(n / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

  // 3. Fibonacci function, tail recursive.
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboHelper(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboHelper(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboHelper(2, 1,1)
  }
  println(fibonacci(4))
}
