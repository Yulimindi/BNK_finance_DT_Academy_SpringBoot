const frm = document.querySelector("#frm");
const orderno = document.querySelector("#orderno");
const orderdate = document.querySelector("#orderdate");
const ordercount = document.querySelector("#ordercount");


function order() {
	if(orderno.value == "" || orderdate.value == "" || orderdate.value == "") {
		alert("모든 창을 입력해주세요");
	} else {
		const formData = new FormData(frm);
		const data = Object.fromEntries(formData.entries());
		const json = JSON.stringify(data);
		fetch("insertOrder", {
			method : "post",
			headers: {
			    'Content-Type': 'application/json'
			},
			body : json
		})
		.then(data => data.text())
		.then(data => {
			console.log(data);
			if(data == "yes") {
				alert("주문 등록 완료!");
				frm.reset();
			} else {
				alert("error:주문 등록 실패");
			}
		})
	}
	
}