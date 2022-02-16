package uz.elmurodov.spring_boot.services.project;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.services.GenericCrudService;

public interface ProjectServise extends GenericCrudService<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long> {
}
