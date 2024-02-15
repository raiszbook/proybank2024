package nttdata.msproduct.controller;

import nttdata.msproduct.business.AccountService;
import nttdata.msproduct.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/accounts")
public class AccountController {

@Autowired
private AccountService accountService;

@GetMapping("/client/{clientId}")
public Flux<Account> getAccountByClientId(@PathVariable Long clientId) {
    return accountService.getAccountByClient(clientId);
}


// Obtener todos los clientes
@GetMapping
public Flux<Account> getAllAccounts() {
    return accountService.getAllAccounts();
}

// Obtener un cliente por su ID
@GetMapping("/{id}")
public Mono<Account> getAccountById(@PathVariable String id) {
    return accountService.getAccountById(id);
}

// Crear un nuevo cliente
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Mono<Account> createAccount(@RequestBody Account account) {
    return accountService.createAccount(account);
}

// Actualizar un cliente existente
@PutMapping("/{id}")
public Mono<Account> updateAccount(@PathVariable String id, @RequestBody Account account) {
    return accountService.updateAccount(id, account);
}

// Borrar un cliente
@DeleteMapping("/{id}")
public Mono<Void> deleteAccount(@PathVariable String id) {
    return accountService.deleteAccount(id);
}
}

