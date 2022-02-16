package uz.elmurodov.spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Convert(disableConversion = true)
    @Column(name = "createdat")
    private Date createdat;

    @Column(name = "createby", nullable = false)
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updatedat")
    private Date updatedat;

    @Column(name = "updateby")
    private Long updateby;

    public Auditable(Long id) {
        this.id = id;
        this.createdat = new Date();
    }
}