package uz.elmurodov.spring_boot.services.project;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.mapper.ProjectMapper;
import uz.elmurodov.spring_boot.reposiroty.ProjectRepository;
import uz.elmurodov.spring_boot.services.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectValidator;

import java.util.List;

/**
 * @author Amonov Bunyod, ср 16.02.2022 15:54 .
 */

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator> implements ProjectService {
    protected ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }


    @Override
    public Long create(ProjectCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ProjectDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
