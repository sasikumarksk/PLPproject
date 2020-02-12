package com.capgemini.storesmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.service.ManufacturerService;
import com.capgemini.storesmanagementsystem.service.ManufacturerServiceImpl;

public class ManufacturerController {
	ManufacturerService manService = new ManufacturerServiceImpl();
	Logger log = Logger.getLogger("store");
	Scanner scan = new Scanner(System.in);
	ManufacturerServiceImpl dao = new ManufacturerServiceImpl();

	void manufactureTask() {

		int choice = 0;
		log.info("Welcome to Manufactures Page");
		log.info("1.Add Dealer");
		log.info("2.Modify Dealer");
		log.info("3.Remove Dealers");
		log.info("4.View Dealers");
		log.info("5.Add Products");
		log.info("6.Modify Products");
		log.info("7.Remove Products");
		log.info("8.View Products");
		log.info("9.View Store");
		log.info("10.Exit");

		do {
			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				UserDetailsInfo user = new UserDetailsInfo();
				log.info("Enter the UserId");
				String userId = scan.next();
				user.setUserId(userId);

				log.info("Enter the Email");
				String Email = scan.next();
				user.setEmail(Email);

				log.info("Enter the Location");
				String Location = scan.next();
				user.setAddress(Location);

				log.info("Enter the Password");
				String password = scan.next();
				user.setPassword(password);

				log.info("Enter the Role");
				String role = scan.next();
				user.setUserRole(role);

				log.info("Enter the UserName");
				String uname = scan.next();
				user.setUserName(uname);

				boolean result = manService.addDealer(user);
				if (result)
					log.info("Insert Succesfully");
				else
					log.info("Insertion Failed");
				break;
			case 2:
				UserDetailsInfo user1 = new UserDetailsInfo();
				log.info("Enter the User_ID You want to Update");
				String id = scan.next();

				log.info("Enter the Username");
				String name = scan.next();
				user1.setUserName(name);

				log.info("Enter the Password");
				String pass = scan.next();
				user1.setPassword(pass);

				log.info("Enter the email");
				String emailid = scan.next();
				user1.setEmail(emailid);

				// dao.updateManufactur(id,user1);
				boolean result1 = manService.modifyDealer(id, user1);
				if (result1)

					log.info("Record has been updated Successfully!!!");
				else
					log.info("Updation Failed");
				break;

			case 3:

				log.info("Enter the UserId(String) You want to Delete");
				String userid = scan.next();
				boolean res=manService.removeDealer(userid);
				if(res)
				log.info("UserId is deleted Succesfully");
				else
					log.info("UserId  Not Found");
				break;

			case 4:
				log.info("Enter which role(Users) you want to see");
				String rol = scan.next();
				List<String> li = dao.viewAllDealers(rol);

				log.info(li);
				break;
			case 5:
				ProductDetailsInfo product = new ProductDetailsInfo();
				log.info("Enter the ProductId");
				int pId = scan.nextInt();
				product.setProduct(pId);
				log.info("Enter the Brand");
				String brand = scan.next();
				product.setProductName(brand);

				log.info("Enter the Price");
				double d = scan.nextDouble();
				product.setPrice(d);

				log.info("Enter the Stocks");
				int s = scan.nextInt();
				product.setStocks(s);

				log.info("Enter the Warranty");
				String str = scan.next();
				product.setWarranty(str);

				boolean result2 = manService.addProduct(product);
				if (result2)
					log.info("Insert Succesfully");
				else
					log.info("Insertion Failed");
				break;

			case 6:

				ProductDetailsInfo prod = new ProductDetailsInfo();
				log.info("Enter the ProductID You want to Update");
				int pid = scan.nextInt();

				log.info("Enter the price");
				double price = scan.nextDouble();
				prod.setPrice(price);

				log.info("Enter the Warranty");
				String warranty = scan.next();
				prod.setWarranty(warranty);
				boolean result3 = manService.modifyProduct(pid, prod);
				if (result3)
					log.info("Record has been updated Successfully!!!");
				else
					log.info("Updation Failed");

				break;

			case 7:
				log.info("Enter the ProductId You want to Delete");
				int pid1 = scan.nextInt();
				boolean result4 = manService.removeProduct(pid1);
				if (result4)
					log.info("UserId is deleted Succesfully");
				else
					log.info("UserID Not Found");
				break;

			case 8:
				List<String> n = manService.viewAllProducts();

				log.info(n);

				break;
			case 9:
				List<String> ki = manService.viewStore();

				log.info(ki);

				break;
			default:
				System.out.println("Invalid Choice...");
				break;

			}
		} while (choice != 10);

	}}
