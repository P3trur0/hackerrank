package io.github.p3trur0.template
/**
 * This is the companion object to be implemented for hackerrank exercise
 */
object Solution {

  def main(args: Array[String]) {
    //execution(io.Source.stdin)
    runFromScanner(new java.util.Scanner(System.in))
  }

  def runFromScanner(sc: java.util.Scanner) {
    var input = sc.nextLine()
    println(input)
  }

  def runFromStdin(inputData: scala.io.BufferedSource) {
    println(inputData.getLines)
  }
}

/**
 * Object used for local tests
 */
object TestSolution {
  /**
   * Utility function to evaluate the elapsed time of a function execution
   */
  def elapsedTime[R](function: => R): R = {
    val startTime = System.nanoTime()
    val result = function
    val endTime = System.nanoTime()
    println(s"Elapsed time is: ${(endTime - startTime) / 1000000} ms")
    result
  }

//  elapsedTime {
//    //Solution.runFromScanner(new java.util.Scanner(new File("~/testfiles/test3.file")))
//    Solution.runFromStdin(scala.io.Source.fromFile("~/testfiles/test.file", "utf-8"))
//  }
}


