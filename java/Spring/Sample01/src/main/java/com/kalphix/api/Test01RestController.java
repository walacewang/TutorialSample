package com.kalphix.api;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalphix.dao.CustomerDAO;
import com.kalphix.exception.BizException;
import com.kalphix.model.Customer;

/**
 * 
 * @author kalphix
 *
 */
@RestController
public class Test01RestController {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/customs")
	public List<Customer> getCustomers() {
		return customerDAO.list();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/customs/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			throw new BizException("wea.err.msg01",
					messageSource.getMessage("wea.err.msg01", null, Locale.getDefault()));
		}

		MultiValueMap<String, String> headerParams = new LinkedMultiValueMap<String, String>();
		headerParams.add("X-Forwarded-Host", "bigip.kalphix.com");
		headerParams.add("X-Girl", "tell me your name.");

		return new ResponseEntity<Customer>(customer, headerParams, HttpStatus.OK);
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/customs")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		customerDAO.create(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/customs/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			throw new BizException("wea.err.msg01",
					messageSource.getMessage("wea.err.msg01", null, Locale.getDefault()));
		}

		return new ResponseEntity<Long>(id, HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @param customer
	 * @return
	 */
	@PutMapping("/customs/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (customer == null) {
			throw new BizException("wea.err.msg01",
					messageSource.getMessage("wea.err.msg01", null, Locale.getDefault()));
		}

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
