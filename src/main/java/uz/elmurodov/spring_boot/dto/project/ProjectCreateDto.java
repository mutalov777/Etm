package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.dto.Dto;

@Getter
@Setter
@Builder
public class ProjectCreateDto implements Dto {
    private String name;
    private MultipartFile tzPath;

    public ProjectCreateDto(String name, MultipartFile tzPath) {
        this.name = name;
        this.tzPath = tzPath;
    }
}
