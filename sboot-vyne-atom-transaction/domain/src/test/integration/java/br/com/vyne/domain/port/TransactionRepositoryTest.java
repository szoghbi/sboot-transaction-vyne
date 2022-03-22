package br.com.vyne.domain.port;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.vyne.domain.dto.TransactionDto;
import br.com.vyne.domain.dto.TransactionResponseDto;
import br.com.vyne.domain.enums.CurrencyEnum;
import br.com.vyne.domain.enums.TransactionStatusEnum;
import br.com.vyne.domain.service.TransactionService;


public class TransactionRepositoryTest {
	
	@Autowired
    private TransactionService service;

	@Autowired
	private TransactionRepository repository;
	
	@Test
    public void findByIdTest() {
		TransactionDto user = new TransactionDto();

		TransactionDto.builder()
		.transactionDate(LocalDate.now())
		.fullName("Samir Abdul Zoghbi")
		.amount(new BigDecimal(12.00))
		.currency(CurrencyEnum.fromValue(0))
		.transactionCode(TransactionStatusEnum.CHECKING.getValue())
		.transactionStatus(TransactionStatusEnum.CHECKING)
		.build();

		repository.addTransactions(user);
        assertNotNull(user.getId());
        List<TransactionResponseDto> userDTO = service.findByCurrency("USD");

        assertEquals(user.getCurrency(), userDTO.get(0).getCurrency());
    }

}