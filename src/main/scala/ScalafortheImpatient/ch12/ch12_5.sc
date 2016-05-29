
(1 to 9).map(0.1*_)

(1 to 9).map("*" * _).foreach( println _)

(1 to 9).foreach(_ + 3)

(1 to 9).filter(_ % 2 == 0)


(1 to 9).reduceLeft(_ * _ )

"my little tel".split(" ").sortWith(_.length > _.length)


val pairs = (1 to 10) zip( 11 to 20)

