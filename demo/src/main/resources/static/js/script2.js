const form = document.querySelector("#frm");
const p = document.querySelector("#p");

function sendForm() {
	const formData = new FormData(form);
	
	fetch("amember", {
		method : "POST", body : formData})
	.then(data => data.json())
	.then(data => {
		console.log(data);
		console.log(data.no);
		p.innerHTML = data.no;
	})

}