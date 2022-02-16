package uz.elmurodov.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.project.Project;

/**
 * @author Amonov Bunyod, ср 16.02.2022 15:57 .
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto> {

}
