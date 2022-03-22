package br.com.vyne.domain.port;

import java.util.List;

import br.com.vyne.domain.dto.TransactionDto;
import br.com.vyne.domain.dto.TransactionResponseDto;

public interface TransactionRepository {

	List<TransactionResponseDto> listTransactions();
    void removeTransactions(Long id);
    Integer  addTransactions(TransactionDto dsrContatos);
    List<TransactionResponseDto> findByCurrency(String currency);
    

}
