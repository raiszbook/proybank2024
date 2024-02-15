package nttdata.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "creditcard")
public class CreditCard {
    @Id
    private Long id;
    private Long clientId;
    private String number;
    private Double limit;
    private Double balance;
    private CreditCardStatus status;
}
