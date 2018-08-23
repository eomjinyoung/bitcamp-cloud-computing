// 메서드 - 파라미터로 클로저 넘기기
package bitcamp.step04

def each(arr, cb) {
    for (int i = 0; i < arr.size(); i++) {
        cb(i, arr[i])
    }
}

names = ["홍길동", "임꺽정", "유관순"]

each(names, {i, v -> 
    println i + "=" + v
})

