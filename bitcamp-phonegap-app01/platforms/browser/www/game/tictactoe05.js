var gamer = 'X',
    computer = 'O',
    cells = $('.cell'),
    count = 0;

$('.cell').click((e) => {
    console.log($(e.target).attr('data-pos'));
    $(e.target).text(gamer);
    
    // 마지막 표시를 했으면 더이상 컴퓨터가 작업하지 않는다.
    if (++count == 5) return;
    
    // 타이머를 가동하여 1초 후에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        while (true) {
            var no = Math.floor(Math.random() * 9);
            if (!isCellChecked(no)) {
                checkCell(no);
                return;
            }
        }
    }, 1000);
});

$('#new-game').click((e) => {
    console.log('new game!');
});

function isCellChecked(no) {
    return cells[no].innerHTML != "" ? true : false;
}

function checkCell(no) {
    return cells[no].innerHTML = computer;
}










