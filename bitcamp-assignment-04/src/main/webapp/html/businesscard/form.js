'use strict'

$(document.body).on('show.detail', (e, no) => {
    $.getJSON(`${serverApiAddr}/json/businesscard/${no}`, (result) => {
        if (result.status !== 'success') return;
        
        $('#f-name').val(result.data.name);
        $('#f-mobile-tel').val(result.data.mobileTel);
        $('#f-tel').val(result.data.tel);
        $('#f-fax').val(result.data.fax);
        $('#f-email').val(result.data.email);
        $('#f-memo').val(result.data.memo);
    })
})

$('#add-btn').click(() => {
    $('#reset-btn').click();
    
    $('.form-control-plaintext').addClass('form-control')
         .removeClass('form-control-plaintext');
});










