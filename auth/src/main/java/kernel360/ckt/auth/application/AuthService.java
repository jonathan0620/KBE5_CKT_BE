package kernel360.ckt.auth.application;

import kernel360.ckt.auth.domain.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RefreshTokenRepository refreshTokenRepository;

    // 예시 메서드
    public void testFindByCompanyId(Long companyId) {
        refreshTokenRepository.findByCompanyId(companyId)
            .ifPresent(token -> {
                System.out.println("DB에 저장된 토큰 = " + token.getToken());
            });
    }
}
