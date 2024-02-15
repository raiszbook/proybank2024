package nttdata.msclient.business;

import nttdata.msclient.model.Client;
import nttdata.msclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
                    existingClient.setName(client.getName());
                    existingClient.setAge(client.getAge());
                    return clientRepository.save(existingClient);
                });
    }

    public Mono<Void> deleteClient(String id) {
        return clientRepository.deleteById(id);
    }
}
