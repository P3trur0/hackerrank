package io.github.p3trur0

object Hello extends App {

  val firstline = Console.in.readLine()
  val secondLine = Console.in.readLine()

  Exercise.processLines(firstline, secondLine)
}

//Exercise example
object Exercise {

  def processLines(first: String, second: String): String = {

    val firstArray = first.split(" ").map { x => new Integer(x) }
    val secondArray = first.split(" ").map(x => new Integer(x))

    def pagesPerChapter(): Array[(Range, Int, Int)] = {

      var counter = 0
      
      secondArray.map { x =>
        val numOfPages = x / firstArray(1)
        val remainingPage = firstArray(1) % x match {
          case x if x > 0 => new Integer(1)
          case _          => new Integer(0)
        }

        ((1 to x.intValue()), counter, counter + (numOfPages + remainingPage))
      }
    }
    
    val pages = pagesPerChapter().take(firstArray(0).intValue()).toList
    
     pages.foldLeft(0)((a,b) => if(b._1.contains(b._2) || b._1.contains(b._3)) a + 1 else a).toString

  }

}
