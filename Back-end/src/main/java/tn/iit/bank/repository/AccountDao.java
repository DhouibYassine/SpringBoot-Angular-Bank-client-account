package tn.iit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.bank.model.Account;

public interface AccountDao extends JpaRepository<Account, Long> {

}
