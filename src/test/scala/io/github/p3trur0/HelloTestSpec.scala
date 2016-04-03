package io.github.p3trur0

import org.scalatest.Matchers
import org.scalatest.FlatSpec

class HelloTestSpec extends FlatSpec with Matchers {
  
  it should "flat spec test" in {
   
    true shouldBe true
    
  }
  
}