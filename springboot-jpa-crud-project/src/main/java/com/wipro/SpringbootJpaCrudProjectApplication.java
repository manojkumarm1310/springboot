package com.wipro;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.model.Customer;
import com.wipro.model.OrderDetail;
import com.wipro.model.OrderMaster;

@SpringBootApplication
public class SpringbootJpaCrudProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaCrudProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer1=new Customer("123456789012","abc","chennai","abc@wipro.com",9876543211L);
		
		OrderMaster orderMaster1=new  OrderMaster(10000,"2024-08-01","2024-08-02","Delivery",customer1);
		OrderMaster orderMaster2=new  OrderMaster(10000,"2024-08-11","2024-08-12","Delivery",customer1);
		
		OrderDetail orderDetail1=new OrderDetail("Apple Iphone 14",65500.00,1,65500.00,orderMaster1);
		OrderDetail orderDetail2=new OrderDetail("Vivo V21",25000.00,2,50000.00,orderMaster2);
		List<OrderDetail> list=Arrays.asList(orderDetail1,orderDetail2);
		orderMaster1.setOrderDetail(list);
		customer1.setOrderMaster(Arrays.asList(orderMaster1));
		
		System.out.println(customer1);
	
	}

}
