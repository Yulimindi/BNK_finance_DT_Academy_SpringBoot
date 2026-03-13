package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	String ORDERNO;
	String SHOPNO;
	String ORDERDATE;
	String PCODE;
	int AMOUNT;
}
