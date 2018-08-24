// 문자열 다루기 - GString 
package bitcamp.step06

name = "홍길동" // String
str1 = "이름은 $name 입니다."  // GString
str2 = "이름은 " + name + " 입니다." // String

println str1 instanceof String
println str1 instanceof GString

println str2 instanceof String
println str2 instanceof GString