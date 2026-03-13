package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
	String SHOPNO;
	String SHOPNAME;
	String ORDERNO;
	String ORDERDATE;
	String PCODE;
	String PNAME;
	int AMOUNT;
	String COST;
	String PRICE;
	String SALEPRICE;
}
