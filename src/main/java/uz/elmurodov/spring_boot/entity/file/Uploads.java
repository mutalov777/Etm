package uz.elmurodov.spring_boot.entity.file;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.Resource;

import java.util.UUID;

@Data
@Builder
public class Uploads {
    private UUID id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private String path;
    private Resource resource;
}
