package app.block8_upload_download_files.content.file.infrastructure.repository.impl;

import app.block8_upload_download_files.content.file.domain.entity.File;
import app.block8_upload_download_files.content.file.domain.repository.FileRepository;
import app.block8_upload_download_files.content.file.infrastructure.repository.jpa.FileRepositoryJpa;
import app.block8_upload_download_files.content.file.infrastructure.repository.jpa.entity.FileJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {

    private final FileRepositoryJpa fileRepositoryJpa;


    @Override
    public Long save(File file) {

        FileJpa fileJpa = new FileJpa();
        fileJpa.setName(file.getName());
        fileJpa.setCategory(file.getCategory());
        fileJpa.setUpdatedDate(file.getUpdatedDate());

        return fileRepositoryJpa.save(fileJpa).getId();
    }
}
