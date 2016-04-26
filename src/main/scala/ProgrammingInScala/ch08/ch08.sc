//val someNumbers = List(-11, -10, -5, 0, 5, 10)
//someNumbers.foreach(x => println(x))
//someNumbers.filter(x => x > 0)
//someNumbers.filter(_ > 0)
//val f = (_: Int) + (_: Int)
//val f2 = (_: Int) + (_: Int)+ (_: Int)
//f(5, 10)
//f2(5, 10, 20)
//someNumbers.foreach(println)
//def sum(a: Int, b: Int, c: Int) = a + b + c
//sum(1,2,3)
//val a = sum _
//a(1,2,3)
//val b = sum(1, _:Int, 3)
//b(2)

var more = 1
//val addMore = (x: Int) => x + more
//addMore(10)
//more = 9999
//addMore(10)
//
//var mySum = 0
//someNumbers.foreach(mySum += _)
//mySum
//
//def makeIncreaser(more: Int) = (x: Int) => x + more
//val inc1 = makeIncreaser(1)
//inc1(10)
//val inc9999 = makeIncreaser(9999)
//inc9999(10)
//
//
//def speed(distance: Float, time:Float):Float = distance / time
//speed(distance = 100, time = 10)
//
//def printTime(out: java.io.PrintStream = Console.out) =
//  out.println("time = " + System.currentTimeMillis())
//
//printTime()

//def boom(x: Int): Int =
//  if(x==0) throw new Exception("boom!")
//  else boom(x - 1) + 1 // 1을 더하고 있어 재귀호출 아님
//boom(3)

def bang(x: Int): Int =
  if(x == 0) throw new Exception("bang!")
  else bang(x-1)
bang(3)