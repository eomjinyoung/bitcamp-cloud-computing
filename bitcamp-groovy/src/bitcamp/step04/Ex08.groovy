// 메서드 - 파라미터로 클로저 넘기기 II
package bitcamp.step04

exec = {m ->
    println m(100, 200)
}

exec({a, b -> a + b})
exec({a, b -> a - b})
exec({a, b -> a * b})
exec({a, b -> a / b})

println "------------------"

exec {a, b -> a + b}
exec {a, b -> a - b}
exec {a, b -> a * b}
exec {a, b -> a / b}






