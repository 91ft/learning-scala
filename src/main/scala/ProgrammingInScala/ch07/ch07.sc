import java.io._

//val test = 1
//val filename =
//  if (test == 1) "One"
//  else "Else"
//
//println(filename)

//def gcdLoop(x: Long, y: Long): Long = {
//  var a = x
//  var b = y
//  while(a != 0) {
//    val temp = a
//    a = b%a
//    b = temp
//  }
//  b
//}

//def greet() { println("hi") }
//greet() == ()
//
//var line = ""
//while((line = readLine()) != "")
//  println(line)


val filesHere = (new java.io.File(".")).listFiles
//for(
//  file <- filesHere
//  if file.isFile
//  if file.getName.endsWith(".py")
//) println(file)

//def fileLines(file: java.io.File) =
//  scala.io.Source.fromFile(file).getLines().toList
//
//def grep(pattern: String) =
//  for {
//    file <- filesHere
//    if file.getName.endsWith(".py")
//    line <- fileLines(file)
//    trimmed = line.trim
//    if trimmed.matches(pattern)
//  } println(file + ": " + trimmed)
//
//grep(".*")
//
//val forLineLength =
//  for {
//    file <- filesHere
//    if file.getName.endsWith(".py")
//  } yield file.length()

//try {
//  val f = new FileReader("input.txt")
//} catch {
//  case ex: FileNotFoundException => ???
//  case ex: IOException => ???
//}
//
//val args: Array[String] = Array("abc.x","bbbb.py","harley.scala","who.java")
//def searchFrom(i: Int): Int =
//  if (i >= args.length) -1
//  else if(args(i).startsWith("-")) searchFrom(i + 1)
//  else if(args(i).endsWith(".scala")) i
//  else searchFrom(i + 1)
//
//val i = searchFrom(0)
//
def makeRowSeq(row: Int) = {
  for(col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }
}

def makeRow(row: Int) = makeRowSeq(row).mkString

def multiTable() = {
  val tableSeq =
    for(row <- 1 to 10)
      yield makeRow(row)
  tableSeq.mkString("\n")
}

multiTable