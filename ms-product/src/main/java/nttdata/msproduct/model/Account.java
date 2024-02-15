package nttdata.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private Long clientId;
    private Long productId;
    // Campo para indicar la cuenta principal
    private Boolean isPrincipal; //  cuenta principal

}
