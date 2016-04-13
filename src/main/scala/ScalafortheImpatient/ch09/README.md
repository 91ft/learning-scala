# 정규식이지 말입니다.
![1](http://cfile8.uf.tistory.com/image/24289F4656DBE2BD14935D)

## 오늘은 정규식에 대해서 알아보겠습니다.
스칼라의 정규식 스터디이지만 그냥 정규식이지 말입니다. 속았지 말입니다.

## Start Regualr Expressions!

<br/><br/>
# ^

![2](http://cfile27.uf.tistory.com/image/254D16465699201415E453)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

라인의 시작을 의미합니다.
```ruby
"abc" =~ /^abc/
# 0
"1abc" =~ /^abc/
# nil
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# $

![3](http://mblogthumb3.phinf.naver.net/20160303_10/tnwl2255_1456931857498YPCyC_GIF/%C5%C2%BE%E7%C0%C7_%C8%C4%BF%B9_%BC%DB%C1%DF%B1%E2_01.gif?type=w2)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

라인의 끝을 의미합니다.
```ruby
"abc" =~ /abc$/
# 0
"abcd" =~ /abc$/
# nil
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# .

![4](http://cfile26.uf.tistory.com/image/272ABA4856DE695C0C5776)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

임의의 한문자와 매칭됩니다.
```ruby
"abc" =~ /.../
# 0
"abc" =~ /a.c/
# 0
"abc" =~ /../
# nil
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# [...]

![5](http://cfile30.uf.tistory.com/image/261E9A37567C2D28246A76)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

하나의 문자열이 대괄로안의 문자열들중에 하나와 매칭되는것을 의미 합니다.
```ruby
"abc" =~ /[a][b][c]/
# 0
"abc" =~ /[a-z][b][abc]/
# 0
"abc" =~ /[bcdef][.][c]/
# nil
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# [^...]

![6](http://cfile25.uf.tistory.com/image/2643EF3856F7AF7B21DEF9)
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

하나의 문자열이 대괄로안의 문자열들과는 **매칭이 되지 않아야** 합니다.

```ruby
"abc" =~ /[a][b][^d]/
# 0
"abc" =~ /[a-z][b][^ab]/
# 0
"abc" =~ /[a][^abcdef][c]/
# nil
```

# *

![7](http://uhd.img.topstarnews.net/wys3/file_attach/2016/03/25/1458889633-45-org.gif)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

그전 문자에 대해서 0개상의 매칭이 있다.
```ruby
"abccc" =~ /abc*/
# 0
"abc" =~ /a*b*c*/
# 0
"ab" =~ /abc*$/
# 0
"abcde" =~ /abcd*$/
# nil
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# +

![8](http://file2.instiz.net/data/file2/2016/03/08/9/6/9/969cf1ae7aa3f32a0129eafc69bc0bba.gif)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

그전 문자에 대해서 0개상의 매칭이 있다.
```ruby
"abccc" =~ /abc+/
# ?
"abc" =~ /a+b+c+/
# ?
"abcd" =~ /abc+$/
# ?
"abcd" =~ /abcd+$/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# ?

![9](http://cfile1.uf.tistory.com/image/217CE24956F0C2D01C8544)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
그전 문자에 대해서 0개 혹은 1개의 매칭이 있다.

```ruby
"abc" =~ /a?b?c?/
# ?
"abc" =~ /a?b?c?d?e?f?g?/
# ?
"abcd" =~ /abc?$/
# ?
"abcd" =~ /ab?/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# { n }

![10](http://cfile30.uf.tistory.com/image/2277544D56AECE5D302D82)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

그전 문자에 대해서 **정확하게** n개의 매칭이 있다.
```ruby
"aaa" =~ /a{3}/
# ?
"aaa" =~ /a{2}/
# ?
"aaa" =~ /a{4}/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# { n, }

![11](http://cfile7.uf.tistory.com/image/231CEE4A56DBECF21ACD16)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

그전 문자에 대해서 **n개 이상**의 매칭이 있다.
```ruby
"aaaaab" =~ /a{5,}b/
# ?
"aaa" =~ /a{2,}/
# ?
"aaa" =~ /a{4,}/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# { n,m }

![12](http://cfile4.uf.tistory.com/image/273AFF5056D15AB0250040)
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

그전 문자에 대해서 **n개 이상 m개 이하**의 매칭이 있다.

```ruby
"aaaaab" =~ /a{3,5}b/
# ?
"aaa" =~ /a{2,3}/
# ?
"aaa" =~ /a{1,2}/
# ?
"hahahahahahahohohoho" =~ /(ha){4,8}(ho){3,5}/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# |

![13](http://cfile27.uf.tistory.com/image/242CA44756E92365259B5B)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

`a|b` | 기준으로 앞에 표현`a`이거나 뒤의 표현 `b`이다
```ruby
"abc" =~ /a|1/
# ?
"abc" =~ /abc|def/
# ?
"abc" =~ /abd|abc/
# ?
"abc" =~ /^ab$|1/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# ()

![14](http://cfile222.uf.daum.net/image/242D013B56D3D96B0EBF6E)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

(abc) 괄호 안이 하나의 그룹이 된다. 그리고 기억된다?
```ruby
"abcdef" =~ /(abc)(def)/
# ?
"abcdef" =~ /(abc)/
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# (?: )

![15](https://www.googledrive.com/host/0BxP4aw0HK9-ccmFWbXEtcjAzRFE)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

(?:abc) 괄호 안이 하나의 그룹이 된다. 그리고 기억되지 않는다?

```ruby
"abcdef".match(/(?:abc)(def)/)
# ?
"abcdef".match(/(abc)(def)/)
# ?
"abcdef".match(/(abc)(?:def)/)
# ?
"abcdef".match(/(?:abcd)(def)/)
# ?
```

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
# (?>)

![16](https://3.bp.blogspot.com/-PJx6Qvr-C48/VtfIieUXwLI/AAAAAAAADhA/E_Ga0Jl4zQI/s1600/988356213_9be8b64c.gif)

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

(?>abc) backtracking이 되지 않고 독립된 표현을 매칭이 된다.
> 매칭이 되면 더이상 빼앗기지 않는가?
참조 : http://perl.active-venture.com/pod/perlretut-useindependent.html

```ruby
"ab".match(/a*ab/)
#<MatchData "ab">
"ab".match(/(a*)ab/)
#<MatchData "ab" 1:"">
"ab".match(/(?>a*)ab/)
# nil
"abcdef".match(/(?>abc*)(cdef)/)
# nil
"abcdef".match(/(?:abc*)(cdef)/)
#<MatchData "abcdef" 1:"cdef">
"abcdef".match(/(abc*)(cdef)/)
#<MatchData "abcdef" 1:"ab" 2:"cdef">
```


<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

# 스터디 준비하기 빡세지 말입니다 - 빅보스
![17](http://cfile30.uf.tistory.com/image/2136244C56D9658028E767)
