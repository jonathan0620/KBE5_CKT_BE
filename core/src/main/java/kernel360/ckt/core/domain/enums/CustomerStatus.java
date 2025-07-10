package kernel360.ckt.core.domain.enums;

import lombok.Getter;

@Getter
public enum CustomerStatus {
    ACTIVE("활성"),
    WITHDRAWN("비활성");

    private final String value;

    CustomerStatus(String value) {
        this.value = value;
    }
}
