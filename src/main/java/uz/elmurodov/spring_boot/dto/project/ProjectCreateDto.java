package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.Dto;

@Getter
@Setter
@Builder
public class ProjectCreateDto implements Dto {
    private String name;
    private String tzPath;

    public ProjectCreateDto(String name, String tzPath) {
        this.name = name;
        this.tzPath = tzPath;
    }
}
