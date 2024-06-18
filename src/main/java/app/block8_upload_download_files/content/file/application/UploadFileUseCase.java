package app.block8_upload_download_files.content.file.application;

import app.block8_upload_download_files.content.file.domain.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

    File uploadFile(MultipartFile file, String category);
}
