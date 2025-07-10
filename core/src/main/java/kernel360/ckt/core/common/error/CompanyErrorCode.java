package kernel360.ckt.core.common.error;

import lombok.Getter;

@Getter
public enum CompanyErrorCode implements ErrorCode {
    COMPANY_NOT_FOUND("404", "회사 정보를 찾을 수 없습니다. (ID - %d)", 500),
    ;

    private final String code;
    private final String message;
    private final int status;

    CompanyErrorCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
