package tn.iit.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.iit.bank.exception.AccountNotFoundException;
import tn.iit.bank.model.Account;
import tn.iit.bank.repository.AccountDao;

@Service
public class AccountService {
	private AccountDao accountDao;

	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public List<Account> findAll() {
		return accountDao.findAll();
	}

	public Account findById(Long id) {
		return accountDao.findById(id).orElseThrow(() -> new AccountNotFoundException(id));

	}

	public void save(Account accountToSave) {
		accountDao.save(accountToSave);
	}

	public void delete(Long id) {
		accountDao.deleteById(id);
	}

	public void update(Account newAccount, Long id) {
		Account account = findById(id);
		account.setBalance(newAccount.getBalance());
		accountDao.save(account);
	}
}
