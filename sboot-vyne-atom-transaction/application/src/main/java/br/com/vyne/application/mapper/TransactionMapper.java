package br.com.vyne.application.mapper;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vyne.domain.dto.TransactionDto;
import br.com.vyne.domain.dto.TransactionResponseDto;
import br.com.vyne.domain.enums.CurrencyEnum;
import br.com.vyne.domain.enums.TransactionStatusEnum;
import br.com.vyne.transaction.provider.presentation.representation.TransactionsRequestRepresentation;
import br.com.vyne.transaction.provider.presentation.representation.TransactionsResponseRepresentation;

public class TransactionMapper {

	public static TransactionsResponseRepresentation toRepresentation(TransactionResponseDto transaction){
		TransactionsResponseRepresentation representation = new TransactionsResponseRepresentation();
		representation.setId(transaction.getId().longValue());
		representation.setTransactionDate(transaction.getTransactionDate());
		representation.setFullName(transaction.getFullName());
		representation.setAmount(transaction.getAmount());
		representation.setCurrency(transaction.getCurrency());
		representation.setTransactionCode(transaction.getTransactionCode());
		representation.setTransactionStatus(transaction.getTransactionStatus());

		return representation;
    }

    public static List<TransactionsResponseRepresentation> toListRepresentation(List<TransactionResponseDto> listTransaction){
    	return listTransaction.stream().map(TransactionMapper::toRepresentation).collect(Collectors.toList());
    }

    public static TransactionDto toDomain(TransactionsRequestRepresentation representation){
    	
    	return TransactionDto.builder()
    			.transactionDate(LocalDate.now())
    			.fullName(representation.getFullName())
    			.amount(representation.getAmount())
    			.currency(CurrencyEnum.fromValue(representation.getCurrency()))
    			.transactionCode(TransactionStatusEnum.CHECKING.getValue())
    			.transactionStatus(TransactionStatusEnum.CHECKING)
    			.build();
    }
}