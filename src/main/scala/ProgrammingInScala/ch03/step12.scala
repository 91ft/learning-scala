import scala.io.Source

//실행방법 : scala step12.scala step12.scala
//
//if (args.length > 0) {
//  val lines = Source.fromFile(args(0)).getLines().toList
//
//  def widthOfLength(s:String) = s.length.toString.length
//
//  var maxWidth = 0
//  for (line <- lines)
//    maxWidth = maxWidth.max(widthOfLength(line))
//
//  for(line <- lines) {
//    val numSpaces = maxWidth - widthOfLength(line)
//    val padding = " " * numSpaces
//    println(padding + line.length + " | " + line)
//  }
//} else {
//  Console.err.println("Please enter filename")
//}
