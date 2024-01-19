package tn.iit.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.bank.model.Account;
import tn.iit.bank.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("")
	public List<Account> getAll() {
		return accountService.findAll();
	}

	@GetMapping("/{id}")
	public Account getById(@PathVariable long id) {
		return accountService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		accountService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Account account) {
		accountService.save(account);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable long id, @RequestBody Account account) {
		accountService.update(account, id);
	}

}
