package nttdata.msproduct.repository;

import nttdata.msproduct.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

    Flux<Account> findByClientId(Long clientId);
}
