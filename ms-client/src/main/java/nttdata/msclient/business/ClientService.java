package nttdata.msclient.business;

import nttdata.msclient.model.Client;
import nttdata.msclient.model.ClientType;
import nttdata.msclient.model.IdentificationType;
import nttdata.msclient.repository.ClientRepository;
import nttdata.msproduct.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    private final WebClient webClient;

    //Comunicacion entre microservicios
    @Autowired
    public ClientService(ClientRepository clientRepository, WebClient.Builder webClientBuilder) {
        this.clientRepository = clientRepository;
        this.webClient = webClientBuilder.baseUrl("https://localhost:8080/ms-client").build();
    }

    public Mono<List<Account>> getClientAccounts(Long clientId){
        return webClient.get()
                .uri("/accounts/client/{clientId}",clientId)
                .retrieve()
                .bodyToFlux(Account.class)
                .collectList();
    }


    public Flux<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Mono<Client> getClientById(String id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    public Mono<Client> updateClient(String id, Client client) {
        return clientRepository.findById(id)
                .flatMap(existingClient -> {
                    existingClient.setFirstName(client.getFirstName());
                    existingClient.setLastName(client.getLastName());
                    existingClient.setDocumentType(client.getDocumentType());
                    existingClient.setDocumentNumber(client.getDocumentNumber());
                    existingClient.setClientType(client.getClientType());
                    return clientRepository.save(existingClient);
                });
    }

    public Mono<Void> deleteClient(String id) {
        return clientRepository.deleteById(id);
    }
}
