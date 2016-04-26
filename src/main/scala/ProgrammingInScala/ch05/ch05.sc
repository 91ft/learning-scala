var sum = 0x5
val hex = 0xFF
val magic = 0xcafebabe
//val a = 012
val b = 123L
var little: Short = 32767
//var little2: Short = 32768 //type mismatch
val anotherDouble = 3e5
val anotherDouble2 = 3e5D
println("""Hello World
    |Hello World2
    |Hello World3
    |Wow!!!! Amazing!""")

println("""Hello World
          |Hello World2
          |Hello World3
          |Wow!!!! Amazing!""".stripMargin)


def updateRecordByName(r: Symbol, value: Any): Unit = {
  // insert code
}

updateRecordByName('favoriteAlbum, "Ok Computer")

val s = 'aSymbol
s.name

val str = "Hello, World!"
str indexOf 'o'
str.indexOf('o',5)


-2.0
(2.0)unary_-

null == 1
1 == null
List(1,2,3) == "A"
"a" == "a"
("he"+"llo") == "hello"

val a1 = 0 max 5
val a2 = 0 min 5
val a3 = -2.7 abs
val a4 = -2.7 round
val a5 = (1.5).isInfinity
val a6 = (1.0/0) isInfinity
val a7 = 4 to 10
val a8 = "bob" capitalize
val a9 = "hoho" drop 2
