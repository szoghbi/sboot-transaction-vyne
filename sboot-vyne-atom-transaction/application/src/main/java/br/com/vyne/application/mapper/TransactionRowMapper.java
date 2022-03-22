package br.com.vyne.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import br.com.vyne.common.util.DateUtil;
import br.com.vyne.domain.dto.TransactionResponseDto;

@Component
public class TransactionRowMapper implements RowMapper<TransactionResponseDto> {

	@Override
	public TransactionResponseDto map(ResultSet rs, StatementContext ctx) throws SQLException {

		return TransactionResponseDto.builder()
				.id(rs.getInt("id"))
				.transactionDate(DateUtil.convertDateToLocalDate(rs.getTimestamp("transactionDate")))
				.fullName(rs.getString("fullName"))
				.amount(rs.getBigDecimal("amount"))
				.currency(rs.getString("currency"))
				.transactionCode(rs.getInt("transactionCode"))
				.transactionStatus(rs.getString("transactionStatus"))
				.build();
	}
}