class Counter {
  private var value = 0
  def increment() = {
    value += 1
  }
  def current() = value

}

val myCoucnter = new Counter()
myCoucnter.increment()
myCoucnter.current()
myCoucnter.current
