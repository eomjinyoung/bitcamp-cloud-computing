// 리스트
package bitcamp.step02

list1 = [10, 20, 30]
println list1.size()
println list1.get(1)
println list1[1]
println list1.add(40)
println list1.size()
println list1[3]

println list1[4] // null

println "------------------"

// 배열이 아니기 때문에 목록에 다양한 타입의 값을 지정할 수 있다.
list2 = ["홍길동", 100, 100, 100, "임꺽정", 90, 90, 90]
println list2[0]
println list2[1]
println list2[1] + list2[2] + list2[3]

// 내부적으로 ArrayList 객체가 생성됨
println list2.getClass()

// 빈 리스트 만들기
list3 = []
println list3
