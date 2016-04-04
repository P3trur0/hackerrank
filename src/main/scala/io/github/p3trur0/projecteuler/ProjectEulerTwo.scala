package io.github.p3trur0.projecteuler

import scala.io.StdIn.readLine
import scala.annotation.tailrec

/**
 * 
 * Project Euler #2: Even numbers Fibonacci
 * 
 */
object ProjectEulerTwo {
  def execute(limit: Long): Long = {
   evenNumbersFibonacci(0, 1, limit, 0)
  } 
  
  /**
   * In order to avoid any unecessary Fibonacci recalculation it could be worth to store all the even data in a structure.
   * Then, each time the even numbers are required, we can directly access the store data structure.
   */
  @tailrec
  private def evenNumbersFibonacci(nMinusTwo: Long, nMinusOne: Long, limit: Long, result: Long): Long = {
    val nextResult = nMinusTwo + nMinusOne
    nextResult match {
      case x if x>=limit => result
      case x if(x%2==0) => evenNumbersFibonacci(nMinusOne, nextResult, limit, result+nextResult)
      case _=> evenNumbersFibonacci(nMinusOne, nextResult, limit, result) 
    }
  }
}

