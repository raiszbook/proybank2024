package nttdata.mswallet.model;


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
@Document(collection = "wallet")
public class Wallet {

    @Id
    private Long id;
    private String documentNumber;
    private Long identificationTypeId;
    private String phoneNumber;
    private String imei;
    private String email;
    private BigDecimal balance;
    private Long debitCardId;

}
