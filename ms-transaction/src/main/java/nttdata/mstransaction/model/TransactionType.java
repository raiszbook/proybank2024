package nttdata.mstransaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    TRANSFER,
    PAY
}
