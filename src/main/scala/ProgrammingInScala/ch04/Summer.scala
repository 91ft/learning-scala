import ChecksumAccumulator.calculate

/**
  * Created by Harley on 2016. 4. 17..
  */
object Summer {

  def main(args: Array[String]): Unit = {
    for(arg <- args) {
      println(arg +" : " + calculate(arg))
    }
  }
}
