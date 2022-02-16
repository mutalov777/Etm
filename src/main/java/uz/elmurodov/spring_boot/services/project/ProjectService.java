package uz.elmurodov.spring_boot.services.project;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.services.GenericCrudService;


public interface ProjectService extends GenericCrudService<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long>  {
}
