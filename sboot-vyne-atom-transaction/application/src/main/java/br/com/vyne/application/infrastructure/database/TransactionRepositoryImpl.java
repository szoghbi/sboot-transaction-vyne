package br.com.vyne.application.infrastructure.database;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import br.com.vyne.domain.dto.TransactionDto;
import br.com.vyne.domain.dto.TransactionResponseDto;
import br.com.vyne.domain.port.TransactionRepository;


/**
 * Domain repository implementation.
 */
@Repository
public interface TransactionRepositoryImpl extends TransactionRepository {

    @UseClasspathSqlLocator
    @SqlQuery
    @Override
    List<TransactionResponseDto> listTransactions();

	@UseClasspathSqlLocator
    @SqlQuery
    @Override
    List<TransactionResponseDto> findByCurrency(@Bind("currency") String currency);

    @UseClasspathSqlLocator
    @SqlUpdate
    @Override
    void removeTransactions(@Bind("id") Long id);

    @UseClasspathSqlLocator
    @SqlUpdate
    @GetGeneratedKeys
    @Override
    Integer addTransactions(@BindBean TransactionDto transactions);
}