package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */

@Singleton
class PhibController extends Controller {

  def nthFibonacci(out: Int): Int = {
    var num_a = 0
    var num_b = 1
    var num_c = 1
    var i = 1

    while (i != out) {
      num_c = num_a + num_b
      num_a = num_b
      num_b = num_c
      i += 1
    }
    return num_c
  }

  def index(limit: Int) = Action {
    _ => {

      for (i <- 1 to limit){
        println(nthFibonacci(i))
      }
      Ok
    }
  }
}



/*package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.collection.immutable.ListMap

@Singleton
class PhibController extends Controller {

  def nthFibonacci(i: Int): Int = {
    if (i == 1 || i == 2)
      return i
    return nthFibonacci(i - 1) + nthFibonacci(i - 2)
  }

  def index(limit: Int) = Action {
    _ => {
      var mas : Array[Int] = new Array[Int](limit)
      val map = scala.collection.mutable.Map[String,String]()
      mas(0) = 1;
      for (i <- 1 to (mas.length - 1)){
          mas(i) = nthFibonacci(i)
          val num = nthFibonacci(i)
          map += "Element " + i.toString -> num.toString
      }

      Ok(" " + ListMap(map.toSeq.sortWith(_._1 < _._1):_*))
    }
  }
}*/
