const p = document.querySelector("#p");
const p2 = document.querySelector("#p2");
		
function sendForm() {
	
	if(okay == "yes") {
		const form = document.getElementById("frm");
		const formData = new FormData(form);
		
		fetch("getData", {
			method : "POST", body : formData})
		.then(data => data.json())
		.then(data => {
			p.innerHTML = "";
			for(i = 0; i < data.length; i++) {	
				p.innerHTML += "아이디 : " + data[i].id + "비밀번호 : " + data[i].pw + "<br>";
			}
		});	
	}
}

let okay = "yes";
const id = document.querySelector("#id");

function check() {
	okay = "yes";
	const form = document.getElementById("frm");
	const formData = new FormData(form);
	
	fetch("checkData", 
		{
		method : "POST",
		body : formData
	})
	.then(data => data.json())
	.then(data => {
		for(i = 0; i < data.length; i++) {
			if(data[i].id == id.value) {
				console.log(id.value);
				okay = "no";
			}
		}
		
		if(okay == "no") {
			alert("아이디 중복");
			id.value = "";
		} else {
			alert("아이디 사용 가능");
		}

	});	
}

const id2 = document.querySelector("#id2");
const pw2 = document.querySelector("#pw2");
let correct = "no";

function login() {
	correct = "no";
	const form = document.getElementById("frm2");
			const formData = new FormData(form);
			
			fetch("login", {
				method : "POST", body : formData})
			.then(data => data.json())
			.then(data => {
				
				p2.innerHTML = "";
				for(i = 0; i < data.length; i++) {
					if(data[i].id == id2.value && data[i].pw == pw2.value) {
						correct = "yes";
					}
				}
				
				if(correct == "yes") {
					p2.innerHTML = "로그인 성공";
				} else {
					p2.innerHTML = "로그인 실패";
				}
				
			});	
}
