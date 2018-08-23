// Groovy - 컴파일과 실행
package bitcamp.step01

// 컴파일 : 그루비 소스 파일을 컴파일하여 바이트코드를 생성한다.
// => .groovy --> .class
// 
// 그루비 컴파일러가 자동으로 생성하는 클래스 
// => groovy.lang.Script를 상속 받는다.
// => 생성자 메서드와 main() 메서드를 자동 생성한다.
// => main()는 groovy 컴파일러가 자동생성한 run() 메서드를 호출한다. 
// => run() 메서드에는 클래스나 메서드 안에 작성하지 않고
//    다음과 같이 바깥에 작성한 코드가 들어간다.
// 
println "Hello!"
