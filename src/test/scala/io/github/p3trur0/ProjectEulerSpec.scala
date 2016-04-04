package io.github.p3trur0

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.brokersquare.core.utils.MockFileLoaderLike
import io.github.p3trur0.projecteuler.ProjectEulerOne
import scala.io.Source
import java.util.Scanner
import io.github.p3trur0.projecteuler.ProjectEulerTwo

class ProjectEulerSpec extends FlatSpec with Matchers with MockFileLoaderLike {
  
  it should "evaluate properly project euler #1" in {
    withElapsedTime {
      val arr = Array(2, 10, 100)
      (1 to arr(0)).foreach{x => println(ProjectEulerOne.execute(3, 5, arr(x)))}
    }
  }
  
  it should "evaluate properly project euler #2" in {
    withElapsedTime {
      val arr = Array(2, 10, 100)
      (1 to arr(0)).foreach{x => println(ProjectEulerTwo.execute(arr(x)))}
    }
  }
  
}