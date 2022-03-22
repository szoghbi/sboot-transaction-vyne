package br.com.vyne.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Domain entity class <code>TransactionResponseDto</code>.
 */
@Data
@AllArgsConstructor
@Builder
public class TransactionResponseDto {

	private Integer id;

	private LocalDate transactionDate;
	
	public String fullName;

	private String transactionStatus;

	private Integer transactionCode;

    private BigDecimal amount;

    private String currency ;

    public TransactionResponseDto() {

    }
}