package com.wipro;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import com.wipro.entity.Address;
import com.wipro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringBootJpaAppApplication implements CommandLineRunner {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAppApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//insert
//		try {
//			User user=new User("user1","user1@123",LocalDate.of(2001, 10,10),"chennai","user1@gmail.com",982123456L);
//			entityManager.getTransaction().begin();
//			entityManager.persist(user);
//			
//			EntityTransaction transaction =entityManager.getTransaction();
//			transaction.begin();
//			entityManager.getTransaction().begin();
//			entityManager.persist(user);
//			entityManager.flush();//optional
//			entityManager.getTransaction().commit();
			
//			entityManager.persist(user);
//			entityManager.flush();//optional
//			System.out.println("1 row added to the database");
//		}catch(DataAccessException e) {
//			e.printStackTrace();
//		}
//		
		//Update
//		try {
//			int n=1;
//			User user1=entityManager.find(User.class, n);
//			System.out.println("Before Update:");
//			System.out.println(user1);
//			user1.setAddress("Chennai");
//			entityManager.merge(user1);
//			System.out.println("After update: ");
//			System.out.println(user1);
//			
//			
//		}catch(DataAccessException e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			//JPQL - everything is a form of class and object;
//			String query="select u from User u";
//			TypedQuery<User> tq=entityManager.createQuery(query,User.class);
//			List<User> userList=tq.getResultList();
//			
//			System.out.println(userList);
//		}catch(DataAccessException e) {
//			e.printStackTrace();
//		}
		
		
		//Delete
//		try {
//			System.out.println("Before delete");
//			String query ="Select u from User u";
//			TypedQuery<User> tq=entityManager.createQuery(query,User.class);
//			System.out.println(tq.getResultList());
//			int id=52;
//			User user=entityManager.find(User.class, id);
//			if(user==null) {
//				throw new SQLException();
//			}
//			entityManager.remove(user);
//			System.out.println("After Delete");
//			System.out.println(tq.getResultList());
//			List<User> userList=tq.getResultList();
//			userList.forEach(System.out::println);
//		}catch(DataAccessException e) {
//			e.printStackTrace();
//		}
		
		try {
//			Address address = new Address("1-2-345","Hyderabad");
//			Student student = new Student("Smith",LocalDate.of(1999, 10, 10),address);
//			
//			entityManager.persist(student);
//			entityManager.flush();
//			
//			System.out.println("Both Student and Address objects are persisted into database");
			
			Student student = entityManager.find(Student.class, 1);
			System.out.println(student);
//			
			Address address = student.getAddress();
			System.out.println(address);
			
			student = address.getStudent();
			System.out.println(student);
//			
			
			
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
	}

}
