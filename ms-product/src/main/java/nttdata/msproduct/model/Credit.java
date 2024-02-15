package nttdata.msproduct.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credit")
public class Credit {
    @Id
    private Long id;
    private Double amount;
    private BigDecimal balance;
    private LocalDate dueDate;
    private LocalDate openingDate;
    private int installments;//cuotas
    private Long productId;
    private Long clientId;
    private CreditStatus status; // Nuevo campo para representar el estado del crédito
}