package app.block8_upload_download_files.content.file.domain.repository;

import app.block8_upload_download_files.content.file.domain.entity.File;

public interface FileRepository {

    Long save(File file);
}
