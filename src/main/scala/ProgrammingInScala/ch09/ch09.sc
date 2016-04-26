object FileMatcher {
  private def fileHere = (new java.io.File(".")).listFiles()

  private def fileMatching(matcher: String => Boolean) =
    for(file <- fileHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    fileMatching(_.endsWith(query))

  def filesContaining(query: String) =
    fileMatching(_.contains(query))

  def filesRegex(query: String) =
    fileMatching(_.matches(query))
}


FileMatcher.filesEnding(".py")
FileMatcher.filesRegex(".*env.*")
FileMatcher.filesContaining("env")

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)

val onePlus = curriedSum(1)_
onePlus(2)

def twice(op: Double => Double, x: Double) = op(op(x))

twice(_ + 1, 2)

