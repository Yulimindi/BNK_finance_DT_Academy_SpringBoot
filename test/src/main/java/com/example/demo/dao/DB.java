package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Code;
import com.example.demo.dto.Order;
import com.example.demo.dto.OrderList;
import com.example.demo.dto.Store;

@Repository
public class DB {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(Order o) {
		String query = "insert into TBL_0RDER_202101 values(?, ?, ?, ?, ?)";
		int result = jdbc.update(query, o.getORDERNO(), o.getSHOPNO(), o.getORDERDATE(), o.getPCODE(), o.getAMOUNT());
		return result; 
	}
	
	public List<OrderList> getOrder() {
		String query = "select s.shopno, s.shopname, substr(o.orderno, 1, 4) || '-' || substr(o.orderno, 5, 4) as orderno, substr(o.orderdate, 1, 4) || '-' || substr(o.orderdate, 5, 2) || '-' || substr(o.orderdate, 7, 2) as orderdate, o.pcode, p.pname, o.amount, to_char(p.cost, '9,999') as cost, to_char(p.cost*o.amount, '999,999') as price, to_char((p.cost*o.amount)-((p.cost*o.amount)*(s.discount/100)), '999,999') as saleprice from TBL_SHOP_202101 s join TBL_0RDER_202101 o on s.shopno = o.shopno join TBL_PRODUCT_202101 p on p.pcode = o.pcode order by o.orderno";
		List<OrderList> list = jdbc.query(query, new BeanPropertyRowMapper<OrderList>(OrderList.class));
		return list;
	}
	
	public List<Store> getStore() {
		String query = "select o.shopno, o.pcode, p.pname, sum(o.amount) as quantity  from TBL_0RDER_202101 o join TBL_PRODUCT_202101 p on o.pcode = p.pcode group by o.shopno, o.pcode, p.pname order by o.pcode";
		List<Store> list = jdbc.query(query, new BeanPropertyRowMapper<Store>(Store.class));
		return list;
	}
	
	public List<Code> getCode() {
		String query = "select pcode, pname, to_char(cost, '9,999') as cost, to_char(cost*0.9, '9,999') as ten, to_char(cost*0.85, '9,999') as fif from TBL_PRODUCT_202101";
		List<Code> list = jdbc.query(query, new BeanPropertyRowMapper<Code>(Code.class));
		return list;
	}
}
