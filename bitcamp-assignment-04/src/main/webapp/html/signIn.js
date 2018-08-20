'use strict'

$('#loginBtn').click(() => {
    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail': $('#fSaveEmail').prop('checked')
    }, (result) => {
        if (result.status === 'success') {
            location.href = 'businesscard/index.html'
        } else {
            alert('로그인 실패!')
        }
    }, 'json')
    .fail(() => {
        alert('서버 요청 중 오류 발생!')
    });
});
