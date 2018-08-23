// 조건문
package bitcamp.step03

a = 20

if (a < 19)
    println "미성년"
else if (a >= 19 && a < 65)
    println "성년"
else 
    println "노인"
    
// 조건 연산자(3항 연산자)
println a < 19 ? "미성년" : "성년"