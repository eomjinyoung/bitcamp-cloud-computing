// 메서드 - 파라미터로 클로저 넘기기 IV
package bitcamp.step04

def name = "익명";

printHello = {env ->
    if (env != null) {
        env()
    }
    println name + "님 반갑습니다."
}

printHello()

printHello {
    name = "홍길동"
}





