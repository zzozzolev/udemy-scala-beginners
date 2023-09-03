package lectures.part2oop

import org.w3c.dom.css
import org.w3c.dom.css.Counter

import java.io
import java.io.Writer
import scala.annotation.tailrec

object OOBasics extends App {
//  val person = new Person("John", 26)
//  println(person.x)
//  person.greet("Daniel")
//  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.increase.print
  counter.increase.increase.increase.print
  counter.increase(10).print

}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameter are NOT FIELDS

/*
Novel and a Writer
*/
class Writer(first_name: String, surname: String, val year: Int) {
  def fullName(): String = s"$first_name $surname"
}

class Novel(name: String, year: Int, author: Writer) {

  def authorAge(): Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
Counter class
*/
class Counter(val count: Int = 0) {
  def increase: Counter = {
    println("incrementing")
    new Counter(count + 1)
  }
  def decrease: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increase(amount: Int): Counter = {
    if (amount <= 0) this
    else increase.increase(amount - 1)
  }

  def decrease(amount: Int): Counter = {
    if (amount <= 0) this
    else decrease.decrease(amount - 1)
  }

  def print = println(count)
}