import scala.collection.mutable.ArrayBuffer

val args: Array[String] = Array("Hello","Harley","What's","up?")

//var i = 0
//while (i < args.length) {
//  if (i != 0)
//    print(" ")
//  print(args(i))
//  i += 1
//}
//println()


//args.foreach( x => print(x+ " "))

//args.foreach(println)

for (arg <- args) {
  println(arg)
}
