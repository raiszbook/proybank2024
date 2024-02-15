package nttdata.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {


@Id
private Long id;
private String name;
private Double interestRate;
private ProductType type;
private List<Condition> conditions;

}