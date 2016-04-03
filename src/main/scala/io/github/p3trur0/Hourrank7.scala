package io.github.p3trur0

import java.io.File
import java.util.Scanner

import scala.annotation.tailrec
import scala.collection.parallel.mutable.ParArray

//Exercise 1 of Hour Rank #7
object Solution1 {

	def main(args: Array[String]) {
		val sc = new java.util.Scanner(System.in);
		var N = sc.nextInt();
		var C = sc.next();

		println(solveExercise(N, C))
	}

	def solveExercise(number: Int, colorConfig: String): Int = {

			val config = colorConfig.toList.take(number)

					def recursive(strokes: Int, config: List[Char]): Int = {
				config match {
				case Nil                       => strokes
				case x :: Nil                  => strokes
				case x :: xs if (x == xs.head) => recursive(strokes, xs)
				case x :: xs                   => recursive(strokes + 1, xs)
				}
			}

			if(config.size <= 0)
				0
				else
					recursive(1, config)
	}

}

object Solution {

	def main(args: Array[String]) {
		//execution(io.Source.stdin)
		secondWay(new Scanner(System.in))
	}


	def secondWay(sc: Scanner) {
		var tests = sc.nextLine().toInt;

		println("tests "+tests)

		val range = (1 to tests)

		range.foreach { x => 
		var counter = sc.nextLine()
		var array = sc.nextLine()
	
		val data = array.split(" ").map{ x => new Integer(x) }.toList
		val elems = aggregator(data, ParArray(), 0)
		println(performCalculation3(elems(elems.size-1)._2, elems, 0, 0))
		}

	}

	def execution(inputData: scala.io.BufferedSource) {
		inputData.getLines.zipWithIndex.filter(p => p._2>0 && p._2%2==0).foreach{x => 
		val data = x._1.split(" ").map{ x => new Integer(x) }.toList
		val elems = aggregator(data, ParArray(), 0)
		//println(elems)
		println(performCalculation3(elems(elems.size-1)._2, elems, 0, 0))
		}

		//list.map { x => performCalculation(x,1,0) }.foreach(println(_))
	}

//	@tailrec
//	def performCalculation(array: ParArray[Integer], splitPlace: Integer, point: Integer): Int = {
//			if(splitPlace>=array.size)
//				return point
//
//						val split = array.splitAt(splitPlace)
//
//						val left = split._1.foldLeft(0)((a,b) => a+b)
//						val right = split._2.foldLeft(0)((a,b) => a+b)
//
//						if(left == right) {
//							val splittedArray = if(split._1.size > split._2.size) split._1 else split._2
//									performCalculation(splittedArray, 1, point+1)
//						}
//						else
//							performCalculation(array, splitPlace+1, point)
//	}

	def aggregator(list: List[Integer], sum: ParArray[(Int, Int)], count: Int): ParArray[(Int, Int)] = {
			list match {
			case Nil => sum
			case x::Nil => sum.:+((x.intValue(), count+x))
			case x::xs => aggregator(xs, sum.:+((x.intValue(), count+x)), count+x)
			}
	}
	
	def performCalculation3(sumArray: Integer, array: ParArray[(Int, Int)], count: Integer, delta: Integer): Int = {
			if(sumArray == 0)
				array.size - 1

				else {
					val halfSum = sumArray/2
					val remaining = halfSum%2
					
					if(((sumArray%2==0 && remaining==0) || sumArray==2) && array.size>1) {
					   val droppedArray = array.dropWhile{x => x._2-delta <= halfSum }
					   	   
					  droppedArray.size match {
					     case 0 => count+1
					     case _ => performCalculation3(sumArray-halfSum, droppedArray, count+1, halfSum+delta)
					   }    
					}	
					else
					  count
				}
	}
	
	def performCalculation4(sumArray: Integer, array: List[(Int, Int)], count: Integer, point: Integer, delta: Integer): Int = {
	 
			if(sumArray == 0)
				array.size - 1
				
			else {
			  
			  if(array.size-count<=0)
			    point
			    
			  else {  
			  
				  val leftSectionAmount = array(array.size-count-1)._2 - delta
				  val rightSectionAmount = sumArray-leftSectionAmount
					
				  if(leftSectionAmount == rightSectionAmount) {
					  	performCalculation4(rightSectionAmount, array.drop(array.size-count), 1, point+1, rightSectionAmount+delta)
				  }
				
				  else
						performCalculation4(sumArray, array, count+1, point, delta)
				}
			}
				
	}
	


	
}