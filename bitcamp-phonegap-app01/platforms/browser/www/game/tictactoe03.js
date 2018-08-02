$('.cell').click((e) => {
    console.log($(e.target).attr('data-pos'));
});

$('#new-game').click((e) => {
    console.log('new game!');
});

