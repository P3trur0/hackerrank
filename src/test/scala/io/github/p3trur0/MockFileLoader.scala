package com.brokersquare.core.utils

import scala.io.Source
import scala.util.Success
import scala.util.Try
import scala.io.BufferedSource

/**
 * Basic trait to load a fake file within the current class to be tested
 */
trait MockFileLoaderLike {

	/**
	 * It retrieves a Try value holding a file with fake content
	 */
	def accessResource(resourceName: String): Try[String] = {
			withMockData[Try[String]](resourceName) { resource => Success(resource) }
	}

	/**
	 * It wraps the file referred as resource name in the scope of the function f
	 */
	def withMockData[B](resourceName: String)(f: String => B): B = {
			val bufferSource = Source.fromURL(getClass.getResource(resourceName), "utf-8")
					try {
						f(bufferSource.mkString)
					} finally {
						bufferSource.close()
					}
	}
	
	def withElapsedTime[B](function: => B): B = {
    val startTime = System.nanoTime()
		val result = function
		val endTime = System.nanoTime()
		println(s"Elapsed time is: ${(endTime - startTime) / 1000000} ms")
		result
  }

}