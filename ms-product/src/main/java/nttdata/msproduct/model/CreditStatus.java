package nttdata.msproduct.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CreditStatus {

        PENDING,
        PAID,
        OVERDUE
    }
