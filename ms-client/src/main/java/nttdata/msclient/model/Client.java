package nttdata.msclient.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client")
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private IdentificationType documentType;
    private String documentNumber;
    private ClientType clientType;


}