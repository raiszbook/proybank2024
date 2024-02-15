package nttdata.mstransaction.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {
    @Id
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private TransactionType type;
    private LocalDateTime timestamp;

}