package nttdata.msclient.controller;


import nttdata.msclient.business.ClientService;
import nttdata.msclient.model.Client;
import nttdata.msproduct.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Obtener todos los clientes
    @GetMapping
    public Flux<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Obtener un cliente por su ID
    @GetMapping("/{id}")
    public Mono<Client> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    // Crear un nuevo cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Client> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public Mono<Client> updateClient(@PathVariable String id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    // Borrar un cliente
    @DeleteMapping("/{id}")
    public Mono<Void> deleteClient(@PathVariable String id) {
        return clientService.deleteClient(id);
    }

    @GetMapping("/{id}/accounts")
    public Flux<Account> getClientAccounts(@PathVariable Long id){
        return clientService.getClientAccounts(id);
    }
}