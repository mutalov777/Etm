package uz.elmurodov.spring_boot.services.file;


import com.google.common.collect.Lists;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.entity.file.Uploads;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Service
public class FileStorageService {
    public static final String TZ_UPLOUD_FILE = "/unicorn/uploads/b4/lib/";
    public static final Path PATH = Paths.get(TZ_UPLOUD_FILE);
    public static final List<Uploads> UPLOADS = Lists.newArrayList();


    @PostConstruct
    public void init() {
        if (!Files.exists(PATH)) {
            try {
                Files.createDirectories(PATH);
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
            }
        }
    }

    @SneakyThrows
    public Uploads store(@NonNull MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String generatedName = "%s.%s".formatted(System.currentTimeMillis(), extension);
        Path rootPath = Paths.get(TZ_UPLOUD_FILE, generatedName);
        Files.copy(file.getInputStream(), rootPath, StandardCopyOption.REPLACE_EXISTING);
        Uploads uploadedFile = Uploads.builder().originalName(originalFilename).generatedName(generatedName).contentType(file.getContentType()).path("/uploads/" + generatedName).size(file.getSize()).build();
        UPLOADS.add(uploadedFile);

        return uploadedFile;
    }

    public Uploads storeAsync(@NonNull MultipartFile file) {
        // TODO: 2/14/2022 need to write logic to store file asynchroniously
        return null;
    }


    public Uploads loadResource(@NonNull String fileName) {
        val searchingFile = UPLOADS.stream().filter(file -> file.getGeneratedName().equals(fileName)).findFirst().orElseThrow(() -> {
            throw new RuntimeException("File Not Found");
        });
        FileSystemResource resource = new FileSystemResource(TZ_UPLOUD_FILE + fileName);
        searchingFile.setResource(resource);
        return searchingFile;
    }
}
