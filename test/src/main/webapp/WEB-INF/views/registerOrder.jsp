<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문등록</title>
</head>
<link rel="stylesheet" href="/css/style.css">
<script src="/js/register.js" defer></script>
<body>
	<header>
		<h1>할인점 주문 프로그램 ver 1.0</h1>
	</header>
	<nav id="nav">
		<a href="/goRegister">주문등록</a>
		<a href="/goOrderList">주문목록조회</a>
		<a href="/goOrderStatus">점포별주문현황</a>
		<a href="/goCode">제품코드조회</a>
		<a href="/">홈으로</a>
	</nav>
	
	<section>
		<form id="frm">
			<table id="tbl">
				<tr>
					<td>주문번호</td>
					<td><input type="text" name="ORDERNO" id="orderno"></td>
				</tr>
				
				<tr>
					<td>주문점포</td>
					<td>
					<select name="SHOPNO">
						<option value="S001">AA 할인점</option>
						<option value="S002">BB 할인점</option>
						<option value="S003">CC 할인점</option>
						<option value="S004">DD 할인점</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<td>주문일자</td>
					<td><input type="text" name="ORDERDATE" id="orderdate"></td>
				</tr>
				
				<tr>
					<td>제품코드</td>
					<td>
					<select name="PCODE">
						<option value="AA01">삼각김밥</option>
						<option value="AA02">도시락</option>
						<option value="AA03">봉지만두</option>
						<option value="AA04">컵라면</option>
						<option value="AA05">아메리카노</option>
						<option value="AA06">콜라</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<td>주문수량</td>
					<td><input type="text" name="AMOUNT" id="ordercount"></td>
				</tr>
			</table>
			<button type="button" onclick="order()">주문등록</button>
			<input type="reset" value="다시쓰기">
		</form>
	</section>
	<footer>
		푸터입니댕
	</footer>
	
</body>
</html>