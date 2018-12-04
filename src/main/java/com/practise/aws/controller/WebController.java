package com.practise.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.aws.model.UserDetails;
import com.practise.aws.repo.UserCrudRepository;

@RestController
public class WebController {
	


		@Autowired
		public UserCrudRepository repository;

		@RequestMapping("/delete")
		public String delete() {
			repository.deleteAll();
			return "Done";
		}

		@RequestMapping("/save")
		public String save() {
			// save a single User
			repository.save(new UserDetails("JSA-1", "Jack", "Smith","admin"));

			// save a list of Users
			/*repository.save(Arrays.asList(new UserDetails("JSA-2", "Adam", "Johnson","admin"), new UserDetails("JSA-3", "Kim", "Smith","admin"),
					new UserDetails("JSA-4", "David", "Williams","admin"), new UserDetails("JSA-5", "Peter", "Davis","admin")));*/

			return "Done";
		}

		@RequestMapping("/findall")
		public String findAll() {
			String result = "";
			Iterable<UserDetails> users = repository.findAll();

			for (UserDetails cust : users) {
				result += cust.toString() + "<br>";
			}

			return result;
		}

		/*@RequestMapping("/findbyid")
		public String findById(@RequestParam("id") String id) {
			String result = "";
			result = repository.findById(id).toString();
			return result;
		}*/

		@RequestMapping("/findbylastname")
		public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
			String result = "";

			for (UserDetails cust : repository.findByLastName(lastName)) {
				result += cust.toString() + "<br>";
			}

			return result;
		}
	}

