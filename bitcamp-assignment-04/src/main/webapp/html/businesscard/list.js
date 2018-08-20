'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

$.getJSON(`${serverApiAddr}/json/businesscard/list`, (result) => {
    var html = template(result);
    $('#name-list').html(html);
})

$('#name-list').on('click', 'li', (e) => {
    var no = $(e.target).attr('data-no');
    $(document.body).trigger('show.detail', [no]);
});