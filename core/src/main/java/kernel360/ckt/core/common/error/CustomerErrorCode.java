package kernel360.ckt.core.common.error;

import lombok.Getter;

@Getter
public enum CustomerErrorCode implements ErrorCode {
    CUSTOMER_NOT_FOUND("404", "해당 고객을 찾을 수 없습니다.", 404),
    INVALID_CUSTOMER_TYPE("400", "유효하지 않은 고객 유형입니다.", 400),
    INVALID_PHONE_NUMBER("400", "유효하지 않은 전화번호 형식입니다.", 400),
    LICENSE_NUMBER_REQUIRED("400", "면허번호는 필수 입력 항목입니다.", 400),
    INACTIVE_CUSTOMER("403", "비활성화된 고객입니다.", 403),
    UNAUTHORIZED_CUSTOMER_ACCESS("403", "해당 고객 정보에 접근할 수 없습니다.", 403),
    CUSTOMER_CREATION_FAILED("500", "고객 생성 중 오류가 발생했습니다.", 500),
    CUSTOMER_UPDATE_FAILED("500", "고객 수정 중 오류가 발생했습니다.", 500);

    private final String code;
    private final String message;
    private final int status;

    CustomerErrorCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
