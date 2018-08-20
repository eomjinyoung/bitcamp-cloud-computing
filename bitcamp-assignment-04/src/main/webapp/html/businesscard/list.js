'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

$.getJSON(`${serverApiAddr}/json/businesscard/list`, (result) => {
    var html = template(result);
    $('#name-list').html(html);
})