package br.com.vyne.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.vyne.domain.enums.CurrencyEnum;
import br.com.vyne.domain.enums.TransactionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Domain entity class <code>TransactionDto</code>.
 */
@Data
@AllArgsConstructor
@Builder
public class TransactionDto {

	private Integer id;

	private LocalDate transactionDate;

	private String fullName;

	private TransactionStatusEnum transactionStatus;

	private Integer transactionCode;

	private BigDecimal amount;

	private CurrencyEnum currency;

	public TransactionDto() {

	}

}