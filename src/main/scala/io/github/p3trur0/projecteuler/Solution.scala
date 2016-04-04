package io.github.p3trur0.projecteuler

import scala.io.StdIn.readLine

object Solution {

  def main(args: Array[String]) {
   projectEulerTwo()
  }
  
  private def projectEulerTwo() = {
    var input = readLine.toInt
    (1 to input).foreach { x => println(ProjectEulerTwo.execute(readLine.toLong)) }
  }
  
  private def projectEulerOne() = {
    var input = readLine.toInt
    (1 to input).foreach { x => println(ProjectEulerOne.execute(3, 5, readLine.toLong)) }
  }

}