# Chapter 7. 패키지와 임포트

## 9줄 요약
> * 패키지는 내부 클래스와 마찬가지로 중첩된다.
> * 패키지 패스는 절대가 아니다.
> * 패키지 구문에서 x.y.z 체인은 중간 패키지인 x와 x.y를 감춘다.
> * 파일 시작에 나오는 중괄호 없는 패키지문은 전체 파일로 확장된다.
> * 패키지 오브젝트는 함수와 변수를 가질 수 있다.
> * 임포트문은 패키지, 클래스와 오브젝트를 임포트할 수 있다.
> * 임포트문은 아무 데나 올 수 있다.
> * 임포트문은 멤버 이름을 바꾸거나 숨길 수 있다.
> * java.lang, scala, Predef는 항상 임포트 된다.

## 패키지
```
package com {
  package horstmann {
    package impatient {
      class Employee
      ...
    }
  }
}
```
Employee는 com.horstmann.impatient.Employee로 접근할 수 있다.


```
package com {
  package horstmann {
    package impatient {
      class Employee
      ...
    }
  }
}

package org {
  package bigjava {
    class Counter
    ...
  }
}
```
위와 같이 한 파일에 한 개 이상의 패키지를 넣을 수도 있다.

소스 파일 디렉토리와 패키지 사이에 강요된 관계는 없다!

## 스코프 규칙
다른 모든 스코프와 마찬가지로 중첩된다. 바깥 스코프에 있는 이름에 접근할 수 있다.
```
package com {
  package horstmann {
    object Utils {
      def percentOf(value: Double, rate : Double) = value * rate / 100
      ...
    }

    package impatient {
      class Employee {
        ...
        def giveRaise(rate: scala.Double) {
          salary += Utils.percentOf(salary, rate)  // 부모패키지에 정의되어 있는 것은 스코프안에 들어옴.
        }
      }
    }
  }
}
```

```
package com {
  package horstmann {
    package impatient {
      class Manager {
        val subordinates = new collection.mutable.ArrayBuffer[Employee] // scala.collection
        ...
      }
    }
  }
}
```
위의 colleciton은 스칼라패키지가 기본으로 임포트 되기 때문에 사용 가능

```
package com {
  package horstmann {
    package collection {
      ...
    }
  }
}
```
이렇게 되면 horstmann이 부모인 클래스들은 이 collection에 접근하게 되므로, 컴파일 에러!!
_root_로 시작하는 절대 패키지를 사용하거나, 체인 패키지를 쓰면 된다.

## 체인 패키지 구문
```
package com.horstmann.impatient {
  // com과 com.horstmann의 멤버는 여기서 보이지 않는다.
  package people {
    class Person
    ...
  }
}
```
여기서는 com.horstmann.collection을 collection으로 접근할 수 없다.

## 파일 시작 표기법

```
package com.horstmann.impatient {
  package people {
      class Person
      ...
    }
  }
}
```
중괄호 없이 사용할 수 있다.

```
package com.horstmann.impatient
package people

class Person
...
```
com.horstmann.impatient 패키지의 내용을 참조할 수 있다.

## 패키지 오브젝트
패키지는 함수나 변수정의는 포함할 수 없다. (클래스, 오브젝트, 트레이트 등은 가능)
모든 패키지는 하나의 패키지 오브젝트를 가질 수 있다.

```
package com.horstmann.impatient

package object people {
  val defaultName = "John Q. Public"
}

package people {
  class Person {
    var name = defaultName // 패키지에서 온 상수
  }
  ...
}
```
패키지 오브젝트는 내부적으로 정적 메소드와 필드를 가진 jvm 클래스로 컴파일 된다. (package.class라는 이름)
위의 예는 com.horstmann.impatient.people.package 클래스가 된다.
소스 파일에 같은 이름 명명법을 사용하면 좋다.
com/horstmann/impatient/people/package.scala

## 패키지 가시성
스칼라에서는 한정자로 가시성을 가지게 할 수 있다.

```
package com.horstmann.impatient.people

class Person {
  private[people] def description = "A person with name " + name
  ...
}
```
자신의 패키지 내에서만 가능

```
package com.horstmann.impatient.people

class Person {
  private[impatient] def description = "A person with name " + name
  ...
}
```
바깥 패키지로 확장

## 임포트
임포트의 유일한 목적은 "짧게" 쓰기 위함이다.

```
import java.awt._ // 와일드카드와 동일, 모든 멤버 임포트

import java.awt.Color._ // 자바의 import static과 비슷
```

## 스코프는 어디든 올 수 있다.
```
class Manager {
  import scala.collection.mutable._
  val subordinates = new ArrayBuffer[Employee]
  ...
}

임포트문의 스코프는 바깔 블록 끝까지 확장된다.
```

## 멤버 이름 변경 및 숨기기
```
import java.awt.{Color, Font}

// JavaHashMap은 java.util.HashMap, HashMap은 scala.collection.mutable.HashMap으로 접근할 수 있다.
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable._

// HashMap => _ 선택자는 이름을 숨긴다. 이제 모호성 없이 HashMap은 java.util.HashMap을 가리킨다.(응?)
import java.util.{HashMap => _, _}
import scala.collection.mutable._
```

## 암묵적 임포트
```
import java.lang._
import scala._
import Predef._
```

앞선 임포트를 덮어쓴다.
scala.StringBuilder는 java.lang.StringBuilder을 덮어쓴다.

