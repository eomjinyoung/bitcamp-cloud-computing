'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

loadList();

$('#name-list').on('click', 'li', (e) => {
    $('#name-list li.list-group-item-secondary')
        .removeClass('list-group-item-secondary');
    $(e.target).addClass('list-group-item-secondary');
    
    var no = $(e.target).attr('data-no');
    $(document.body).trigger('show.detail', [no]);
});

$(document.body).on('refresh.list', () => loadList());

function loadList() {
    $.getJSON(`${serverApiAddr}/json/businesscard/list`, (result) => {
        var html = template(result);
        $('#name-list').html(html);
        $('#name-list li:first-child').click();
    })
}







