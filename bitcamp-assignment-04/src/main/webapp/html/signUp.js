$('#addBtn').click(() => {
    $.post(`${serverApiAddr}/json/member/signUp`, {
        'email': $('#fEmail').val(),
        'name': $('#fName').val(),
        'password': $('#fPassword').val()
    }, (result) => {
        console.log(result);
    }, 'json')
    .fail(() => {
        alert('회원 가입 중에 오류 발생!')
    });
});

console.log('========>')