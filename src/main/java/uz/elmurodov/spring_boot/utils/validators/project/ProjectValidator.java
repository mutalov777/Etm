package uz.elmurodov.spring_boot.utils.validators.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.exceptions.ValidationException;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.AbstractValidator;

/**
 * @author Amonov Bunyod, ср 16.02.2022 15:59 .
 */
@Component
public class ProjectValidator extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto, Long> {

    @Autowired
    protected ProjectValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }



    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectUpdateDto cd) throws ValidationException {

    }
}
