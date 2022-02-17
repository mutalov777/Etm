package uz.elmurodov.spring_boot.services.project;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.file.Uploads;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.mapper.ProjectMapper;
import uz.elmurodov.spring_boot.reposiroty.ProjectRepository;
import uz.elmurodov.spring_boot.services.AbstractService;
import uz.elmurodov.spring_boot.services.file.FileStorageService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectValidator;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService {
    private final FileStorageService fileStorageService;

    @Autowired
    protected ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        Project project = createPath(createDto, createDto.getTzPath());
        repository.save(project);
        return project.getId();
    }

    @SneakyThrows
    public Project createPath(final ProjectCreateDto dto, @NonNull MultipartFile file) {
        Project project = mapper.fromCreateDto(dto);
        Uploads uploads = fileStorageService.store(file);
        project.setTzPath(uploads.getPath());
        return project;
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
         return mapper.toDto(repository.findAll());
    }

    @Override
    public ProjectDto get(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
