package tn.iit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.bank.model.Client;

public interface ClientDao extends JpaRepository<Client, String> {

}
