package kernel360.ckt.auth.infra;

import kernel360.ckt.auth.domain.RefreshTokenRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenJpaRepository extends JpaRepository<RefreshTokenEntity, Long>, RefreshTokenRepository {
}
