package nttdata.msconsultationratebs.business;

import nttdata.msconsultationratebs.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import nttdata.msconsultationratebs.model.Consultation;

@Service
public class ConsultationService {


    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Flux<Consultation> getAllClients() {
        return consultationRepository.findAll();
    }

    public Mono<Consultation> getClientById(String id) {
        return consultationRepository.findById(id);
    }

    public Mono<Consultation> createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Mono<Consultation> updateConsultation(String id, Consultation consultation) {
        return consultationRepository.findById(id)
                .flatMap(existingConsultation -> {
                    return consultationRepository.save(existingConsultation);
                });
    }

    public Mono<Void> deleteConsultation(String id) {
        return consultationRepository.deleteById(id);
    }
}