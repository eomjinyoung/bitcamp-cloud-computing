// 맵 
package bitcamp.step02

// 맵 생성하기
map1 = ["name": "홍길동", "age": 20, "email": "hong@test.com"]
println map1["name"]
println map1.name
println map1.get("name")

// 내부적으로 java.util.LinkedHashMap 객체를 생성한다.
println map1.getClass()

// 맵에 값 추가하기
map1["tel"] = "1111-1111"
map1.fax = "1111-2222"
map1.put("password", "1111")

println map1

// 빈 맵 만들기
map2 = [:]
println map2










