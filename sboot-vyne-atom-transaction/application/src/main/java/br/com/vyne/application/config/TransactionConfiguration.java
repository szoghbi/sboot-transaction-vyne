package br.com.vyne.application.config;

import org.jdbi.v3.core.Jdbi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.vyne.application.infrastructure.database.TransactionRepositoryImpl;
import br.com.vyne.domain.port.TransactionRepository;
import br.com.vyne.domain.service.TransactionService;

/**
 * Configuration base class.
 */
@Configuration
public class TransactionConfiguration {

	@Bean
    public TransactionRepository transactionRepository(Jdbi jdbi) {
    	return jdbi.onDemand( TransactionRepositoryImpl.class );
    }

    @Bean
    public TransactionService transactionService(TransactionRepository repository) {
    	return new TransactionService(repository);
    }
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
