<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Form</h1>
	<hr>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="업로드">
	</form>
	
	<form id="frm">
		<input type="text" name="id" placeholder="id값 입력">
		<button type="button" onclick="getData()">입력</button>
	</form>
	<div id="load"></div>
	
	<script>
		
	const load = document.querySelector("#load");
	const load2 = document.querySelector("#load2");
	const form = document.querySelector("#frm");
	
	function getData() {
		const formData = new FormData(form);
		fetch("/getFile", {
			method : "post",
			body : formData
		})
		.then(data => data.text())
		.then(data => {
			const img = document.createElement("img");
			img.setAttribute("src", data);
			load.appendChild(img);

		})
	}
	
	
	
	
	</script>
</body>
</html>