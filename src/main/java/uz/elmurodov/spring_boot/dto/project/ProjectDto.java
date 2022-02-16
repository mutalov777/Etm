package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;

@Getter
@Setter
public class ProjectDto extends GenericDto {
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name) {
        super(id);
        this.name = name;
    }
}
