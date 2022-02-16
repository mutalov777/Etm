package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;

import java.util.Date;

@Getter
@Setter
public class ProjectDto extends GenericDto {
    private String name;
    private String tzPath;
    private Boolean closed;
    private Date createdat;
    private Long createdby;


    @Builder(builderMethodName = "childBuilder")

    public ProjectDto(Long id, String name, String tzPath, Boolean closed, Date createdat, Long createdby) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.closed = closed;
        this.createdat = createdat;
        this.createdby = createdby;
    }
}
