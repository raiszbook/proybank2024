package nttdata.msconsultationratebs.repository;

import nttdata.msconsultationratebs.model.Consultation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConsultationRepository extends ReactiveMongoRepository<Consultation, String> {
}
