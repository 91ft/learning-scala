import java.math.BigInteger

// Programming in Scala 3장. 스칼라 두 번째 걸음

/**
  * parameterization :
  * 인스턴스를 생성할 때 그 인스턴스를 설정(configure)한다는 뜻이다
  */

//val big = new BigInteger("12345")
//
//val greetStrings = new Array[String](3)
//greetStrings(0) = "Hello"
//greetStrings(1) = ","
//greetStrings(2) = "World!\n"
//
//for(i <- 0 to 2) {
//  print(greetStrings(i))
//}
//
//
//val greetStrings2: Array[String] = new Array[String](3)
//greetStrings2(0) = "Hoho"
//greetStrings2(0) = "HoHo"
//greetStrings2(0) = "HOHO"
//greetStrings2(1) = ","
//greetStrings2(2) = "HAHA\n"
//
//greetStrings2.update(0, "Hello~!")
//
//for(i <- 0 to 2) {
//  print(greetStrings2.apply(i))
//  //print(greetStrings2(i))
//}
//
//1 + 2
//
//(1).+(2)
//
//val numbers = Array(1,2,3)
//val strings = Array("a","b","c")
//val strings2 = Array.apply("a","b","c")
//
//val list1 = List(1,2,3)
//
//val oneTwo = List(1,2)
//val threeFour = List(3,4)
//val oneToFour = oneTwo ::: threeFour
//
//val addTen = 10 :: oneTwo
//oneTwo.::(20)

val oneToThree = 1 :: 2 :: 3 :: Nil

val thrill = List("will","all", "fill") ::: List("untill","still","hall")
//thrill(2)
//thrill.count(s => s.length == 2)
//thrill.drop(2)
//thrill.dropRight(3)
//thrill.exists(s => s == "ha")
//thrill.filter(s => s.length==4)
//thrill.forall(s => s.endsWith("l"))
//thrill.foreach(s => println(s))
//thrill.foreach(print)
//thrill.head
//thrill.init
//thrill.length
//thrill.isEmpty
//thrill.last
//thrill.map(s=>s+"y")
//thrill.mkString(",")
//val a = thrill.reverse
//("Hill" :: a).reverse
//thrill.sortWith((s,t) => s.charAt(0).toLower < t.charAt(0).toLower)
//thrill.tail

//val pair = (99, "Luftballons")
//println(pair._1)
//println(pair._2)

//var jetSet = Set("Boeing","Airbus")
//jetSet += "Lear"
//println("jetSet => " + jetSet)

import scala.collection.mutable.Set

//val movieSet = Set("Hitch","Poltergeist")
//movieSet += "Shrek"
//println("movieSet => " + movieSet)

//import scala.collection.immutable.HashSet
//var hashSet = HashSet("Tomatoes", "Chilies") //var -> val 변경 불가능
//println(hashSet += "Coriander")

//import scala.collection.mutable.Map
//val treasureMap = Map[Int, String]()
//treasureMap += (1 -> "Go to island")
//treasureMap += (2 -> "Find big X on ground")
//treasureMap += (3 -> "Dig")
//println(treasureMap(2))

//val romanNueral = Map(1->"I", 2->"II", 3->"III", 4->"IV", 5->"V")
//println(romanNueral(4))
//
//def formatArgs(args:Array[String]) = args.mkString("\n")
//
//val args: Array[String] = Array("zero","one", "two")
//
//println(formatArgs(args))

