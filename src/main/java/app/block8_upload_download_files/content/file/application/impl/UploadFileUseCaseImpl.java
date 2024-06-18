package app.block8_upload_download_files.content.file.application.impl;

import app.block8_upload_download_files.content.file.application.UploadFileUseCase;
import app.block8_upload_download_files.content.file.domain.entity.File;
import app.block8_upload_download_files.content.file.domain.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UploadFileUseCaseImpl implements UploadFileUseCase {

    private final FileRepository fileRepository;


    @Override
    public File uploadFile(MultipartFile file, String category) {
        try {
            // Guardar el archivo en el sistema de archivos
            String fileName = file.getOriginalFilename();
            String path = "uploads/" + fileName;
            file.transferTo(new java.io.File(path));

            // Guardar los metadatos en la base de datos
            File newFile = new File(fileName, LocalDate.now(), category);
            Long idFile = fileRepository.save(newFile);
            newFile.setId(idFile);

            return newFile;
        } catch (IOException e) {
            // Manejar cualquier error de IO
            e.printStackTrace();
            return null;
        }
    }
}
