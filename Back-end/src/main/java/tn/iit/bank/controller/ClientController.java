package tn.iit.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.bank.model.Client;
import tn.iit.bank.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public List<Client> getAll() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public Client getById(@PathVariable String id) {
		return clientService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		clientService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Client client) {
		clientService.save(client);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody Client client) {
		clientService.update(client, id);
	}

}
