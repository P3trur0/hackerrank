package io.github.p3trur0.projecteuler

import scala.io.StdIn.readLine

/**
 * 
 * Project Euler #1: Multiples of 3 and 5
 * 
 */
object ProjectEulerOne {
  def execute(firstLimit: Long, secondLimit: Long, inputData: Long): Long = {
    Range.Long(firstLimit, inputData, firstLimit).sum + 
    Range.Long(secondLimit, inputData, secondLimit).sum - 
    Range.Long(firstLimit*secondLimit, inputData, firstLimit*secondLimit).sum
  } 
}

