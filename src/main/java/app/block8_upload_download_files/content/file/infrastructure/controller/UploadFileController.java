package app.block8_upload_download_files.content.file.infrastructure.controller;

import app.block8_upload_download_files.content.file.application.UploadFileUseCase;
import app.block8_upload_download_files.content.file.domain.entity.File;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadFileController {

    private final UploadFileUseCase uploadFileUseCase;

    @Value("${upload.directory}")
    private String uploadDirectory;


    @PostMapping("/{type}")
    public ResponseEntity<File> uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable("type") String category
    ) {
        File uploadedFile = uploadFileUseCase.uploadFile(file, category);
        return ResponseEntity.ok(uploadedFile);
    }

    @PostMapping("/upload/{extension}")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @PathVariable String extension) {
        // Verificar si el archivo está vacío
        if (file.isEmpty()) {
            return new ResponseEntity<>("Archivo no válido", HttpStatus.BAD_REQUEST);
        }

        // Obtener el nombre del archivo
        String fileName = file.getOriginalFilename();

        // Obtener la extensión del archivo subido
        String uploadedExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        // Verificar si la extensión coincide con la proporcionada en el PathVariable
        if (!uploadedExtension.equalsIgnoreCase(extension)) {
            return new ResponseEntity<>("La extensión del archivo no coincide", HttpStatus.BAD_REQUEST);
        }

        try {
            // Guardar el archivo en el directorio especificado
            byte[] bytes = file.getBytes();
            java.nio.file.Path path = java.nio.file.Paths.get(uploadDirectory + fileName);
            java.nio.file.Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al subir el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Archivo subido correctamente", HttpStatus.OK);
    }
}

