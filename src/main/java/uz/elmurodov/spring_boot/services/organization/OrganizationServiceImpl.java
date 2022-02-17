package uz.elmurodov.spring_boot.services.organization;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.entity.file.Uploads;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.mapper.OrganizationMapper;
import uz.elmurodov.spring_boot.reposiroty.OrganizationRepository;
import uz.elmurodov.spring_boot.services.AbstractService;
import uz.elmurodov.spring_boot.services.file.FileStorageService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.organization.OrganizationValidator;

import java.util.List;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository,
        OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    private final FileStorageService fileStorageService;
    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository,  OrganizationMapper mapper, OrganizationValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) {
        Organization organization = createPath(createDto,createDto.getLogo());
        repository.save(organization);
        return organization.getId();
    }
    @SneakyThrows
    public Organization createPath(OrganizationCreateDto dto, @NonNull MultipartFile file) {
        Organization organization = mapper.fromCreateDto(dto);
        Uploads uploads = fileStorageService.store(file);
        organization.setLogo(uploads.getPath());
        return organization;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(organization);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
