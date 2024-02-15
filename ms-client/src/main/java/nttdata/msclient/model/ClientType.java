package nttdata.msclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientType {
    PERSONAL("P"),
    BUSINESS("B"),
    VIP("V"),
    PYME("PY");

    private final String code;
}
