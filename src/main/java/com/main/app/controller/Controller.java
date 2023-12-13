package com.main.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.model.Customer;
import com.main.app.services.CustomerService;
/*Controller class handles all the HTTP requests */
@RestController
/*This above annotation is a combination of @Controller and @Responcebody
 * @RestController indicates that the class is a controller where the methods return data directly instead of relying
 *  on a view resolver to render the data*/
public class Controller {
	
	@Autowired
	private CustomerService cusser;
/*To automatically inject dependencies into above field from service bean to archive loose coupling (flexibility in unit testing)
 * here @Autowired annotation helps to inject dependencies from spring beans @Servivice */
	@GetMapping("/customer")
//	@GetMapping Annotation is used to map HTTP GET requests to handle by below method at end point /customer
	public List<Map<String, Object>> getAll(){
		List<Map<String, Object>> res = this.cusser.getAllCus();
		return res;
	}
//	the above method is used to fetch all customers from database and spring will automatically convert the return type to JSON and sends is as response

	@GetMapping("/customer/id/{id}")
//	this getById method will return customer with selected id number 
	public  List<Map<String, Object>> getbyId(@PathVariable("id")int id){
//		 in above method @PathVariable will extract the id value from URL and passes as argument
		 List<Map<String, Object>> res = this.cusser.getById(id);
//		 the method in cusser(CustomerServices) will return List<Map<String, Object> Customer
		 return res;
	}



	@PostMapping("/customer/insert")
//	@PostMapping will used to map HTTP POST request to above method to handle at end point /customer/insert
//	this method will add customer return type is String
	public String addcus(@RequestBody Customer cus) {
//		@RequestBody handles incoming body and bind to this method and spring will automatically converts the JSON to Customer object
		int res = this.cusser.insertCus(cus);
//		calling insertcus method in CustomerServices class it returns integer
		if(res==1) {
//			if customer added the insertcus will return 1 hence this condition will be true it will return below message
			return "Customer Added";
			
		}
		else {
//			if failed to add customer it will return 0 so the below message will be send as response
			return " Failed to add Customer";
			
		}
		
	}

//	@PutMapping is used for updating existing resource 
	@PutMapping("/customer/update")
//	used to update resource in database it will return a message in String
	public String updateCusDeatils(@RequestBody Customer cus) {
		int res = this.cusser.updateCus(cus);
		if(res==1) {
			return "Customer Detailed updated";
		}
		
		else {
			return "Failed to update";
		}
	}
//	this below annotation is specifically used to handle delete request from HTTP DELETE
//	used to delete existing data in database it will return message in String
	@DeleteMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable("id")int id) {
		int res = this.cusser.delById(id);
		if(res==1) {
			return "Customer removed";
		}
		else {
			return "Failed to Remove Customer";
		}
	}

}
