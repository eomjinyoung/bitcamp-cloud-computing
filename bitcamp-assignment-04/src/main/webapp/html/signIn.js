'use strict'

$('#loginBtn').click(() => {
    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail': $('#fSaveEmail').prop('checked')
    }, (result) => {
        console.log(result);
    }, 'json')
    .fail(() => {
        alert('회원 가입 중에 오류 발생!')
    });
});
