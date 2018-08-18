'use strict'

var serverApiAddr = "http://localhost:8080/bitcamp-assignment-04";

$(() => {
    $('.container > header').load(`${serverApiAddr}/html/header.html`)
    $('.container > footer').load(`${serverApiAddr}/html/footer2.html`)
});
