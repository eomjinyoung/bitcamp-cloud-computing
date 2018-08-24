// 문자열 다루기 - GString 
package bitcamp.step06

str1 = new String("홍길동")
str2 = new String("홍길동")

println str1 == str2
println str1.equals(str2)

name = "홍길동"
str1 = "$name 입니다."
str2 = "$name 입니다."

println str1 == str2
println str1.equals(str2)