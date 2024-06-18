package app.block8_upload_download_files.content.file.infrastructure.repository.jpa;

import app.block8_upload_download_files.content.file.infrastructure.repository.jpa.entity.FileJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepositoryJpa extends JpaRepository<FileJpa, Long> {
}
