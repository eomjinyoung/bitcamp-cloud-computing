// 반복문
package bitcamp.step03

def a = 10;
while (a > 0) {
    print a + ",";
    a--
}
println "\n---------------"

for (int i = 0; i < 10; i++) 
    print i + ","
println "\n---------------"

for (i in 1..10) 
    print i + ","
println "\n---------------"

for (name in ["홍길동", "임꺽정", "유관순"])
    print name + ","
println "\n---------------"

for (entry in ["홍길동":20, "임꺽정":30, "유관순":17])
    println entry.key + "=" + entry.value
println "---------------"

for (c in "ABC가각간123")
    print c + ","
println "\n-------------"







