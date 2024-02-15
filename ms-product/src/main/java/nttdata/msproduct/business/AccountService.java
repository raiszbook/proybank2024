package nttdata.msproduct.business;

import lombok.AllArgsConstructor;
import nttdata.msproduct.model.Account;
import nttdata.msproduct.model.AccountType;
import nttdata.msproduct.repository.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;


@AllArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Flux<Account> getAccountByClient(Long clientId){
        return accountRepository.findByClientId(clientId);
    }

    public Flux<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Mono<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Mono<Account> updateAccount(String id, Account account) {
        return accountRepository.findById(id)
                .flatMap(existingAccount -> {
                    existingAccount.setAccountNumber(account.getAccountNumber());
                    existingAccount.setAccountType(account.getAccountType());
                    existingAccount.setBalance(account.getBalance());
                    existingAccount.setClientId(account.getClientId());
                    existingAccount.setProductId(account.getProductId());
                    existingAccount.setIsPrincipal(account.getIsPrincipal());
                    return accountRepository.save(existingAccount);
                });
    }

    public Mono<Void> deleteAccount(String id) {
        return accountRepository.deleteById(id);
    }
}