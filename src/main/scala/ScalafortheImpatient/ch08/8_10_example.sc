import ScalafortheImpatient.ch08.{Bug, Ant}

val ant = new Ant()
ant.range
ant.env
ant.env.length //이거슨 문제!



/**
  * 1. Ant생성자는 슈퍼클래스인 Creature 생성자를 호출
  * 2. Creature생성자는 range 필드의 값을 10으로 설정
  * 3. Creature생성자는 env배열 초기화를 위해 range() 게터 호출
  * 4. 이 메소드는 override되어 있는데 불행히도 아직 초기화 되지 못한 상태!!!
  * 5. range=0 리턴
  * 6. env는 길이 0의 배열로 설정된다
  * 7. Ant생성자는 계속 실행하여 range=2로 설정
  */


val bug = new Bug()
bug.range
bug.env
bug.env.length