package kernel360.ckt.auth.infra;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "token")
@Entity
public class RefreshTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(nullable = false)
    private String token;

    @Column(name = "issue_at", nullable = false)
    private LocalDateTime issueAt;

    @Column(name = "expire_at")
    private LocalDateTime expireAt;

    @Column(nullable = false)
    private String status;

    private RefreshTokenEntity(Long companyId, String token, LocalDateTime issueAt, LocalDateTime expireAt, String status) {
        this.companyId = companyId;
        this.token = token;
        this.issueAt = issueAt;
        this.expireAt = expireAt;
        this.status = status;
    }

    public static RefreshTokenEntity create(Long companyId, String token, LocalDateTime issueAt, LocalDateTime expireAt, String status) {
        return new RefreshTokenEntity(companyId, token, issueAt, expireAt, status);
    }

    public void updateToken(String newToken, LocalDateTime newIssueAt, LocalDateTime newExpireAt) {
        this.token = newToken;
        this.issueAt = newIssueAt;
        this.expireAt = newExpireAt;
    }

    public void markAsExpired() {
        this.status = "EXPIRED";
    }
}
