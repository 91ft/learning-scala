import ch5._

var fred = new Person()
println(fred.age) //fred.age() 호출
fred.age = 21             //fred.age_=(21) 호출
println(fred.age)

println("-------------")

var fred2 = new Person2()
fred2.age = 30
println(fred2.age)

fred2.age = 20
println(fred2.age) //fred2는 젊어질 수 없다

