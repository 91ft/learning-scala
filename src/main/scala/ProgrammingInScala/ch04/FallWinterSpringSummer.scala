import ChecksumAccumulator.calculate

/**
  * Created by Harley on 2016. 4. 17..
  */
object FallWinterSpringSummer extends App {

  for (arg <- List("Spring","Summer","Fall","Winter")) {
    println(arg + ":"+calculate(arg))
  }
}
