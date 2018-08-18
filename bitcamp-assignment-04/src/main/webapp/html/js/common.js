'use strict'

var serverApiAddr = "http://localhost:8080/bitcamp-assignment-04";

$(() => {
    $('footer').load(`${serverApiAddr}/html/footer.html`)
});
