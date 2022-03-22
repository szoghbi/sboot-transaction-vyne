package br.com.vyne.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vyne.domain.dto.TransactionDto;
import br.com.vyne.domain.dto.TransactionResponseDto;
import br.com.vyne.domain.port.TransactionRepository;

@Service
public class TransactionService {

	private TransactionRepository repository;
	
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public TransactionDto addTransactions(TransactionDto transaction) {
    	transaction.setId(repository.addTransactions(transaction));
        return transaction;
    }

    public List<TransactionResponseDto> listTransactions(){
        return repository.listTransactions();
    }
    
    public List<TransactionResponseDto> findByCurrency(String currency) {
    	return repository.findByCurrency(currency);
    }

    public void removeTransactions(Long id){
        repository.removeTransactions(id);
    }

}