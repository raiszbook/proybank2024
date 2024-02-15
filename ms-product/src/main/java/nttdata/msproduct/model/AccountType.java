package nttdata.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
    SAVINGS,
    CHECKING,
    FIXED_TERM;

}