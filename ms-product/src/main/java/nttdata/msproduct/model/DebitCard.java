package nttdata.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "debitcard")
public class DebitCard {
    @Id
    private Long id;
    private Long clientId;
    private Account account;
    private String cardNumber;
    private LocalDate expirationDate;
    private Double limit;
    private BigDecimal balance;
    private LocalDate creationDate;
    private LocalDate lastUseDate;
}
