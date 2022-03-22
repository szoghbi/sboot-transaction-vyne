package br.com.vyne.application.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vyne.application.mapper.TransactionMapper;
import br.com.vyne.domain.service.TransactionService;
import br.com.vyne.transaction.provider.api.TransactionsApi;
import br.com.vyne.transaction.provider.presentation.representation.TransactionsRequestRepresentation;
import br.com.vyne.transaction.provider.presentation.representation.TransactionsResponseRepresentation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
public class TransactionController implements TransactionsApi {

    @Autowired
    private TransactionService transactionService;

    @Override
    public ResponseEntity<TransactionsRequestRepresentation> addTransactions(TransactionsRequestRepresentation body) {

    	try {
    		transactionService.addTransactions(TransactionMapper.toDomain(body));
    		return ResponseEntity.ok().build();	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @Override
    public ResponseEntity<Void> removeTransactions(Long id) {
    	try {
    		transactionService.removeTransactions(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @Override
    public ResponseEntity<List<TransactionsResponseRepresentation>> listTransactions() {
        return ResponseEntity.ok(TransactionMapper.toListRepresentation(transactionService.listTransactions()));
    }

    @Override
    public ResponseEntity<List<TransactionsResponseRepresentation>> findByCurrency(String currency) {
    	return ResponseEntity.ok(TransactionMapper.toListRepresentation(transactionService.findByCurrency(currency)));
    }
}