<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
이름: ${name}<br>
나이: ${age}<br>
사진: ${newfilename}<br>
<img src='../files/${newfilename}'><br>
<img id='img1'><br>
<script>
setTimeout(() => {
    document.getElementById('img1').src = 
        '../files/${newfilename}';
}, 5000);

</script>
</html>