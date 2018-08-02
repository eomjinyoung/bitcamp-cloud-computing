var gamer = 'X';
var computer = 'O';

$('.cell').click((e) => {
    console.log($(e.target).attr('data-pos'));
    $(e.target).text(gamer);
});

$('#new-game').click((e) => {
    console.log('new game!');
});

